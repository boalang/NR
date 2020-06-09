
# Correcting annotations for the misclassified protein sequences

## Details of conflicts in sequence and cluster annotations

<!---
##### Sequence   `1FE1` that belongs to a cluster ID  `82`
* tree for the sequence:


* Top three taxonomic assignment within a cluster and their frequencies:
 [[9606](https://www.ncbi.nlm.nih.gov/taxonomy/?term=9606)= 86,
  [9913](https://www.ncbi.nlm.nih.gov/taxonomy/?term=9913)= 65,
  [9823](https://www.ncbi.nlm.nih.gov/taxonomy/?term=9823)= 56]

* confidence score: `86/(86+65+56) = 0.41`

-->

#### Sequence `AAB18559` belongs to the cluster ID `18982245`
* tree for the sequence:
  ```
                      /-uncultured actinobacterium HF0500_01C15, species
  -Bacteria, superkingdom
                      \-Escherichia coli str. K-12 substr. MG1655, no rank
  ```

* Top three taxonomic assignment within a cluster and their frequencies:  
[[562](https://www.ncbi.nlm.nih.gov/taxonomy/?term=562) = 3269,
 [624](https://www.ncbi.nlm.nih.gov/taxonomy/?term=624) = 55, 
 [623](https://www.ncbi.nlm.nih.gov/taxonomy/?term=623) = 20]

* confidence score: `3269/(3269+55+20) = 0.97`


#### Sequence  `CCW09133` belongs to a cluster `9901357`
* tree for the sequence `CCW09133`:
 ```
                /-Streptococcus pneumoniae, species
    -Bacilli, class
                \-Bacillus sp. GeD10, species
 ```
* Top three taxonomic assignment within a cluster and their frequencies:
 [[155322](https://www.ncbi.nlm.nih.gov/taxonomy/?term=155322) = 220,
  [1428](https://www.ncbi.nlm.nih.gov/taxonomy/?term=1428)  = 208,
   [1396](https://www.ncbi.nlm.nih.gov/taxonomy/?term=1396) = 134]
* confidence score:  `220/(220+208+134) = 0.39`

#### Sequence `KFV03115` belongs to the cluster `13041247`
* tree for the protein sequence
 ```text
               /-Tauraco erythrolophus, species
    -Aves, class
               \-Struthio camelus australis, subspecies          

 ```
*  Top three taxonomic assignment within a cluster and their frequencies:
 [[13735](https://www.ncbi.nlm.nih.gov/taxonomy/?term=13735)  = 4,
  [299123](https://www.ncbi.nlm.nih.gov/taxonomy/?term=299123) = 4,
  [188344](https://www.ncbi.nlm.nih.gov/taxonomy/?term=188344) = 3]
  
* confidence score: `4/(4+4+3) = 0.37`


#### Sequencer ID `YP_950729`  belons to the cluster `83178931`
* tree
  ```
                   /-Staphylococcus virus PH15, species
        -root, no rank
                  |                                  /-Staphylococcus epidermidis BCM-HMP0060, no rank
                    \Staphylococcus epidermidis, species
                                                    \-Staphylococcus epidermidis M23864:W2(grey), no rank

  ```

* Top three taxonomic assignment within a cluster and their frequencies:
 [[1282](https://www.ncbi.nlm.nih.gov/taxonomy/?term=1282) = 15,
  [1197952](https://www.ncbi.nlm.nih.gov/taxonomy/?term=1197952) = 2,
  [1197953](https://www.ncbi.nlm.nih.gov/taxonomy/?term=1197953) =2]

* confidence score: ```15/(15+2+2) = 0.78```


#### sequence ID `AAT83007` belongs to the cluster ID `21005513`
* tree for protein `AAT83007`

  ```
                                                                             /-Propionibacterium sp. CC003-HC2, species
                                                                            |
                                                                            |--Propionibacterium sp. 409-HC1, species
                                                     /Propionibacterium, genus
                                                    |                       |--Propionibacterium sp. 434-HC2, species
                                                    |                       |
                                                    |                        \-Propionibacterium sp. KPL2008, species
                         /Propionibacteriaceae, family
                        |                           |                            /-Cutibacterium acnes SK187, no rank
                        |                           |                           |
                        |                           |                           |--Cutibacterium acnes KPA171202, no rank
                        |                           |                           |
    -Actinobacteria, class                           \Cutibacterium acnes, species-Cutibacterium acnes PA2, no rank
                        |                                                       |
                        |                                                       |--Cutibacterium acnes P6, no rank
                        |                                                       |
                        |                                                        \-Cutibacterium acnes 6609, no rank
                        |
                         \-Mycobacteroides abscessus subsp. abscessus, subspecies



  ```


* Top taxa and their frequencies for the cluster `21005513`: 
           [[1747](https://www.ncbi.nlm.nih.gov/taxonomy/?term=1747) = 95,
           [1905725](https://www.ncbi.nlm.nih.gov/taxonomy/?term=1905725) = 7,
            [31957](https://www.ncbi.nlm.nih.gov/taxonomy/?term=31957) = 6]
* Confidence score: `95/(95+7+6) = 0.78`




### More Details on Conflicts analysis BoaG query

#### Examples

* convert Boa output to one line for each sequence

```
input:
count[101M][101M][9755] = 1
count[101M][1MTJ][9755] = 1
count[101M][1MTK][9755] = 1
count[101M][1MYM][9755] = 1

output:
101M:101M,9755=1;1MTJ,9755=1;1MTK,9755=1;1MYM,9755=1
```

* Sequence 1C08 belongs to cluster ``` 1C08:55275953```

```
1C08:10090=2;83333=4;9031=22;9103=1
1CSG:32630=1;9606=14

```

* Sequence: Cluster

```
1CSG:27522393

```

* Cluster:

```
55275953:10090=1;83333=4;8839=6;9031=22;9103=1

27522393:10116=1;10245=3;111789=1;1151248=1;1446742=1;1446743=2;1701613=3;1958742=1;32630=5;562=61;563944=1;573235=1;622=1;754093=1;77133=5;83334=1;869678=1;9597=1;9598=2;9601=2;9606=33

```


#### Analysis files and parameters

* location: ```/pylon5/mc5fr5p/hbagheri/00_rawData/verification_NR```
* files that contain sequences; clusters, and the dictionary of seq:cluster
  - 95-part-r-00000seq_cluster
  - part-r-00000_converted
  - part-r-00000_converted_1col_sorted_filtered_cut1

* Code and parameters to run the conflicts analysis

```
 /Users/hbagheri/Downloads/95-part-r-00000seq_cluster /Users/hbagheri/Downloads/mis-ann/clstrCount2019V3/part-r-00000_converted /Users/hbagheri/Downloads/mis-ann/seqCount2019V2/part-r-00000_converted_1col_sorted_filtered_cut1

```

