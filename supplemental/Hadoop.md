specialized
# Hadoop on XSEDE

* bridges path: ```/pylon5/mc5fr5p/hbagheri/09_Hadoop```

### New Hadoop on bridges

```
# 1. Connect to a login node
ssh bridges.psc.edu

# 2. Connect to r383 (the namenode)
ssh r383

# 3. Load a special module:
module load  /opt/packages/hadoop-testing/hadoop-envmod.txt

```

### steps are as follows:
```
#request 8 nodes
interact -N 8 -t 08:00:00
#load Hadoop module:
start-hadoop.sh
#create dataset folder on Hadoop
hadoop fs -mkdir /dataset/
#install dataset on HDFS, this takes some time to upload dataset on Hadoop
hadoop fs -put /pylon5/mc5fr5p/hbagheri/00_dataset/annotations.seq /dataset/
```

### Challenge to run Boa query on bridges' Hadoop
* I contacted XSEDE's team because circuits config in the ```BoaRunner.java``` file was enabled and needed Hadoop's config to support this for boa queries. They changed the config and we used this command to start Hadoop instead of above command, i.e. ```start-hadoop.sh``` .
```
/opt/packages/hadoop-testing/shortcircuitstart.sh
```
Finally I disabled the circuit config in Boa Runner and then we don't need the above specialized Hadoop config. We run Hadoop as usual.



#### run queries on Hadoop

```./runHadoop.sh query.boa /output/path/on/hadoop/```

* on XSEDE it is important to copy the output on your local machine because HDFS will be deleted.
```hadoop fs -get /tmp/OutputFolder/
```

## Hadoop useful commands
* Hadoop job list: ```hadoop job -list all```
* kill job: ```hadoop job –kill <JobID>```
* see job status: ``` hadoop job -status <JobID>```
* use Yarn to check status: ```yarn application -status <ApplicationID>```

## Additional files in the 09_Hadoop folder
* yarnTime.sh file that gives the run time of a given application_id
   * ``` bash yarnTime.sh application_id ```
