# Containerized version of Boa

* 12/17/18
* bridges: ```/pylon5/mc5fr5p/hbagheri/05_Container```



## Docker container
* we created a  GitHub repo that users can clone and run Boa queries. I copied the whole folder here and users can use this to have 3 node clusters.
  * Hadoop version is 2.7.7

* TODO: add subset dataset that is less than 100MB

## Singularity on HPC
* the *.sim file equivalent to docker is in the 05_Container folder.
* The challenge is unlike docker that we can have many images I don't know how to have many images in the bridges. For Docker on the
machine we can define the network that makes different slave nodes and master connect to each other.
  * ```docker network create --driver=bridge hadoop``` but what is the equivalent functionality in Singularity on bridges?
