#!/usr/bin/python

from ete3 import NCBITaxa, Tree
import sys
import os
import threading

'''
 input example:
    1A43:11676=1;11698=4
    1BOB:4932=1;559292=2
    1WWW:32630=1;9606=13;1223232=14 


 output: 

'''

ncbi = NCBITaxa()

f= open(sys.argv[1])
lines = f.readlines()

misannotated_ids = []



def initializaiton():
    mk_directory("root")
    mk_directory("noRank")
    mk_directory("cellular")
    mk_directory("phylum")
    mk_directory("superkingdom")
    mk_directory("class")


def mk_directory(folderName):

    if os.path.exists(folderName):# check if the directory exists
        return
    try:
        os.makedirs(folderName)
    except OSError:
        print("Creation of the directory %s failed" % folderName)
    else:
        print("Successfully created the directory %s" % folderName)


def tree_validation(key, taxDic):
    from ete3 import NCBITaxa
    ncbi = NCBITaxa()
    file_path=""

    tax_list = list(taxDic.keys())
    if len(tax_list) < 2:
        return

    try:
        tree = ncbi.get_topology(tax_list, intermediate_nodes=False)

        for node in tree:
            node.add_features(count=taxDic[node.name])

        tmp_tree2 = tree.get_ascii(attributes=["sci_name", "rank", "count"])


        # print(tmp_tree2)

        # if root is the LCA then it is mis-annotations
        if "root" in tmp_tree2:
            file_path = "root/"+ str(len(tax_list))
            mk_directory(file_path)
            file_path += "/" + key
            # print("root in the tree => mis-assignment (root violation) keyID: " + key)
            with open(file_path, "w") as f:
                f.write(tmp_tree2)

        # check the kindom violation.
        elif "cellular organisms" in tmp_tree2:
            file_path = "cellular/" + str(len(tax_list))
            mk_directory(file_path)
            file_path += "/" + key

            # print("cellular organisms in the tree => mis-assignment (cellular organisms violation) keyID: " + key)
            with open(file_path, "w") as f:
                f.write(tmp_tree2)

        # check if there is no rank TODO: double check if needed.
        # elif ", no rank" in tmp_tree2:
        #     file_path = "noRank/" + str(len(tax_list))
        #     mk_directory(file_path)
        #     file_path += "/" + key
        #     print(", no rank in the tree => mis-assignment (, no rank violation) keyID: " + key)
        #     with open(file_path, "w") as f:
        #         f.write(tmp_tree2)

        # check the kindom violation.
        elif "superkingdom" in tmp_tree2:
            file_path = "superkingdom/" + str(len(tax_list))
            mk_directory(file_path)
            file_path += "/" + key

            # print("superkingdom in the tree => mis-assignment (kingdom violation) keyID: " + key)
            with open(file_path, "w") as f:
                f.write(tmp_tree2)


        # check the phylum violation.
        elif "phylum" in tmp_tree2:
            file_path = "phylym/" + str(len(tax_list))
            mk_directory(file_path)
            file_path += "/" + key

            # print("phylum in the tree => mis-assignment (phylum violation) keyID: " + key)
            file_path
            with open(file_path, "w") as f:
                f.write(tmp_tree2)
        # check the class violation.
        elif ", class" in tmp_tree2:
            file_path = "class/" + str(len(tax_list))
            mk_directory(file_path)
            file_path += "/" + key

            # print("class in the tree => mis-assignment (class violation) keyID: " + key)
            with open(file_path, "w") as f:
                f.write(tmp_tree2)

        # check the order violation ", order"
        elif ", order" in tmp_tree2:
            file_path = "order/" + str(len(tax_list))
            mk_directory(file_path)
            file_path += "/" + key

            # print("order in the tree => mis-assignment (order violation) keyID: " + key)
            with open(file_path, "w") as f:
                f.write(tmp_tree2)

        # check the family violation  ", family"
        elif ", family" in tmp_tree2:
            file_path = "family/" + str(len(tax_list))
            mk_directory(file_path)
            file_path += "/" + key

            # print("order in the tree => mis-assignment (order violation) keyID: " + key)
            with open(file_path, "w") as f:
                f.write(tmp_tree2)
        # check the genus violation ", genus"
        elif ", genus" in tmp_tree2:
            file_path = "genus/" + str(len(tax_list))
            mk_directory(file_path)
            file_path += "/" + key

            # print("order in the tree => mis-assignment (order violation) keyID: " + key)
            with open(file_path, "w") as f:
                f.write(tmp_tree2)
    except:
        print("error: tax list = " + str(tax_list))



def check_clusters():
    taxSet = set()
    current_id = -1
    with open(sys.argv[1], "r") as f:
        for line in f:
            # print(line)
            row_id = line[line.index("[") + 1:line.index("][")]  # counts[47841781][1496] = 9
            tax_id = line[line.index("][") + 2:line.index("] =")]
            tax_count = line[line.index("= ") + 2 :]
            if (current_id == -1):
                current_id = row_id

            # while the new line is in the same cluster add the tax ids to the set
            if current_id == row_id:
                #TODO: count number of tax ids for each protein or cluster here
                if tax_id !='' and tax_id !='0':
                    taxSet.add(tax_id)

            else:

                # print(current_id)
                # print(taxSet)
                tree_validation(current_id, list(taxSet))

                current_id = row_id
                taxSet.clear()
                if tax_id !='' and tax_id !='0':
                    taxSet.add(tax_id)

    # print(current_id)
    # print(taxSet)
    tree_validation(current_id, list(taxSet))


# parallel version of the above function
def check_clusters2(start, length, steps):
    taxSet = set()

    for i in range(start, length, steps):
        line = lines[i]
        # print(line)
        row_id = line[:line.index(":")]  # 1A43:11676=1;11698=4
        row_tax = line[line.index(":")+1:].rstrip()
        tax_list =row_tax.split(";")
        for i in range(len(tax_list)):
            tax_id = tax_list[i][:tax_list[i].index("=")]
            tax_count = tax_list[i][tax_list[i].index("=")+1:]
            taxSet.add(tax_id)

        tree_validation(row_id, list(taxSet))
        taxSet.clear()

def annotate_trees(start, length, steps):
    taxDic = dict()

    for i in range(start, length, steps):
        line = lines[i]
        # print(line)
        if line.find(":") != -1:
            row_id = line[:line.index(":")]  # 1A43:11676=1;11698=4

            # if row_id in misannotated_ids:

            row_tax = line[line.index(":") + 1:].rstrip()
            tax_list = row_tax.split(";")
            taxDic.clear()
            for i in range(len(tax_list)):
                tax_id = tax_list[i][:tax_list[i].index("=")]
                tax_count = tax_list[i][tax_list[i].index("=") + 1:]
                taxDic[tax_id] = tax_count

            tree_validation(row_id, taxDic)
            # generate the tree
            # ncbi = NCBITaxa()
            #
            # try:
            #     tree = ncbi.get_topology(list(taxSet), intermediate_nodes=False)
            #     for node in tree:
            #         node.add_features(count=taxDic[node.name])
            #
            #     tmp_tree2 = tree.get_ascii(attributes=["sci_name", "rank", "count"])
            #     print(tmp_tree2)
            #
            # except:
            #     print("error: tax list = " + str(tax_list))







def annotate_tree():

        taxDic = dict()
        with open(sys.argv[1], "r") as f:
            for line in f:
                if line.find(":") != -1:
                    row_id = line[:line.index(":")]  # 1A43:11676=1;11698=4
                    row_tax = line[line.index(":") + 1:].rstrip()
                    tax_list = row_tax.split(";")
                    taxDic.clear()
                    for i in range(len(tax_list)):
                        tax_id = tax_list[i][:tax_list[i].index("=")]
                        tax_count = tax_list[i][tax_list[i].index("=") + 1:]
                        taxDic[tax_id] = tax_count

                    tree_validation(row_id, taxDic)
                else:
                    print("line: " +  line)

# check_sequences()

# check_clusters2()

# if __name__ == "__main__":

def main():
    thread_no = 8
    threads = []
    for i in range(1,thread_no):
        t = threading.Thread(target=check_clusters2, args=(i,len(lines),thread_no, ))
        threads.append(t)
        t.start()

    for t in threads:
        t.join()


def main2():
    thread_no = 8
    threads = []
    for i in range(1,thread_no):
        t = threading.Thread(target=annotate_trees, args=(i,len(lines),thread_no, ))
        threads.append(t)
        t.start()

    for t in threads:
        t.join()



if __name__ == '__main__':

    # main()
    main2()


   

