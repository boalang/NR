
# 11_MongoDB
* 01/17/18
* bridges path: ``` /pylon5/mc5fr5p/hbagheri/11_MongoDB```


##  Convert flat file to json

* the flat file that has all the NR annotations information and clustering files, i.e, output of CD-HIT clustering is needed to be converted to a json format to be able to be explored by MongoDB.

* strengths and weaknesses of MongoDB and compare
  * structure-free data schema (No schema); we can store data and change it as we need.
  * if you want to modify the schema periodically MongoDB is a best option
  * both need data preparation
  * aggregation functions in MongoDB
  * difference between procedural language vs non-procedural. In Boa programs abstracts away details we just say what we want.
  * TODO: Sawzall texts in the web?

MongoDB is an open source NoSQL database that also supports many features of traditional databases like sorting, grouping, aggregating, indexing, etc.
MongoDB has been used to handle large scale semi-structured or NoSQL data.
Datasets are being stored in a flexible JSON format and therefore MongoDB can support data schemas that evolve over time.  
MapReduce is a framework that has been used for scalable analysis in scientific data. Hadoop is an open source implementation of MapReduce. There are organizations that have used the power of MongoDB and Hadoop framework together to address challenges in Big Data. [TODO: resource:https://www.mongodb.com/hadoop-and-mongodb ]
Genomics England that runs 100,000 Genomes Project is using MongoDB to harness huge amount of data in bioinformatics.
https://www.genomicsengland.co.uk/
https://www.mongodb.com/press/genomics-england-uses-mongodb-to-power-the-data-science-behind-the-100000-genomes-project



## generate json file from the raw data:
* test if the format is correct: https://jsonformatter.curiousconcept.com/

* schema should be like this by the following command:

```
> db.nr_s3.find().pretty()
```

```json
{
	"_id" : ObjectId("5c48ba634e56581cad8636a6"),
	"seq_id" : "WP_021692637",
	"annotations" : [
		{
			"key" : "WP_021692637",
			"defline" : "sugar transferase [Limimaricola cinnabarinus]",
			"tax_id" : "1125964",
			"tax_name" : "Limimaricola cinnabarinus"
		},
		{
			"key" : "GAD54529",
			"defline" : "undecaprenyl-phosphate galactosephosphotransferase [Limimaricola cinnabarinus LL-001]",
			"tax_id" : "1337093",
			"tax_name" : "Limimaricola cinnabarinus LL-001"
		}
	],
	"clusters" : [
		{
			"similarity" : "95",
			"representative" : "true",
			"length" : "227"
		},
		{
			"similarity" : "90",
			"representative" : "true",
			"length" : "227"
		},
		{
			"similarity" : "85",
			"representative" : "true",
			"length" : "227"
		},
		{
			"similarity" : "80",
			"representative" : "true",
			"length" : "227"
		},
		{
			"similarity" : "75",
			"representative" : "true",
			"length" : "227"
		},
		{
			"similarity" : "70",
			"representative" : "true",
			"length" : "227"
		},
		{
			"similarity" : "65",
			"representative" : "true",
			"length" : "227"
		}
	]
}
```
### steps to generate the json file on XSEDE
* split the large flat file to 10 files
 ```
 wc -l annotations_join_clusters_modified
 # output: 174254099 lines
 split -l 17425409 annotations_join_clusters_modified
 ```
* create different sbatch task for all pieces.
```
```

### Issues with running mongodb Queries
 * data size will be huge at least twice as the original raw dataset
 * all data types needs to be converted properly for example the json is
   ```

   db.nr_s3.find().forEach( function (x){
     for(var i=0; i<x.clusters.length; i++){
       #x.clusters.length = new NumberInt(x.clusters[i].length);
       #db.nr_s3.save(x);

       db.nr_s3.update(
         {
             "_id": x._id,
             "clusters.similarity": x.clusters[i].similarity // corrected
         },
         {
             "$set": {
               "topProcesses.$.cpuUtilizationPercent":
                   parseFloat(data.topProcesses[ii].cpuUtilizationPercent)
             }
         }
      );

     }

    });
```

```
# update similarity type from string to int
db.nr_s3.find().forEach( function (x){
  for(var i=0; i<x.clusters.length; i++){
    x.clusters[i].similarity = parseInt(x.clusters[i].similarity);
    db.nr_s3.save(x);
  }

});


```

## run MongoDB
* first run the ```mongod``` command to run the server
* open another console and run following command to import the data file to the MongoDB
  * ``` mongoimport --collection nr --file nr_raw.json  ```
* open a mongo shell by ```mongo``` command
* command to see the number of records:
 ```db.nr3.count()```
* search based on a specific key:  ```db.nr3.find({"seq_id":"104L"})```
* show databases: ``` show dbs``` and ``` show databases```
* what is current database: ``` > db.getName()```
* show list of all collections: ```>show collections```


## MongoDB Queries

### Query: if we want all seq ids:

```
  db.nr3.find({},{"seq_id":1})
  { "_id" : ObjectId("5c3fcf2b707ea109a735684d"), "seq_id" : "WP_078442364" }
  { "_id" : ObjectId("5c3fcf2b707ea109a735684e"), "seq_id" : "102L" }
  { "_id" : ObjectId("5c3fcf2b707ea109a735684f"), "seq_id" : "101M" }
  { "_id" : ObjectId("5c3fcf2b707ea109a7356850"), "seq_id" : "104L" }
  { "_id" : ObjectId("5c3fcf2b707ea109a7356851"), "seq_id" : "102M" }
```

### all seqids that have a specific tax_name
```
> db.nr3.find({"annotations.tax_name":"Influenza"}, {"seq_id":1}).pretty()
{ "_id" : ObjectId("5c3fcf2b707ea109a735684d"), "seq_id" : "WP_078442364" }
{ "_id" : ObjectId("5c3fcf2b707ea109a735684f"), "seq_id" : "101M" }
{ "_id" : ObjectId("5c3fcf2b707ea109a7356851"), "seq_id" : "102M" }
```
* ```{"seq_id":1}``` this means just show this field. If we want to ask for annotation.defline we can add ```"annotations.defline":1``` as follows:
 * ```> db.nr3.find({"annotations.tax_name":"Influenza"}, {"seq_id":1, "annotations.defline":1}).pretty()
```

### aggregate over a specific taxonomy
```
> db.nr_s3.aggregate(
... [{$match : {"annotations.tax_name":"Limimaricola cinnabarinus LL-001"}}]
... );
```
Output is as follows which needs post processing in python:
```
{ "_id" : ObjectId("5c48ba634e56581cad863695"), "seq_id" : "WP_021692607", "annotations" : [ { "key" : "WP_021692607", "defline" : "SAM-dependent methyltransferase [Limimaricola cinnabarinus]", "tax_id" : "1125964", "tax_name" : "Limimaricola cinnabarinus" }, { "key" : "GAD54499", "defline" : "hypothetical conserved protein [Limimaricola cinnabarinus LL-001]", "tax_id" : "1337093", "tax_name" : "Limimaricola cinnabarinus LL-001" } ], "clusters" : [ { "similarity" : "95", "representative" : "true", "length" : "353" }, { "similarity" : "90", "representative" : "true", "length" : "353" }, { "similarity" : "85", "representative" : "true", "length" : "353" }, { "similarity" : "80", "representative" : false, "seq_start" : "1", "seq_stop" : "352", "rep_start" : "1", "rep_stop" : "352", "match" : "84", "length" : "353" } ], "tax_id" : NaN }
{ "_id" : ObjectId("5c48ba634e56581cad863696"), "seq_id" : "WP_021692613", "annotations" : [ { "key" : "WP_021692613", "defline" : "bifunctional sulfate adenylyltransferase/adenylylsulfate kinase [Limimaricola cinnabarinus]", "tax_id" : "1125964", "tax_name" : "Limimaricola cinnabarinus" }, { "key" : "GAD54505", "defline" : "sulfate adenylyltransferase, dissimilatory-type / Adenylylsulfate kinase [Limimaricola cinnabarinus LL-001]", "tax_id" : "1337093", "tax_name" : "Limimaricola cinnabarinus LL-001" } ], "clusters" : [ { "similarity" : "95", "representative" : false, "seq_start" : "1", "seq_stop" : "567", "rep_start" : "1", "rep_stop" : "567", "match" : "95", "length" : "567" } ], "tax_id" : NaN }
{ "_id" : ObjectId("5c48ba634e56581cad863697"), "seq_id" : "WP_021692614", "annotations" : [ { "key" : "WP_021692614", "defline" : "drug/metabolite DMT transporter permease [Limimaricola cinnabarinus]", "tax_id" : "1125964", "tax_name" : "Limimaricola cinnabarinus" }, { "key" : "GAD54506", "defline" : "permease of the drug/metabolite transporter (DMT) superfamily [Limimaricola cinnabarinus LL-001]", "tax_id" : "1337093", "tax_name" : "Limimaricola cinnabarinus LL-001" } ], "clusters" : [ { "similarity" : "95", "representative" : "true", "length" : "312" }, { "similarity" : "90", "representative" : "true", "length" : "312" }, { "similarity" : "85", "representative" : "true", "length" : "312" }, { "similarity" : "80", "representative" : "true", "length" : "312" }, { "similarity" : "75", "representative" : "true", "length" : "312" }, { "similarity" : "70", "representative" : false, "seq_start" : "7", "seq_stop" : "310", "rep_start" : "9", "rep_stop" : "313", "match" : "71", "length" : "312" } ], "tax_id" : NaN }
```
