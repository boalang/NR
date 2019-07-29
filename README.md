# Boa<sub>g</sub>: Boa for genomics

Boa<sub>g</sub> is a domain-specific language and infrastructure on top of Hadoop for genomics data.
Website: https://boalang.github.io/NR/


These instructions will get you a command line, jupyter notebook, Docker container, and Hadoop version of  Boa<sub>g</sub>. You can also set up a programming environment in Eclipse.

### Prerequisites

You need to install Java. Boa<sub>g</sub> compiler is written in java. It can be downloaded [here](https://www.oracle.com/technetwork/java/javase/downloads/index.html).


## Non Redundant (NR) database and CD-HIT clustering dataset

* Protobuffer schema and the step by step data generation is shown [here](https://github.com/boalang/NR/blob/master/supplemental/Data_Generation.md).
* [JSON files version of NR for MongoDB](supplemental/MongoDB.md)


## Run Boa<sub>g</sub>

### From Jupyter notebook
* Prerequisite is Jupyter: [install](https://jupyter.org/install)
* [Instructions on How to integrate Boa<sub>g</sub> with Jupyter](jupyter_notebooks)
* [Jupyter notebook example](jupyter_notebooks)

### From command line
* [Instructions on How to run Boa<sub>g</sub> scripts on a command line ](https://github.com/boalang/NR/tree/master/Command_Line)

### On a Docker container
* [Instructions on How to run Boa<sub>g</sub> scripts in a Docker container ](https://github.com/boalang/NR/tree/master/Docker)

### On Hadoop
* [Instructions on how to run Boa<sub>g</sub> on Bridges](supplemental/Hadoop.md)

## Boa<sub>g</sub> Compiler source code
* Boa<sub>g</sub> compiler is written in Java. See the [source code](compiler)
* This is a video on step by step instructions to set up programming environment on Eclipse for Boa compiler. [link](https://www.youtube.com/watch?v=s4-xfprwJ0c)


## Boa<sub>g</sub>  Query Script examples:
* [Query over NR database](Boa%20queries)


## Download dataset and VirtualBox
* [Google Drive Link](https://drive.google.com/drive/folders/1u-APb-clMbPNpHXhalthPWEDsNT-OtnX?usp=sharing)
* Web interface is also implemented in the Ubuntu linux and it can be seen in the VirtualBox.
