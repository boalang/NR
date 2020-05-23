# Dataset generation

## NR database
 
The NR database contains non-redundant sequences from GenBank translations (i.e. GenPept) together with sequences from other databanks (Refseq, PDB, SwissProt, PIR and PRF).
  - link: http://www.bioinf.org.uk/teaching/gradtrain/blast.html



## Data generation, Hadoop Sequence Files
* Download entire nr database
  * [https://ftp.ncbi.nlm.nih.gov/blast/db/FASTA/](https://ftp.ncbi.nlm.nih.gov/blast/db/FASTA/)

*  preprocessing for data generation; we need to prepare the NR database and CD-HIT clustering output and generate the Hadoop Sequence file:

* steps:

```
      # modify annotation file by calling modify_keys.py
      python modify_keys.py nr95_5M_annotations

      # sort the output
      python sort.py nr95_5M_annotations_modified # output is: nr95_5M_annotations_modified_sorted


      #append ð as a separator to the end of defline
      sed 's/$/ð/' nr95_5M_annotations_modified_sorted > nr95_5M_annotations_modified_sorted_append

      #cut the first character before the key like >YP_95097.1 to YP_95097.1
      cut -c2- nr95_5M_annotations_modified_sorted_append > nr95_5M_annotations_modified_sorted_cut_append

      # modify the CD-HIT output and prepare it for join
      # this step needs to be done for all CD-HIT different similarity output from 95% down to 65%
      python convert_CDHIT.py nr95_5M.clstr

      #similar to the annotations file we need to modify all the key ids
      python modify_keys.py nr95_5M.clstr_converted

      # sort the cluster file because the join command needs both annotations and cluster file to be sorted
      python sort.py nr95_5M.clstr_converted_modified # output is: nr95_5M.clstr_converted_modified_sorted

      # for all CD-HIT output expect the last one, i.e 65%, add ü as a cluster info separator to the end of each line
      sed 's/$/ü/' nr95_5M.clstr_converted_modified_sorted > nr95_5M.clstr_converted_modified_sorted_append

      # left outer join the deflines with the clustering info from CD-HIT output
      join -t " " -a1 nr95_5M_annotations_modified_sorted_cut_append nr95_5M.clstr_converted_modified_sorted_append > joined_data_5M

```

### Data generation on a local machine
* generate NR Annotations database (annotations.seq) on a local machine with core i7 CPU
   * run time:  2 hours
   * size  37 GB
      * raw data is 72 GB just annotations(def line) not protein sequences. We each line also has appended the taxonomic information as well as the CHHIT clustering information.



### Data generation command on bridges or local machine

``` ./datagen.sh /paht/to/the/output/location/  /path/to/the/raw/file/```


##### Data format 

* A line of the data in the database appears as follows with special characters ```^A```, ```ð```, and ```ü``` to separate fields.  The sequence ID for the first annotation for each sequence in nr was used as a uniq identifier.

```
1A38 ü 9913 Bos taurus ü Chain P, 14-3-3 Protein Zeta Bound To R18 Peptide^A1A38 ü 9913 Bos taurus ü Chain Q, 14-3-3 Protein Zeta Bound To R18 Peptideð 88250449 0  20aa, *ü 72372990 0     20aa, *ü 61742168 0     20aa, *ü 53299262 0     20aa, *ü 46152904 0     20aa, *ü 40009326 0     20aa, *ü 1092587 1      20aa, 5:20:268:281/68.75%
```

### data generation on a small subset of data to test for jupyter or command line

* select the top 5M lines in the clstr file
  ```
  head -5000000 nr295.clstr > nr95_5M.clstr
  ```

* find subset of annotations from the NR database for the sequence ids in nr95_5M.clstr file

  ```
  less nr95_5M.clstr | awk {'gsub(">",">"); print substr($3, 1, length($3)-3)}'| awk 'NF > 0' > nr95_5M_seqid

  grep -w -F -f nr95_5M_seqid nr_annotations > nr95_5M_annotations

  ```

* handle lower letters key ids and ||

  ```python

  #!/usr/bin/python

  import sys

  annotation_file = sys.argv[1]
  modified_file = sys.argv[1]+ "_modified"

  with open(annotation_file, "r") as f, open(modified_file, "w") as output:
    for line in f:
       words = line.split()
       modified_key = words[0].upper().replace("||", "00")
       output.write(line.replace(words[0], modified_key))

  ```

* sort the output

 ```
 sort nr95_5M_annotations > nr95_5M_annotations_sorted
 ```

* run DSMaster class in Boa Compiler

## challenges in data generation

* Default Hadoop on bridges was 2.7 while Boa was 1.2.1 we needed to upgrade Boa to 2.7 to test it on Hadoop
* The first dataset we crated were slow even on 8 nodes clusters. We needed to change the schema and the performance has increased significantly.
  * First schema started with Clusters as a first message in protobuf and we had another Hadoop sequence file called ```sequences.seq``` that need access to the disk each time. But current schema has optimized.
* run time difference:
  * First schema that we had 2 sequnce file needs more I/O and generated NR Annotations database (annotations.seq and sequences.seq) on a local machine with core i7 CPU
     * run time:  5 days but on the XSEDE cluster 2 hours
     * size  28 GB ( raw data is 40 GB just annotations(def line) not protein sequences)
  * Optimized data schema took us only 2 hours! The file size is 37GB



## 01/17/19
* Run time: data generation on RM-Small bridges took 01:36:35
* Location on bridges: ```/pylon5/mc5fr5p/hbagheri/00_dataset/annotations.seq```
 * we install this file on HDFS on Hadoop to run analysis.


## 01/21/19
* Sequence keys don't have version because we needed to join with the xml files that have taxonomy information.
* I removed the version from keyIDs.
* TODO: needs to be fixed for the next data generation. I have added an issue on the repo. https://github.com/ISUgenomics/BoaISMB/issues/17
