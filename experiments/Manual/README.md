# Manual verification of taxonomic assignments
We took a random 1000 sample of the NR database and manually checked to see if there is a taxonomic misassignments.  
As we can see,  a protein can have multiple taxonomic classifications some of which can differ by as much as the super kingdom.


Samples protein sequences and their associated trees can be found here:
[1000 protein sequences](sample_NR_Trees)

Following example shows a potentially misclassified sequence with protein ID `CDA34809`.
Based on the tree we can only see that there is a super-kingdom violation.
Based on the tree, we can not propose which of the two assignment might be the correct one.
For all these examples we may find a most probable taxonomic assignment by looking at the 
clusters at 95% sequence similarity.

```text

 ———————————————CDA34809----------------------------------------------

                      /-Firmicutes bacterium CAG:536, species, 1
-Bacteria, superkingdom
                      \-Chlamydia trachomatis, species, 1

```


In the following example, with sequence ID EXZ31167, there is no mislabel:
```text


-------------------------------EXZ31167----------------------------------------------

                             /-Bacteroides fragilis str. S36L12, no rank, 1
                            |
-Bacteroides fragilis, species-Bacteroides fragilis str. S36L5, no rank, 1
                            |
                             \-Bacteroides fragilis str. S36L11, no rank, 1

```