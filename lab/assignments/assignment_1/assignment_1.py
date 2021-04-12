import pandas as pd
import seaborn as sns
from scipy import stats

#   Read gene data
genes = pd.read_csv(
    "http://139.91.190.186/tei/bioinformatics/assignment.txt", sep="\t").iloc[:, 1:]
#   Plot first 40 genes
sns.heatmap(genes.iloc[:40])

# Calculate cancer class mean
genes["Cancer.Mean"] = genes.filter(like="Cancer").mean(axis=1)
# Calculate normal class mean
genes["Normal.Mean"] = genes.filter(like="Normal").mean(axis=1)
# Calculate class mean delta
genes["Means.Delta"] = genes["Cancer.Mean"] - genes["Normal.Mean"]

# Sort genes by 
means_delta_sorted_genes = genes.sort_values(by="Means.Delta")

sliced_means_delta_sorted_genes = pd.concat(
    [means_delta_sorted_genes.head(20), means_delta_sorted_genes.tail(20)],
    axis=0
)

sns.heatmap(sliced_means_delta_sorted_genes.iloc[:, :-3])

genes["p-value"] = [
    stats.ttest_ind(
        genes.iloc[gene_index, :8], genes.iloc[gene_index, 8:15]
    )[-1]
    for gene_index in range(genes.shape[0])
]

means_delta_sorted_genes = genes[genes['p-value']
                                 < 0.05].sort_values(by="Means.Delta")

sliced_pvalue_means_delta_sorted_genes = pd.concat(
    [means_delta_sorted_genes.head(20), means_delta_sorted_genes.tail(20)], axis=0)

sns.heatmap(sliced_pvalue_means_delta_sorted_genes.iloc[:, :-4])
