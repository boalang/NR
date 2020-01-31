# 01_cdhit
* location on bridges: ```/pylon5/mc5fr5p/hbagheri/01_cdhit/cd-hit-v4.6.8-2017-1208```


* [CDHIT paper](http://weizhongli-lab.org/cd-hit/ref.php )
* [CDHIT manual](http://weizhongli-lab.org/cd-hit/ )

* CD-HIT sorts the strings from largest to smallest; hence it might be possible to cluster
large number of sequences in hours. The first day largest it clustered 5M sequences

* install
- install cd-hit version v4.6.8-2017-1208
   - [Download link](https://github.com/weizhongli/cdhit/wiki/2.-Installation)

- [cd-hit wiki](https://github.com/weizhongli/cdhit/wiki/3.-User's-Guide)   


### run cd-hit with 95% identity
- run cd-hit word length=5
 ```
./cd-hit -i nr -o nr95 -c 0.95 -n 4 -g 1 -G 0 -aS 0.8  -d 0 -p 1 -T 28 -M 0 > nr95.log
```

- database size (entire NR) : 100GB
-  job on XSESE was finished in 6 days and 20 hours


### run cd-hit with 90% identity
- run cd-hit the output of previous step, i.e. 95%,

   ``` ./cd-hit -i nr295 -o nr90 -c 0.90 -n 5 -g 1 -G 0 -aS 0.8  -d 0 -p 1 -T 28 -M 0 > nr90.log ```

- database size = 40GB
-  job on XSESE was finished in 3 days


### run cd-hit with 85% identity
- run cd-hi the output of previous step, i.e. 90%,
- database size is 33GB

   ``` ./cd-hit -i nr90 -o nr85 -c 0.85 -n 5 -g 1 -G 0 -aS 0.8  -d 0 -p 1 -T 28 -M 0 > nr85.log ```

-  job on XSESE was finished in 1 day and 21 hours


### run cd-hit with 80% identity
- run cd-hi the output of previous step
- database size: 28GB

    ``` ./cd-hit -i nr85 -o nr80 -c 0.80 -n 5 -g 1 -G 0 -aS 0.8  -d 0 -p 1 -T 28 -M 0 > nr80.log ```
-   Run time 1 day and 12:59:16



### run cd-hit with 75% identity
- run cd-hi the output of previous step
- database size: 24GB

    ``` ./cd-hit -i nr80 -o nr75 -c 0.75 -n 5 -g 1 -G 0 -aS 0.8  -d 0 -p 1 -T 28 -M 0 > nr80.log ```
-   Run time ?

### run cd-hit with 70% identity
- TOOD file size?

### run cd-hit with 65% identity



### hardware spec (lscpu)

       ```
       Thread(s) per core:    1
       Core(s) per socket:    14
       Socket(s):             2
       ```  

#### parameter choice: Select best parameters
 If we run cd-hit with word length (-n 4) the clustering time would be around one month. But if we run it with word length (-n 5) the running time will be much smaller and it would be less than a week.

##### what is the role of different word length on the accuracy of clustering?


## XSEDE job errors and logs
* slurmstepd: error  DUE TO NODE FAILURE, SEE SLURMCTLD LOG FOR DETAILS ***
* Fatal Error:
Too low cluster threshold for the word length.
Increase the threshold or the tolerance, or decrease the word length.
Program halted !!


## Questions
* what is Hierarchically clustering in CD-HIT run? http://weizhongli-lab.org/lab-wiki/doku.php?id=cd-hit-user-guide
