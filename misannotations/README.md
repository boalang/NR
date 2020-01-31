# Misannotation in the NR database

### Detected Misannotated
* [Root and kingdom violations](results)
  - These are few examples of violations, full list is in the Google Drive link.

* [Misannotations in clusters](results/Cluster)

* [Google Drive link](https://drive.google.com/drive/u/2/folders/1lF7boVEF2hf9CSl0quW0T4IkRc54Fjd7)

* [Case Study: Glycine](examples.md)

### Dataset
* Boa<sub>g</sub> script output used to check misannotations

   ```
   s: Sequence = input;
   count : output sum [string][string] of int;
   foreach(i:int; def(s.annotation[i]))
     count [s.seqid][s.annotation[i].tax_id] << 1;
   ```

 * [Output of the script on the Google Drive](https://drive.google.com/drive/u/2/folders/1W4byknJrRCBfMMltUP68Hk649cEKEzKG)
