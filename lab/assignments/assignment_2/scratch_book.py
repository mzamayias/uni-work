import pandas as pd
training_data, test_data, kegg_data = [
    'http://139.91.190.186/tei/bioinformatics/LungTrain.txt',
    'http://139.91.190.186/tei/bioinformatics/LungTest.txt',
    'http://139.91.190.186/tei/bioinformatics/c2.cp.kegg.v7.4.entrez.gmt'
]

for data in [training_data, test_data, kegg_data]:
    print(type(data))
