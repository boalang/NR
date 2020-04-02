# Related works on finding misclassified taxa

The comparison is designed on a local machine, not a cluster (described in Section 3.6).
We run this analysis in iMac (Retina 5K, 27-inch, Late 2015) with core i7 and 32 GB RAM.


## Phylogeny-aware work (SATIVA)
* https://github.com/amkozlov/sativa
* examples works currently for RNA
* examples work for one taxa at a time.

## Analysis

### Methods on running our approach on the SATIVA dataset
* dataset is rRNA not protein
* SATIVA designed to detect misannotation in rRNA sequences, not proteins. Therefore, we tested our approach on their dataset.
* commands to generate the cluster at 95% similarity
  - we used CD-HIT clustering program
  ```
    cd-hit-est -i infile.fa-rm -o infile_95 -c 0.95 -n 5 -g 1 -G 0 -aS 0.8  -d 0 -p 1 -T 28 -M 0
  ```

### Detect misannotations
* Example: based on the consensus data the sequence with id UlaSpe11 is misannotated with ```g__Cupriavidus ```. It belongs to cluster id 4576 that most sequences suggest ```g__Burkholderia```  

 ```
 >Cluster 4576
 0	1458nt, >UlaAcidi... *
 1	1458nt, >UlaSabia... at 1:1458:1:1458/+/95.54%
 2	1457nt, >UlaSpe11... at 1:1457:1:1458/+/96.64%
 3	1458nt, >UlaSp292... at 1:1458:1:1458/+/95.13%
 4	1458nt, >UlaSp960... at 1:1458:1:1458/+/96.23%
 5	1458nt, >UlaFerra... at 1:1458:1:1458/+/95.27%
 6	1457nt, >UlaPhyma... at 1:1457:1:1458/+/95.61%
 ```

* important time: Alignment time was not reported in the Phylogeny-aware paper

### Run time analysis
* we run SATIVA for 100, 500, 1000 sequences and compare them with our approach in terms of running time.

* Commands to run SATIVA on 100 protein sequences: ~ 2min

  ```
      atan-115b-01:example hbagheri$ time python2.7 ../sativa.py -s sim_full_sorted_head100.phy -t true_converted_sorted_head100.tax -x BAC -T 2

    SATIVA v0.9-57-g8a99328, released on 2017-07-15. Last version: https://github.com/amkozlov/sativa
    By A.Kozlov and J.Zhang, the Exelixis Lab. Based on RAxML 8.2.3 by A.Stamatakis.

    SATIVA was called as follows:

    ../sativa.py -s sim_full_sorted_head100.phy -t true_converted_sorted_head100.tax -x BAC -T 2

    *** STEP 1: Building the reference tree using provided alignment and taxonomic annotations ***

    => Loading taxonomy from file: true_converted_sorted_head100.tax ...

    ==> Loading reference alignment from file: sim_full_sorted_head100.phy ...

    ===> Validating taxonomy and alignment ...

    ====> Building a multifurcating tree from taxonomy with 99 seqs ...

    =====> Building the reference alignment ...

    ======> Saving the outgroup for later re-rooting ...

    =======> Resolving multifurcation: choosing the best topology from 1 independent RAxML runs ...

    ========> Calling RAxML-EPA to obtain branch labels ...

    =========> Post-processing the EPA tree (re-rooting, taxonomic labeling etc.) ...

    ==========> Saving the reference JSON file: ./true_converted_sorted_head100.refjson

    *** STEP 2: Searching for mislabels ***

    Running the leave-one-sequence-out test...

    Mislabeled sequences by rank:

    Total mislabels: 0 / 0.00 %

    Results were saved to: /Users/hbagheri/Downloads/tmp/tmp2Sativa/sativa/example2/true_converted_sorted_head100.mis
    Execution log was saved to: /Users/hbagheri/Downloads/tmp/tmp2Sativa/sativa/example2/true_converted_sorted_head100.log

    Analysis completed successfully, elapsed time: 56 seconds (21s reftree, 35s leave-one-out)


    real	0m55.636s
    user	1m47.952s
    sys	0m0.907s


```
