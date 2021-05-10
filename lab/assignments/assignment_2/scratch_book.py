import pandas as pd

#   >>> Data pre-processing

# training_data = 'http://139.91.190.186/tei/bioinformatics/LungTrain.txt'
# test_data = 'http://139.91.190.186/tei/bioinformatics/LungTest.txt'
# kegg_data = 'http://139.91.190.186/tei/bioinformatics/c2.cp.kegg.v7.4.entrez.gmt'

datasets = ['KEGG_DATA.txt', 'LungTest.txt', 'LungTrain.txt']
# training_data, test_data, kegg_data = datasets[::]

training_data, test_data, kegg_data = [
    pd.read_csv(dataset, sep='\t')
    for dataset in datasets
]

print(training_data.head(5))
print(training_data.T.head(5))

#   <<< Data pre-processing
