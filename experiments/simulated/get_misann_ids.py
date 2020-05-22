import os
import sys

with open("misannotated_keys", "w") as outf:
    # r=root, d=directories, f = files
    for r, d, f in os.walk(sys.argv[1]):
        for file in f:
            # if file:
            outf.write(file +'\n')