#!/usr/bin/env python
# coding: utf-8

# # Imports

# In[ ]:


import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
get_ipython().run_line_magic('matplotlib', 'inline')


# # Data pre-processing

# In[ ]:


genes = pd.read_csv('http://139.91.190.186/tei/bioinformatics/assignment.txt', sep='\t').iloc[:, 1:]


# In[ ]:


sns.heatmap(genes.iloc[:40])


# # Data analysis

# ## Gene expression analysis using means

# In[ ]:


genes['Cancer.Mean'] = genes.filter(like='Cancer').mean(axis=1)


# In[ ]:


genes['Normal.Mean'] = genes.filter(like='Normal').mean(axis=1)


# In[ ]:


genes['Means.Delta'] = genes['Cancer.Mean'] - genes['Normal.Mean']


# In[ ]:


means_delta_sorted_genes = genes.sort_values(by='Means.Delta')


# In[ ]:


sliced_means_delta_sorted_genes = means_delta_sorted_genes.head(20).append(means_delta_sorted_genes.tail(20))


# In[ ]:


sns.heatmap(sliced_means_delta_sorted_genes.iloc[:, :-3])


# ## Gene expression analysis using p-value

# ## Gene expression analysis using Bonferroni corrected p-value

# ## Gene expression analysis using q-value

# # Data Validation

# In[ ]:




