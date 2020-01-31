import sys



# we need to remove those IDs that already have misannotation, make sure we have a verified sample of RefSeq: 
# python sample_verified.py misannotated_keys sample_RefSeq
# output of this program is in sample_verified that doesn't have any misannotation

# misannotated_ids are those protein ids (file names) that we know have misannotations
with open(sys.argv[1]) as f:
    misannotated_ids = f.read().splitlines()

with open(sys.argv[2], 'r') as sample_file, open('sample_verified', 'w') as sample_verified:
    for line in sample_file:
        if line.find(":") != -1:
            row_id = line[:line.index(":")]
            if row_id not in misannotated_ids:
                sample_verified.write(line)
