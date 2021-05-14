from typing import Tuple

import numpy as np
import pandas as pd
from sklearn.svm import SVC
import matplotlib.pyplot as plt
datasets = ['LungTrain.txt', 'LungTest.txt', 'KEGG_DATA.txt']
training_dataset, testing_dataset, kegg_dataset = [
    pd.read_csv(dataset, sep='\t')
    for dataset in datasets
]


def preprocess_data(dataset: pd.DataFrame) -> Tuple[pd.Series, pd.Series, pd.DataFrame]:
    """To process read datasets.
    "Cleared" up column names are stored in the list dataset_labels.
    Firstly, this function returns gene names as a pd.Series type, indexed.
    Secondly, it returns label names as a pd.Series type, indexed.
    Thirdly, it returns the dataset altered in the following ways:
        -   Its columns are renamed by the dataset_labels list.
        -   It gets transposed.
    Args:
        dataset(pd.DataFrame): Read dataset.
    Returns:
        Tuple[pd.Series, pd.DataFrame]: Returns a tuple containing dataset genes and processed dataset.
    """
    dataset_genes = dataset.iloc[:, 0]
    dataset_labels = pd.Series([
        'Cancer' if 'Cancer' in dataset_column else 'Normal' if 'Normal' in dataset_column else dataset_column
        for dataset_column in list(dataset.columns)
    ])
    altered_dataset = dataset.set_axis(
        dataset_labels, axis='columns').T.iloc[1:]
    return dataset_genes, dataset_labels[1:], altered_dataset

training_genes, training_labels, training_dataset = preprocess_data(
    training_dataset)
testing_genes, testing_labels, testing_dataset = preprocess_data(
    testing_dataset)

x_train = np.array(training_dataset)
y_train = np.array(training_labels)
svm_model = SVC().fit(x_train, y_train)


x_test = np.array(testing_dataset)
y_test = np.array(testing_labels)
svm_accuracy = svm_model.score(x_test, y_test)
svm_prediction = svm_model.predict(x_test)

print(svm_accuracy)
print(svm_prediction)
