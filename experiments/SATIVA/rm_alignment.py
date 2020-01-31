import sys


with open(sys.argv[1], "r") as rna_file:
    for line in rna_file:
        print(line.rstrip().replace("-", ''))
