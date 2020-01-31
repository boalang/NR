import os
import sys

path = '/Users/hbagheri/Downloads/mis-ann/clstrCount2019/'

with open("misannotated_kyes", "w") as outf:
    # r=root, d=directories, f = files
    for r, d, f in os.walk(sys.argv[1]):
        for file in f:
            # if file:
            outf.write(file +'\n')