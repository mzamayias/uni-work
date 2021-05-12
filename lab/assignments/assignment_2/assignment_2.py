from typing import Tuple
import pandas as pd

datasets = ['LungTrain.txt', 'LungTest.txt', 'KEGG_DATA.txt']
training_dataset, testing_dataset, kegg_dataset = [
    pd.read_csv(dataset, sep='\t')
    for dataset in datasets
]


def preprocess_data(dataset: pd.DataFrame) -> Tuple[pd.Series, pd.DataFrame]:
    """
    Function to process read data.
    "Cleared" up column names are stored in the list dataset_labels.
    Firstly, this function returns the gene names as a pd.Series type, indexed.
    Secondly, it returns the dataset altered in the following ways:
        -   Its columns are renamed by the dataset_labels list
        -   It gets transposed.
    Args:
        dataset(pd.DataFrame): Read dataset.
    Returns:
        Tuple[pd.Series, pd.DataFrame]: Returns a tuple containing the dataset genes and
    """
    dataset_labels = [
        'Cancer' if 'Cancer' in dataset_column else 'Normal' if 'Normal' in dataset_column else dataset_column
        for dataset_column in list(dataset.columns)
    ]
    return dataset.iloc[:, 0], dataset.set_axis(dataset_labels, axis='columns').T


training_genes, training_dataset = preprocess_data(training_dataset)
testing_genes, testing_dataset = preprocess_data(testing_dataset)
