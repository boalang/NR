import sys

# input: WP_023844635:1090322=1;2221=1
# just get IDs


with open(sys.argv[1], 'r') as sample_file, open('protein_ids', 'w') as id_file:
    for line in sample_file:
        if line.find(":") != -1:
            row_id = line[:line.index(":")]
            id_file.write(row_id + "\n")

