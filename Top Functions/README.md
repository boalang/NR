# Top Protein functions

This is the BoaG query:

```text
[hbagheri@login005 protFuncClstrSep2019OUTPUT]$ cat ../protFuncFreqAug2019V2.boa
s: Sequence = input;
protOut : output sum [string][string] of int;
 
distinctTax := function (seq: Sequence): int{
  taxSet : set of string;
  foreach(i:int; def(seq.annotation[i]))
   add(taxSet,seq.annotation[i].tax_id);
   
  return(len(taxSet));
  
};


if (distinctTax(s) > 10){
 foreach(i:int; def(s.annotation[i])){
   if (strfind("[",s.annotation[i].defline)> 0)
    protOut [trim(substring(s.annotation[i].defline, 0, strfind("[",s.annotation[i].defline)))][s.seqid] << 1;
   else
    protOut [s.annotation[i].defline][s.seqid]<<1;
  }
}
```
The output on the cluster: `/pylon5/mc5fr5p/hbagheri/09_Hadoop/protFuncFreqAug2019V2OUTPUT/part-r-00000`


* List of top protein functions

```
('transcriptional regulator', 24789)
('putative membrane protein', 17151)
('ABC transporter ATP-binding protein', 10310)
('MFS transporter', 8821)
('ABC transporter permease', 8748)
('putative uncharacterized protein', 7731)
('transposase', 6915)
('LysR family transcriptional regulator', 6500)
('predicted protein', 6056)
('putative lipoprotein', 5902)
('lipoprotein', 5883)
('oxidoreductase', 5881)
('cytochrome oxidase subunit 1, partial (mitochondrion)', 5570)
('Putative uncharacterized protein', 5004)
('ABC transporter, ATP-binding protein', 4963)
('DNA-binding response regulator', 4935)
('DNA-binding protein', 4821)
('putative transcriptional regulator', 4761)
('transporter', 4614)
('MULTISPECIES: ABC transporter ATP-binding protein', 4522)
('phage protein', 4429)
('histidine kinase', 4305)
('MULTISPECIES: MFS transporter', 4300)
('ABC transporter family protein', 4233)
('acetyltransferase', 4227)
('MULTISPECIES: ABC transporter permease', 4123)
('ABC transporter', 4067)
('MULTISPECIES: LysR family transcriptional regulator', 4038)
('GNAT family N-acetyltransferase', 4006)
('XRE family transcriptional regulator', 3732)
('ABC transporter substrate-binding protein', 3726)
('N-acetyltransferase', 3726)
('TetR family transcriptional regulator', 3707)
('AraC family transcriptional regulator', 3521)
('hydrolase', 3456)
('Uncharacterized protein conserved in bacteria', 3294)
('alpha/beta hydrolase', 3172)
('putative exported protein', 3169)
('putative cytoplasmic protein', 3155)
('response regulator', 3096)
('inner membrane protein', 3078)
('[protein-PII', 3027)
('GntR family transcriptional regulator', 3001)
('MULTISPECIES: DNA-binding response regulator', 2921)
('phage tail protein', 2870)
('putative oxidoreductase', 2741)
('two-component system response regulator', 2701)
('TetR/AcrR family transcriptional regulator', 2671)
('integrase', 2663)
('peptidase', 2636)
('Transcriptional regulator', 2577)
('SAM-dependent methyltransferase', 2568)
('ABC transporter, permease protein', 2564)
('MULTISPECIES: membrane protein', 2557)
('putative transposase', 2544)
('putative inner membrane protein', 2533)
('conserved domain protein', 2523)
('cytoplasmic protein', 2467)
('MULTISPECIES: transcriptional regulator', 2441)
('sensor histidine kinase', 2423)
('conserved protein', 2368)
('ATPase', 2362)
('integral membrane protein', 2340)
('methyltransferase', 2264)
('transcriptional regulator, TetR family', 2229)
('glycosyl transferase', 2227)
('[citrate (pro-3S)-lyase', 2197)
('permease', 2189)
('MarR family transcriptional regulator', 2171)
('transcriptional regulator, LysR family', 2151)
('MULTISPECIES: TetR/AcrR family transcriptional regulator', 2144)
('ATP-binding protein', 2128)
('glycosyltransferase', 2121)
('fimbrial protein', 2120)
('MULTISPECIES: GNAT family N-acetyltransferase', 2081)
('two-component sensor histidine kinase', 2079)
('acetyltransferase, GNAT family', 2040)
('Uncharacterized conserved protein', 2036)
('[acyl-carrier-protein', 1957)
('MULTISPECIES: XRE family transcriptional regulator', 1914)
('MULTISPECIES: SDR family oxidoreductase', 1881)
('GNAT family acetyltransferase', 1872)
('diguanylate cyclase', 1862)
('bacterial regulatory helix-turn-helix, lysR family protein', 1838)
('binding--dependent transport system inner membrane component family protein', 1823)
('major Facilitator Superfamily protein', 1785)
('SDR family oxidoreductase', 1767)


```
