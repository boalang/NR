# Analysis on the simulated dataset
### steps
- take all the NR taxa
  - file location: ``` /Users/hbagheri/Downloads/mis-ann/seqCount2019V3/nr_taxa_list_from_Boa```
- take 1M proteins from the RefSeq database (manually curated database)
- for each protein from samples:
  - add a mislabel such that it is not from the same phylum or class.


### Take NR subset
* location on disk: ``` /Users/hbagheri/Downloads/mis-ann/simulated```
* take RefSeq sample by command shuf: ```  ```
* Few lines of sample RefSeq and the format is as follows: it starts with protein key id; then ":", followed by taxid and frequency of appearance. For example ```316=3``` means taxid 316 apears 3 times.

  ```
  WP_064481056:286=1;316=3
  WP_083014118:416916=1;732=1;739=2
  WP_005594834:45658=1;870967=1
  WP_005832776:100886=1;820=15;997889=1;997890=1

  ```


### Detecting misannotations

* run the python script ``` python verify_seq_parallel.py mislabeled_samples  ``` to check tree for LCA
* find protein ids that have misannotations: ``` python get_misann_ids.py . ```. Basically it iterates over the folder and get the file name that are IDs of detected mislabeled.
* we need to remove those IDs that already are suspicious, make sure we havre a verified sample of RefSeq: ``` python sample_verified.py misannotated_keys sample_RefSeq  ```
* Now, we mislabel the sample_verified file by adding taxa from other phylum (make it dirty or add misannotation)

* location on the GitHub repo:

### Evaluating performance on the simulated dataset
* 50% of data are mislabeled purposefully
* Calculate false positives (FP), True Positives (TP), False Negative (FN)
    - there are changes in the taxonomies by NCBI, this might be the cause of false positives
* Calculate Precision and Recall 
* codes and data are in this folder
