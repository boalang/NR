# Analysis on the simulated dataset
### Overview of Steps
- take all the NR taxa
  * file location: ``` /Users/hbagheri/Downloads/mis-ann/seqCount2019V3/nr_taxa_list_from_Boa```
- take 1M proteins from the RefSeq database (manually curated database)
- for each protein from samples:
  * add a mislabel such that it is not from the same phylum or class.


### Subset of the NR dataset
* location on disk: ``` /Users/hbagherisam/Downloads/mis-ann/simulated```
* take RefSeq sample by command shuf: ```  ```
* Few lines of sample RefSeq and the format is as follows: it starts with protein key id; then ":", 
followed by taxid and frequency of appearance. For example ```316=3``` means taxid 316 apears 3 times.

  ```
  WP_064481056:286=1;316=3
  WP_083014118:416916=1;732=1;739=2
  WP_005594834:45658=1;870967=1
  WP_005832776:100886=1;820=15;997889=1;997890=1

  ```


### Detecting misannotations

##### Step1: Detect misclassified sequences
* Input: sample of RefSeq
* Python script: ``` python verify_seq_parallel.py sample_RefSeq  ``` to check trees for LCA
* Output: it creates folders and then puts the protein IDs along with phylogeny tree inside it.

##### Step2: Extracts IDs that are misclassified
* Input: all folders in the current directory as the argument is just ```.```
* find protein ids that have misannotations: ``` python get_misann_ids.py . ``` Basically it iterates over
the folder and get the file name that are IDs of detected mislabeled.
* Output: a file named `misannotated_keys` list of protein IDs that are misclassified

##### Step3: Create verified Sample with no mis-assignments
* Input: file `misannotated_keys` from prev step and `sample_RefSeq` that is the initial sample
* we need to remove those IDs that already are suspicious, make sure we have a verified 
sample of RefSeq: ``` python sample_verified.py misannotated_keys sample_RefSeq  ```
* Output: a file named `sample_verified`

##### Step4: add one random assignment to make the verified sample dirty
* Input: File `sample_verified` from previous step
* Now, we mislabel the sample_verified file by adding taxa from other phylum (make it dirty or add misannotation)
* script: `mislabel_nr.py`
* Output:  A file `sample_verified_mislabeled` that has mis-assignments

###### Add more than one random assignment
* We just need to repeat this step again that adds one more random taxa
* By adding more random taxa, it increases the chance to be detected by our approach.
Since the approach checks the LCA and the distance in the tree. 
Therefore, the higher the random taxa, the higher the probability to detect by the approach.  

##### Step5: Evaluating performance on the simulated dataset
* now we check how many misannotation we can find with our approach
* We need to run the **step1** again to see how many misannotation we can detect
    - input: A file `sample_verified_mislabeled` from previous step 
* 50% of data are mislabeled purposefully
* Calculate false positives (FP), True Positives (TP), False Negative (FN)
    - there are frequent changes in the taxonomies database by NCBI, this might be the cause of false positives
* Calculate Precision and Recall 
* codes and data are in this folder
