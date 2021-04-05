#!/usr/bin/env python
# coding: utf-8

# # P-Values T-test

# In[39]:


import numpy as np
import pandas as pd
import seaborn as sns


# In[40]:


genes = pd.read_csv("http://139.91.190.186/tei/bioinformatics/genes.txt", sep="\t")


# In[41]:


genes


# In[42]:


sns.heatmap(genes.iloc[0:20,1:])


# ## t-test

# In[43]:


import scipy.stats as stats


# In[44]:


genes.iloc[1, 11:]


# In[45]:


st, pval = stats.ttest_ind(genes.iloc[1, 1:11], genes.iloc[1, 11:])


# In[46]:


pval


# In[47]:


genes.shape[0]


# In[48]:


pvalList = []
pvalListUnder005 = []
for x in range(genes.shape[0]):
    st, pval = stats.ttest_ind(genes.iloc[x, 1:11], genes.iloc[x, 11:])
    pvalList.append(pval)
    if pval < 0.05:
        pvalListUnder005.append(pval)
        print(x, pval)


# In[49]:


len(pvalList)


# In[50]:


len(pvalListUnder005)


# In[51]:


len(pvalList) * 0.05


# ## Bonferroni Correction

# In[52]:


pvalThreshold = 0.05 / len(pvalList)


# In[53]:


pvalThreshold


# In[54]:


pvalBonferroni = []
b_indices = []
for x in range(genes.shape[0]):
    st, pval = stats.ttest_ind(genes.iloc[x, 1:11], genes.iloc[x, 11:])
    if pval < pvalThreshold:
        pvalBonferroni.append(pval)
        print(x, pval)
        b_indices.append(x)


# In[55]:


len(pvalBonferroni)


# In[56]:


b_indices


# In[57]:


genes.iloc[b_indices, 0]


# ## Visualize Bonferroni Genes

# In[58]:


sns.heatmap(genes.iloc[b_indices, 1:])


# In[59]:


bonferroni_genes = genes.iloc[b_indices, :].copy()


# In[60]:


bonferroni_genes


# In[61]:


bonferroni_genes['CancerMean'] = bonferroni_genes.iloc[:, 1:11].mean(axis=1)


# In[62]:


bonferroni_genes


# In[63]:


bonferroni_genes['NormalMean'] = bonferroni_genes.iloc[:, 11:21].mean(axis=1)
bonferroni_genes['Diffs'] = bonferroni_genes['CancerMean'] - bonferroni_genes['NormalMean']


# In[64]:


bonferroni_genes


# In[65]:


bonferroni_genes_sorted = bonferroni_genes.sort_values(by='Diffs')


# In[66]:


bonferroni_genes_sorted


# In[67]:


sns.heatmap(bonferroni_genes_sorted.iloc[:, 1:-3])


# In[68]:


np.r_[0:10, -10:0]


# In[69]:


sns.heatmap(bonferroni_genes_sorted.iloc[np.r_[0:10, -10:0], 1:-3])


# # False Discovery Rate (FDR) - Adjusted P-Value - Q-value

# In[70]:


# Install an external library 
# !pip install statsmodels


# In[71]:


from statsmodels.stats import multitest


# In[72]:


rejected, qvalues = multitest.fdrcorrection(pvalList)


# In[73]:


qvalues


# In[74]:


pvalList


# In[75]:


qvalues < 0.05


# In[76]:


rejected


# dfdsf
# sdfs
# # Header 1
# ## header 2
# ### header 3

# In[ ]:




