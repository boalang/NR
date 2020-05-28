# Boa Sample Queries on the NR database


## Frequencies of protein functions if tax assignments > 10
```
s: Sequence = input;
protOut : output sum [string] of int;

if (len(s.annotation) > 10){
  foreach(i:int; def(s.annotation[i]))
   protOut [s.annotation[i].defline] << 1;
}
```


*  Top 1000 proteins 

```
s: Sequence = input;
protOut : output top(1000) of string weight int;

if (len(s.annotation) > 10){
  foreach(i:int; def(s.annotation[i]))
   if (strfind("[",s.annotation[i].defline)> 0)
    protOut << [trim(substring(s.annotation[i].defline, 0, strfind("[",s.annotation[i].defline)))] weight 1;
}
```




## all cluster and annotation information for a list of given clusters in 95 % similarity
```
s: Sequence = input;

#clstrOut : output collection [string][string] of string;
clstrOut : output collection [string][int][string][int][int][int][int][int][int] of int;

cids := {
"13741561", "26559833", "37311095","64827049" , "69434225", "70499074", "73557584", "76939270", "81606138", "82243640"
};


getDefline := function(seq: Sequence):string {
  strDefline : string;

  foreach(i:int; def(s.annotation[i])){
      strDefline = strDefline + s.annotation[i].keyID + " ^{ " + s.annotation[i].tax_id + " " + s.annotation[i].tax_name + " }^ " + s.annotation[i].defline + " ^A " ;
 }
 return strDefline;
};

foreach(j:int; def(s.cluster[j]))
  if (s.cluster[j].similarity==95){
    for (i := 0; i < len(cids); i++) {
            if (s.cluster[j].cid ==cids[i])
                        #clstrOut[s.cluster[j].cid][s.seqid] <<  getDefline(s);
                        clstrOut [s.seqid][s.cluster[j].similarity][s.cluster[j].cid][s.cluster[j].length][s.cluster[j].seq_start][s.cluster[j].seq_stop]
                        [s.cluster[j].rep_start][s.cluster[j].seq_stop][s.cluster[j].match] <<  1;
        }
  }
```



## Tax Frequencies for each cluster in different similarity level
```
s: Sequence = input;
clstrOut : output sum [int][string][string] of int;

foreach(i:int; def(s.annotation[i]))
   foreach(j:int; def(s.cluster[j]))
   	 clstrOut[s.cluster[j].similarity][s.cluster[j].cid] [s.annotation[i].tax_name]<< 1;
```



## list of all taxonomies for each cluster with all similarity levels
```
s: Sequence = input;
clstrOut : output collection [int][string] of string;

getTaxList := function(seq: Sequence):string {
  strTaxs : string;  
 foreach(i:int; def(s.annotation[i])){
  #if (s.annotation[i].tax_name !=""){
  # if (! match(string(s.annotation[i].tax_name), string(strTaxs)))
      strTaxs = strTaxs + s.annotation[i].tax_name + "$";
  # }
 }
 return strTaxs;
};

taxList := getTaxList(s);
#if (match(`Glycine max`, getTaxList(s) ))
# taxList = taxList+ "@";

foreach(i:int; def(s.cluster[i]))
  clstrOut [s.cluster[i].similarity][s.cluster[i].cid] << s.seqid +": " + taxList;

```
### NB: match doesn't work on Ubuntu but works fine on Mac
* current query returns all the tax_names

* location on bridges: ``` /pylon5/mc5fr5p/hbagheri/09_Hadoop/allClstersTaxs/part-r-00000```



## sum of protein length for each similarity level
```
s: Sequence = input;
counts: output sum[int] of int;

# iterates over all clusters
 foreach(i:int; def(s.cluster[i])){
        counts[s.cluster[i].similarity] << s.cluster[i].length;
    }
 };
```

## clusters tax list
```
s: Sequence = input;
clstrOut : output collection [int][string] of string;

getTaxList := function(seq: Sequence):string {
  strTaxs : string;  
 foreach(i:int; def(s.annotation[i])){
   if (!match(s.annotation[i].tax_name, strTaxs))
      strTaxs = strTaxs + s.annotation[i].tax_name + " ";
 }
 return strTaxs;
};

taxList := getTaxList(s);
if (match(`glycine max`, getTaxList(s) ))
 taxList = taxList+ "@";

foreach(i:int; def(s.cluster[i]))
  clstrOut [s.cluster[i].similarity][s.cluster[i].cid] << s.seqid +":" + taxList;

```




## Number of proteins for different size
```
s: Sequence = input;
counts: output sum[int] of int;

foreach(i:int; def(s.cluster[i])){
  if (s.cluster[i].similarity==95)
	counts [s.cluster[i].length] <<  1;
}
```

### Output on the full datasets
```
#location: pylon5/mc5fr5p/hbagheri/09_Hadoop/protSize/part-r-00000
# it was modified to pylon5/mc5fr5p/hbagheri/09_Hadoop/protSize/part-r-00000_modified
# by protsize.py script
# the plot was generated in the jupter notebook
# location: https://github.com/ISUgenomics/BoaISMB/blob/master/jupyter%20Notebooks/prot_size.ipynb
```


## number of **all taxonomies** in a defline for each similarity level

* /pylon5/mc5fr5p/hbagheri/09_Hadoop/sizeCluster.boa

```
s: Sequence = input;
counts: output sum[int] of int;

has_taxID :=false;

# iterates over all clusters and then if tax_name is not null emits 1 to the reducer
 foreach(i:int; def(s.cluster[i])){
      foreach(j:int; def(s.annotation[j])){
       if (s.annotation[j].tax_id !="" && s.annotation[j].keyID ==s.seqid)
         has_taxID = true;
      }
      if (has_taxID==true)     
        counts[s.cluster[i].similarity] << 1;

 };

 ```
 ### output on full datasets
 ```
 counts[65] = 39802000
 counts[70] = 45928097
 counts[75] = 53057922
 counts[80] = 61483288
 counts[85] = 72092030
 counts[90] = 87938987
 counts[95] = 173692632
 ```
 * location : /09_Hadoop/ClustersTaxSim/part-r-00000
 * run time: 7.5 min


## number of **primary taxonomy** in a defline for each similarity level
```

```
 ### Output on the full datasets:
 ```
 ?
 ```
 * get the unique primary tax list by ```wc -l``` as follows:
 ```
 [hbagheri@login006 ClustersTaxSim]$ grep "counts\[95\]" part-r-00000 | wc -l
744237
[hbagheri@login006 ClustersTaxSim]$ grep "counts\[90\]" part-r-00000 | wc -l
231410
[hbagheri@login006 ClustersTaxSim]$ grep "counts\[85\]" part-r-00000 | wc -l
155471
[hbagheri@login006 ClustersTaxSim]$ grep "counts\[80\]" part-r-00000 | wc -l
123299
[hbagheri@login006 ClustersTaxSim]$ grep "counts\[75\]" part-r-00000 | wc -l
106039
[hbagheri@login006 ClustersTaxSim]$ grep "counts\[70\]" part-r-00000 | wc -l
95704
[hbagheri@login006 ClustersTaxSim]$ grep "counts\[65\]" part-r-00000 | wc -l
88850
```


 * location  on XSEDE: ```/09_Hadoop/  ```
 * run time: 7.1 minutes

## all clusters belong to a specific function like SCN:
```
s: Sequence = input;
counts_protein: output collection[string][string] of int;

foreach(i:int; def(s.cluster[i])){
  if (s.cluster[i].similarity==95){
    foreach(j:int; def(s.annotation[j]))
	if (match(`SCN`,s.annotation[j].defline))
	  counts_protein [s.seqid][s.cluster[i].cid] <<1;
  }
}
```
### output on the full dataset
```
```
* location on bridges```../09_Hadoop/scn/part-0-00000```
* #of lines in the output:281220 ```wc -l ```





## phylum: number of proteins for each phylum
```
# search for Streptococcus
s: Sequence = input;
phylCount: output sum [string] of int;

taxs := {
    "Acanthocephala", "Acoelomorpha","Annelida","Arthropoda","Brachiopoda","Bryozoa","Chaetognatha","Chordata",
    "Cnidaria","Ctenophora","Cycliophora", "Echinodermata","Entoprocta", "Gastrotricha","Gnathostomulida", "Hemichordata","Kinorhyncha",
    "Loricifera","Micrognathozoa", "Mollusca","Nematoda", "Nematomorpha","Nemertea", "Onychophora","Orthonectida", "Phoronida",
    "Placozoa", "Platyhelminthes","Porifera", "Priapulida","Rhombozoa", "Rotifera","Sipuncula", "Tardigrada","Xenacoelomorpha",

    "Anthocerotophyta","Bryophyta", "Charophyta","Chlorophyta", "Cycadophyta","Ginkgophyta", "Glaucophyta","Gnetophyta", "Lycopodiophyta",
    "Lycophyta", "Magnoliophyta","Marchantiophyta", "Hepatophyta","Pinophyta", "Coniferophyta","Pteridophyta", "Rhodophyta",

    "Ascomycota", "Basidiomycota","Blastocladiomycota", "Chytridiomycota","Glomeromycota", "Microsporidia","Neocallimastigomycota","Zygomycota",

    "Amoebozoa", "Bigyra","Cercozoa", "Choanozoa","Ciliophora", "Cryptista","Euglenozoa", "Foraminifera","Haptophyta", "Loukozoa",
    "Metamonada", "Microsporidia","Myzozoa", "Mycetozoa","Ochrophyta", "Oomycota","Percolozoa", "Radiozoa","Sarcomastigophora", "Sulcozoa",

    "Acidobacteria", "Actinobacteria","Aquificae", "Armatimonadetes","Bacteroidetes", "Caldiserica","Chlamydiae", "Chlorobi",
    "Chloroflexi", "Chrysiogenetes","Cyanobacteria", "Deferribacteres","Deinococcus-Thermus", "Dictyoglomi","Elusimicrobia",
    "Fibrobacteres","Firmicutes", "Fusobacteria","Gemmatimonadetes", "Lentisphaerae","Nitrospira", "Planctomycetes","Proteobacteria",
     "Spirochaetes","Synergistetes", "Tenericutes","Thermodesulfobacteria", "Thermotogae","Verrucomicrobia",

     "Crenarchaeota","Euryarchaeota", "Korarchaeota","Nanoarchaeota", "Thaumarchaeota"
};

for (j := 0; j < len(taxs); j++) {
	exists(i: int; match(taxs[j], s.annotation[i].tax_name))
	 	 phylCount [taxs[j]] << 1;
 }
```
* I used this link to extract the phylum names:
https://en.wikipedia.org/wiki/Phylum#Known_phyla
* here we have 111 phylums from this webpage but the NR annotations we have 63 phylums
* run time: 19 minutes
* we can use FigTree to annotate the tree: https://github.com/rambaut/figtree/releases



### output on full datasets

```
phylCount[Acanthocephala] = 3
phylCount[Acidobacteria] = 897495
phylCount[Actinobacteria] = 248761
phylCount[Amoebozoa] = 4
phylCount[Annelida] = 72
phylCount[Aquificae] = 4046
phylCount[Armatimonadetes] = 72795
phylCount[Arthropoda] = 205
phylCount[Ascomycota] = 35
phylCount[Bacteroidetes] = 444330
phylCount[Basidiomycota] = 201
phylCount[Brachiopoda] = 1
phylCount[Bryophyta] = 2
phylCount[Bryozoa] = 1
phylCount[Caldiserica] = 7174
phylCount[Cercozoa] = 5
phylCount[Chaetognatha] = 16
phylCount[Chlamydiae] = 15300
phylCount[Chlorobi] = 34719
phylCount[Chloroflexi] = 314776
phylCount[Chlorophyta] = 148
phylCount[Chordata] = 7
phylCount[Chytridiomycota] = 20
phylCount[Cnidaria] = 9
phylCount[Crenarchaeota] = 21738
phylCount[Ctenophora] = 57
phylCount[Cyanobacteria] = 54980
phylCount[Elusimicrobia] = 109559
phylCount[Euryarchaeota] = 59132
phylCount[Fibrobacteres] = 1685
phylCount[Firmicutes] = 264960
phylCount[Foraminifera] = 10
phylCount[Fusobacteria] = 476
phylCount[Gemmatimonadetes] = 185787
phylCount[Haptophyta] = 43
phylCount[Hemichordata] = 4
phylCount[Korarchaeota] = 21092
phylCount[Lentisphaerae] = 46254
phylCount[Magnoliophyta] = 56
phylCount[Microsporidia] = 6
phylCount[Mollusca] = 35
phylCount[Nanoarchaeota] = 3322
phylCount[Nematoda] = 38
phylCount[Nematomorpha] = 1
phylCount[Nemertea] = 51
phylCount[Nitrospira] = 194651
phylCount[Onychophora] = 1
phylCount[Placozoa] = 181
phylCount[Planctomycetes] = 158406
phylCount[Platyhelminthes] = 8
phylCount[Porifera] = 32
phylCount[Proteobacteria] = 165508
phylCount[Rhodophyta] = 636
phylCount[Rotifera] = 4
phylCount[Sipuncula] = 8
phylCount[Spirochaetes] = 78111
phylCount[Synergistetes] = 3631
phylCount[Tardigrada] = 6
phylCount[Tenericutes] = 23128
phylCount[Thaumarchaeota] = 36553
phylCount[Thermodesulfobacteria] = 8029
phylCount[Thermotogae] = 10838
phylCount[Verrucomicrobia] = 464632
```
## get tax frequencies based on seqIDs and for each similarity level
```
s: Sequence = input;
clstrOut : output collection [int][string] of string;

getTaxList := function(seq: Sequence):string {
  tax_names := "";
  tax_ids :="";

  foreach(i:int; def(s.annotation[i])){
          if (s.annotation[i].tax_name !=""){
            tax_names = tax_names + s.annotation[i].tax_name + "$";     
            tax_ids = tax_ids + s.annotation[i].tax_id + " ";   

          }
  }
 return tax_ids + " == $" + tax_names;
};

foreach(i:int; def(s.cluster[i]))
  clstrOut [s.cluster[i].similarity][s.seqid] <<  getTaxList(s);
```
### sample Output on the entire database
```
clstrOut[65][1C1F] = 7943 7943  == $Conger myriaster$Conger myriaster$
clstrOut[65][1C3Q] = 1423 1423 1423  == $Bacillus subtilis$Bacillus subtilis$Bacillus subtilis$
clstrOut[65][1C8S] = 2242  == $Halobacterium salinarum$
clstrOut[65][1C94] = 32630 32630  == $synthetic construct$synthetic construct$
clstrOut[65][1CBF] = 1404  == $Bacillus megaterium$
clstrOut[65][1D02] = 2093 2093  == $Mycoplasma$Mycoplasma$
clstrOut[65][1D5Q] = 32630  == $synthetic construct$
clstrOut[65][1DVA] = 9606 9606  == $Homo sapiens$Homo sapiens$
clstrOut[65][1DWM] = 4006  == $Linum usitatissimum$
clstrOut[65][1E0M] = 32630  == $synthetic construct$s
```
* Output size is 54GB
* file location: ```/pylon5/mc5fr5p/hbagheri/09_Hadoop/seqIDTaxlistSim/part-r-00000```

### we run the similar query for 95% only to get all the tax ids that happened to be in 95% similarity
```
s: Sequence = input;
clstrOut : output collection of string;

foreach(i:int; def(s.cluster[i])){
  if(s.cluster[i].similarity==95){
       foreach(j:int; def(s.annotation[j])){
        if (s.annotation[j].tax_id !="" && s.annotation[j].keyID ==s.seqid)
          clstrOut << s.annotation[j].tax_id;
     }
 }
};

```
* location: ```/pylon5/mc5fr5p/hbagheri/09_Hadoop/tax95/part-r-00000 ```


### post processing
```
# get the 3rd column which is the primary taxonomic assignment for 95%
grep "^clstrOut\[95\]" part-r-00000 | awk '{print $3}' part-r-00000 > tmp3column
# then we need to sort that file and calculate the counts
# this gives the tax Frequencies
sort tmp3column | uniq -c > taxFreq
# this is sample output

# we need to switch the columns
awk '{print $2, $1}' taxFreq > taxFreq2

```
#### python scripts that calculates the tax frequencies based on lineage
TODO:
#### Output:


| tax id| tax_name |frequency|

```

```

## number of annotations that don't have taxonomy name and total annotations

```
s: Sequence = input;
countNull : output sum of int;
countAll : output sum of int;

foreach(i:int; def(s.annotation[i])){   
 countAll <<1;
 if (s.annotation[i].tax_name =="")
  countNull  <<1;
}
```

### Output: run on the full dataset
```
countAll[] = 572391376
countNull[] = 992577
```
* run time on Hadoop: 1.87 min
* path of the query and output folder is  ``` /pylon5/mc5fr5p/hbagheri/09_Hadoop/taxCount2 ```
* run time on one single node, i.e. RM-Small, on XSEDE : about 2 hours


## Number of clusters and proteins by similarity level
```
s: Sequence = input;
cluster_counts: output sum[int] of int;
protein_counts: output sum[int] of int;

foreach(i:int; def(s.cluster[i])){
  protein_counts [s.cluster[i].similarity] <<  1;
  if (s.cluster[i].representative) # because each cluster has one representative
	cluster_counts [s.cluster[i].similarity] <<  1;
}
```

### Output : run on the full datasets
```
cluster_counts[65] = 34451690
cluster_counts[70] = 40010418
cluster_counts[75] = 46157068
cluster_counts[80] = 53308820
cluster_counts[85] = 61757844
cluster_counts[90] = 72393597
cluster_counts[95] = 88276733
protein_counts[65] = 40010418
protein_counts[70] = 46157068
protein_counts[75] = 53308820
protein_counts[80] = 61757844
protein_counts[85] = 72393597
protein_counts[90] = 88276733
protein_counts[95] = 174233775
```
* run time: 2.3 minutes
* location of query and Output on bridges: ```/pylon5/mc5fr5p/hbagheri/09_Hadoop/similarity ```

## Number of proteins for different size (in 95%)
```
s: Sequence = input;
counts: output sum[int] of int;

foreach(i:int; def(s.cluster[i])){
  if (s.cluster[i].similarity==95)
	counts [s.cluster[i].length] <<  1;
}
```

### output on the full datasets
```

```

## Maximum protein length
```
s: Sequence = input;
MaxProtein: output maximum(10) of string weight int;
ClusterInfo : output collection [string][int] of int;

foreach(i:int; def(s.cluster[i])){
		MaxProtein << s.seqid +" "+ s.cluster[i].cid weight s.cluster[i].length ;
		#ClusterInfo [s.cluster[i].cid][s.cluster[i].length] <<1;
}
```

### sample Output
```

MaxProtein[] = A2ASS6.1 _ 34, 35213.0
MaxProtein[] = A2ASS6.1 _ 37, 35213.0
MaxProtein[] = AAY00025.1 _ 107, 25572.0
MaxProtein[] = AAY00025.1 _ 127, 25572.0
MaxProtein[] = AAY00025.1 _ 180, 25572.0
MaxProtein[] = AAY00025.1 _ 300, 25572.0
MaxProtein[] = AAY00025.1 _ 439, 25572.0
MaxProtein[] = AAY00025.1 _ 646, 25572.0
MaxProtein[] = AAY00025.1 _ 87, 25572.0
MaxProtein[] = AAL65133.2 _ 122, 22152.0

```

## top dominant taxa for each cluster within a specific similarity level

```
s: Sequence = input;
counts: output sum[string] of int;

isRepresentative := function(seq: Sequence, sim: int):bool {
 exists (i: int; seq.cluster[i].similarity ==sim && s.cluster[i].representative==true)
 	return true;
 return false;
};

# if this sequence is a representative sequence for the 95% similarity
if (isRepresentative(s,95)){
	foreach(i:int; def(s.annotation[i])){
   		counts[s.annotation[i].tax_name] << 1;
  }
};
```

#### Sample output on full datasets
```
counts[Abutilon Brazil virus] = 8
counts[Abutilon glaucum] = 1
counts[Abutilon golden mosaic Yucatan virus] = 8
counts[Abutilon mosaic Bolivia virus] = 12
counts[Abutilon mosaic Brazil virus] = 14
counts[Abutilon mosaic virus - [WEST INDIA]] = 2
counts[Abutilon mosaic virus-HW] = 6
counts[Abutilon mosaic virus] = 32
counts[Abutilon sp. LHMS 2427] = 1
counts[Abutilon theophrasti] = 4
counts[Abutilon x hybridum] = 1
```
* run time: 2.4 min
* path location on bridges: ```pylon5/mc5fr5p/hbagheri/09_Hadoop/topTaxa ```


##  CD-HIT Output
```
# CD-HIT output clusters with sequences
s: Sequence = input;
counts: output sum[string][string][int][int] of int;

foreach(i:int; def(s.cluster[i])){
  if (s.cluster[i].similarity==95)
	counts [s.cluster[i].cid][s.seqid][s.cluster[i].seq_start][s.cluster[i].seq_stop] <<  1;
}
```

### sample Output
```
counts[9990530][AAC45972.1][0][0] = 1
counts[9990534][AAH03977.1][1][610] = 1
counts[99910][AAQ60471.1][1][3171] = 1
counts[9991400][5VZT_B][15][488] = 1
counts[9991400][AAL55855.1][6][389] = 1
counts[9991400][AAU50679.1][1][539] = 1
counts[9991404][AAH39737.1][1][350] = 1
counts[9991682][ABD34794.1][7][374] = 1
counts[9991702][AAL64085.1][0][0] = 1
counts[9991711][AAM38915.1][0][0] = 1
counts[9991721][AAP32150.1][0][0] = 1
counts[9991910][AAL99745.1][1][605] = 1
counts[9991910][AAM18119.1][1][259] = 1
counts[9991981][AAX24893.2][9][231] = 1
counts[9992181][AAF42531.1][1][598] = 1
counts[9992181][AAK68864.1][1][598] = 1
counts[9992251][AAN08357.1][1][585] = 1

````

## for a given keyID provide clustering information
```
# for a given keyID provide clustering information
s: Sequence = input;
counts: output collection[string][string][int][int][int] of int;

exists (j: int;  s.annotation[j].keyID =="AAC45972.1" ){
	foreach(i:int; def(s.cluster[i])){
		counts[s.seqid][s.cluster[i].cid][s.cluster[i].similarity][s.cluster[i].seq_start][s.cluster[i].seq_stop] << 1;
	 }
 }
```
### sample output
```
counts[AAC45972.1][8236824][90][1][602] = 1
counts[AAC45972.1][9990530][95][0][0] = 1
```



## Get sequences with hypothetical protein in the def-line

```
s: Sequence = input;
counts : output sum[string][string][string][string] of int;

foreach(i:int; def(s.annotation[i])){
 if (match(`hypothetical protein`, s.annotation[i].defline))
  counts[s.seqid][s.annotation[i].defline][s.annotation[i].tax_id][s.annotation[i].tax_name]<<1;
}
```

#### Sample Output

```
counts[1BL0][conserved hypothetical protein [Escherichia coli B354]][550677][Escherichia coli B354] = 1
counts[1IVZ][Chain A, Solution structure of the SEA domain from murine hypothetical protein homologous to human mucin 16][10090][Mus musculus] = 1
counts[1J26][Chain A, Solution structure of a putative peptidyl-tRNA hydrolase domain in a mouse hypothetical protein][10090][Mus musculus] = 1
counts[1K5W][hypothetical protein CR201_G0042765, partial [Pongo abelii]][9601][Pongo abelii] = 1
counts[1L5A][hypothetical protein ASZ81_00809 [Vibrio cholerae]][666][Vibrio cholerae] = 1
counts[1L5A][hypothetical protein VCV52_0741 [Vibrio cholerae V52]][345076][Vibrio cholerae V52] = 1
counts[1MSK][hypothetical protein CJU65_22295, partial [Escherichia coli]][562][Escherichia coli] = 1
```



# Number of tax name proteins per each sequence

```
s: Sequence = input;
counts: output sum[string][string] of int;

foreach(i:int; def(s.annotation[i])){
	counts [s.annotation[i].tax_name][s.seqid] <<  1;
}
```

### sample Output

```
counts[Thermus thermophilus HB27][1I94] = 81
counts[Thermus thermophilus HB27][1NIK] = 8
counts[Thermus thermophilus HB8][1A8H] = 1
counts[Thermus thermophilus HB8][1ATI] = 4
counts[Thermus thermophilus HB8][1B5O] = 2
counts[Thermus thermophilus HB8][1BJW] = 2
counts[Thermus thermophilus HB8][1C4O] = 1
counts[Thermus thermophilus HB8][1C51] = 9
counts[Thermus thermophilus HB8][1D2M] = 2
```



# For a given function what are the distribution of start and stop positions

```
s: Sequence = input;
counts: output collection[string][string][int][int] of int;

# hasFunc is a user defined function; this is another feature of Boa
# this function takes sequence s and expr as string and checks if the given sequence has the function expr?

hasFunc := function(s: Sequence, expr: string):bool {
 exists(i: int; match(expr, s.annotation[i].defline))
 	return true;
 return false;
};

# We can also write it this way:
# exists(j: int; match(`hypothetical protein`, s.annotation[j].defline)){
if (hasFunc(s,`hypothetical protein`)){
	foreach(i:int; def(s.cluster[i])){
	  if (s.cluster[i].representative ==false)
   		counts[s.seqid][s.cluster[i].cid][s.cluster[i].rep_start][s.cluster[i].rep_stop] << 1;
  }
};
```


# what are representative sequences for cluster in a certain similarity level e.g 95%?
```
s: Sequence = input;
counts: output collection[string][string] of int;

foreach(i:int; def(s.cluster[i])){
  if (s.cluster[i].representative ==true and s.cluster[i].similarity==95)
	counts[s.seqid][s.cluster[i].cid] << 1;
 }
```

### sample output
```
counts[A9AY15.1][37125129] = 1
counts[A9AY55.1][29812882] = 1
counts[A9AY83.1][50438914] = 1
counts[A9AYA7.1][30600555] = 1
counts[A9AYB7.1][22994003] = 1
counts[A9AYC1.1][29166769] = 1
counts[A9AYE8.1][13081425] = 1
counts[A9AYK6.1][69635152] = 1
counts[A9AYM5.1][20135249] = 1
counts[A9AYX1.1][63299786] = 1
counts[A9AYY2.1][48978538] = 1
counts[A9AZ03.1][54058160] = 1
counts[A9AZ11.1][4962270] = 1
```
