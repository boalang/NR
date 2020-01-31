# NR Descriptive



|Database|review status| #of records in NR
|--|--| --|
|NCBI RefSeq| Experimental| 119371803
|NCBI GenBank/GenPept| Unreviewed| 54709895
|UniPort SwissProt| Experimental|  78252
|Uniport TrEMBL| Computational|1341
|PDB|Experimental |92808


## NR database:
* nr contains non-redundant sequences from GenBank translations (i.e. GenPept) together with sequences from other databanks (Refseq, PDB, SwissProt, PIR and PRF).
  - link: http://www.bioinf.org.uk/teaching/gradtrain/blast.html



##### Reviewed vs not reviewed
ref: https://www.biostars.org/p/164641/

Nr database encompasses sequences from both, non-curated and curated databases:

Non-curated databases (low quality):

* GenBank/GenPept - unreviewed sequences submitted from individual laboratories and large-scale sequencing projects. Since these sequence records are owned by the original submitters and can not be altered, GenBank might contain many low quality sequences.
* trEMBL - unreviewed section of UniProt. This section contains a computer-annotated supplement of SwissProt that contains all the translations of EMBL nucleotide sequence entries not yet integrated in SwissProt

Curated databases (high quality):

* RefSeq - GenBank sequences that are manually curated by the NCBI staff. RefSeq records are owned by NCBI and can be updated as needed to maintain current annotation or to incorporate additional information.
* SwissProt - manually annotated and reviewed protein sequences
* PIR -  non-redundant annotated protein sequence database
* PDB - experimentally-determined structures of proteins, nucleic acids, and complex assemblies



##### UniProtKB
* Link: https://www.uniprot.org/uniprot/

* statistics: https://www.uniprot.org/statistics/Swiss-Prot

* [UniProtKB](https://www.uniprot.org/uniprot/) consists of two sections:
  - Reviewed (Swiss-Prot) - Manually annotated
  Records with information extracted from literature and curator-evaluated computational analysis.
  - Unreviewed (TrEMBL) - Computationally analyzed
  Records that await full manual annotation.
  - we can download key ids of reviewed and unreviewed here: https://www.uniprot.org/uniprot/?query=reviewed:yes

* <span style="color:blue"> Key IDs starts with: </span>
 - A: Example A7ZVX4
 - B:
 - C:
 - P: P54670.1
 - Q: Example Q65ZU1


##### PDB:
* Starts with numbers

##### Refseq:
* [Refseq vs Genebank](https://www.quora.com/What-is-the-difference-between-Refseq-and-Genbank)
* <span style="color:blue">two characters followed by an underscore (e.g., NP_)  </span>
* Starts with WP, XR, XM, XP
  - [<span style="color:blue">RefSeq accession numbers </span> ](https://www.ncbi.nlm.nih.gov/books/NBK21091/table/ch18.T.refseq_accession_numbers_and_mole/?report=objectonly)

##### GenBank
* <span style="color:blue"> GenBank accession numbers never include an underscore. </span>
* Examples:  EAL68086.1, EFV38153.1, PVV54666.1


##### PIR:
 * stats: https://proteininformationresource.org/rps/
 * Starts with
   - T example: [T15373](https://proteininformationresource.org/cgi-bin/nbrfget?uid=T15373)

##### PRF
* ref: https://www.prf.or.jp/aboutdb-e.html
