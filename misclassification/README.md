# Taxonomic Misclassification in the NR database

### Dataset
* Boa<sub>g</sub> script output used to check taxonomic misclassification. Following script is running on the entire 
database on XSEDE on a 5-node shared Hadoop cluster.

   ```
   s: Sequence = input;
   count : output sum [string][string] of int;
   foreach(i:int; def(s.annotation[i]))
     count [s.seqid][s.annotation[i].tax_id] << 1;
   ```

 * [Output of the script on the Google Drive](https://drive.google.com/drive/u/2/folders/1W4byknJrRCBfMMltUP68Hk649cEKEzKG)
   - There are about 29M proteins that have distinct taxonomic assignments. This file has the protein id and number of occurrence of each taxonomic assignment.
   - this file is used to generate phylogeny tree and check the lowest common ancestor to find conflicts.
   - few lines in this file: starts with keyID, then follows by tax ```id = count```
      ```
      1EET:11676=3;11678=3
      1EFG:32630=3;562=1;300852=1;197221=16;146786=2;9823=2;9913=2
      1EFU:562=6;83333=5;536056=2
      1EIQ:306=1;307=7
      1EJ1:10090=44;32630=5
      1EJ2:145262=1;187420=1
      1EJ3:168712=2;6100=4
      1EJ4:32630=1;9606=8
      1EJC:550=14;716541=17
      1EJL:32630=8;8355=1;559292=1;10116=1;401671=2;10377=3;1439677=1;1945294=1
     ```

* This output could also be achieved by bash script or any other programming languages such as Python, however, it takes longer time.

### Detected Taxonomically misclassified sequences the full NR database
##### [Root and kingdom violations](results)
  - These are few examples of violations, full list is in the Google Drive link.
  - [Google Drive link](https://drive.google.com/drive/u/2/folders/1lF7boVEF2hf9CSl0quW0T4IkRc54Fjd7)
  - [Generate phylogeny tree in  the jupyter notebook](../jupyter_notebooks/phylogeny.ipynb)

##### [Misclassification in clusters](results/Cluster)


##### [Case Study: Glycine](examples.md)
