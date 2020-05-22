
import sys
import random

from ete3 import NCBITaxa
ncbi = NCBITaxa()

# this line updates the taxa database from NCBI website
# ncbi.update_taxonomy_database()


# this takes tax name and returns tax id
def get_taxid(tax_name):
    name2taxid = ncbi.get_name_translator([tax_name])
    if len(name2taxid) > 0:
        tax_id = name2taxid[tax_name][0]

    return (tax_id)


# read full nr taxa from a text file that has one taxa in each line
def get_nr_taxlist(nr_file):
    with open(nr_file, "r") as f:
        nr_taxlist = f.read().splitlines()
        print("nr tax list size:")
        print(len(nr_taxlist))
    return (nr_taxlist)

# takes tax id and returns lineage desired rank ex. phylum
def get_ranks(taxid, desired_rank):
    try:

        lineage = ncbi.get_lineage(taxid)
        lineage2ranks = ncbi.get_rank(lineage)

        ranks2lineage = dict((rank, taxid) for (taxid, rank) in lineage2ranks.items())

        if desired_rank in ranks2lineage:
            return (ranks2lineage[desired_rank])

        else:
            return ('null')
    except:
        print(taxid)

# this takes list of taxa and returns the taxanomic classification like phylum, class, order
def get_set_classification(taxa_set, desired_classification):
    cls = set()

    for item in taxa_set:
        # get lineage for each taxa
        cls.add(get_ranks(item, desired_classification))

    return (cls)

# iterate over samples and mislabel each protein
# one line example: 1APH:9606=2;9798=1;9823=50;9913=104;9940=5
def mislabel(boa_output):
    protein_taxa_set= set()

    # read full nr taxa from a text file that has one taxa in each line
    nr_full_taxa= get_nr_taxlist("/Users/hbagheri/Downloads/mis-ann/seqCount2019V3/nr_taxa_list_from_Boa")
    mislabel_rank = 'phylum'

    with open(boa_output,'r') as f, open(boa_output + "_mislabeled", 'w') as mislabeled_file:
        for line in f:
            protein_taxa_set.clear()
            line_tax = line[line.index(":")+1:]
            tax_array = line_tax.split(";")
            for item in tax_array: #10090=3
                protein_taxa_set.add(item[:item.index("=")])

            # for this protein get the desired rank classification like phylum
            set_cls= get_set_classification(protein_taxa_set, mislabel_rank)

            # now, take sample and mislabel this protein (append to the line)
            # take another sample from nr taxa list and check if its phyla is different, then misaanotate it
            while True:
                random_tax = random.sample(nr_full_taxa, 1)
                sample_rank = get_ranks(random_tax[0], mislabel_rank)
                if sample_rank not in set_cls and sample_rank != "null":
                    print("find random misann")
                    print("random rank: ", sample_rank)
                    print(random_tax)
                    break

            # write it in the disk
            # add random_tax=1 to the end
            mislabeled_file.write (line.rstrip() + ";" + random_tax[0] + "=1" + '\n')


# the verified sample is here: '/Users/hbagheri/Downloads/mis-ann/simulated/sample_verified'
mislabel(sys.argv[1])