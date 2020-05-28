# Manual verification of taxonomic assignments
We took a random 1000 sample of the NR database and manually checked to see if there is a taxonomic misassignments.

Samples protein sequences and their associated trees can be found here:
[All Trees](sample_NR_Trees)

Example of potentially mislabel for protein ID `CDA34809`:
```text

 ———————————————CDA34809----------------------------------------------

                      /-Firmicutes bacterium CAG:536, species, 1
-Bacteria, superkingdom
                      \-Chlamydia trachomatis, species, 1


```

In the following example, there is no mislabel:
```text


-------------------------------EXZ31167----------------------------------------------

                             /-Bacteroides fragilis str. S36L12, no rank, 1
                            |
-Bacteroides fragilis, species-Bacteroides fragilis str. S36L5, no rank, 1
                            |
                             \-Bacteroides fragilis str. S36L11, no rank, 1

```