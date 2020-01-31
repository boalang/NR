# Conflicts analysis between annotations in the sequences and clusters at nr95

## Examples

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


## Analysis

* location: ```/pylon5/mc5fr5p/hbagheri/00_rawData/verification_NR```
* files that contain sequences; clusters, and the dictionary of seq:cluster
  - 95-part-r-00000seq_cluster
  - part-r-00000_converted
  - part-r-00000_converted_1col_sorted_filtered_cut1

*
* Code and prameters to run conflicts

```
 /Users/hbagheri/Downloads/95-part-r-00000seq_cluster /Users/hbagheri/Downloads/mis-ann/clstrCount2019V3/part-r-00000_converted /Users/hbagheri/Downloads/mis-ann/seqCount2019V2/part-r-00000_converted_1col_sorted_filtered_cut1

```
