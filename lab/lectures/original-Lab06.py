#!/usr/bin/env python
# coding: utf-8

# # P-Values T-test

# In[2]:


import numpy as np
import pandas as pd
import seaborn as sns


# In[5]:


genes = pd.read_csv("http://139.91.190.186/tei/bioinformatics/genes.txt", sep="\t")


# In[6]:


genes


# In[13]:


sns.heatmap(genes.iloc[0:20,1:])


# ## t-test

# In[14]:


import scipy.stats as stats


# In[17]:


genes.iloc[1, 11:]


# In[18]:


st, pval = stats.ttest_ind(genes.iloc[1, 1:11], genes.iloc[1, 11:])


# In[19]:


pval


# In[25]:


genes.shape[0]


# In[28]:


pvalList = []
pvalListUnder005 = []
for x in range(genes.shape[0]):
    st, pval = stats.ttest_ind(genes.iloc[x, 1:11], genes.iloc[x, 11:])
    pvalList.append(pval)
    if(pval < 0.05):
        pvalListUnder005.append(pval)
        print(x, pval)


# In[27]:


len(pvalList)


# In[29]:


len(pvalListUnder005)


# In[30]:


len(pvalList) * 0.05


# ## Bonferroni Correction

# In[31]:


pvalThreshold = 0.05 / len(pvalList)


# In[32]:


pvalThreshold


# In[35]:


pvalBonferroni = []
b_indices = []
for x in range(genes.shape[0]):
    st, pval = stats.ttest_ind(genes.iloc[x, 1:11], genes.iloc[x, 11:])
    if(pval < pvalThreshold):
        pvalBonferroni.append(pval)
        print(x, pval)
        b_indices.append(x)


# In[34]:


len(pvalBonferroni)


# In[36]:


b_indices


# In[37]:


genes.iloc[b_indices, 0]


# ## Visualize Bonferroni Genes

# In[38]:


sns.heatmap(genes.iloc[b_indices, 1:])


# In[39]:


bonferroni_genes = genes.iloc[b_indices, :].copy()


# In[40]:


bonferroni_genes


# In[41]:


bonferroni_genes['CancerMean'] = bonferroni_genes.iloc[:, 1:11].mean(axis=1)


# In[42]:


bonferroni_genes


# In[43]:


bonferroni_genes['NormalMean'] = bonferroni_genes.iloc[:, 11:21].mean(axis=1)
bonferroni_genes['Diffs'] = bonferroni_genes['CancerMean'] - bonferroni_genes['NormalMean']


# In[44]:


bonferroni_genes


# In[45]:


bonferroni_genes_sorted = bonferroni_genes.sort_values(by='Diffs')


# In[46]:


bonferroni_genes_sorted


# In[47]:


sns.heatmap(bonferroni_genes_sorted.iloc[:, 1:-3])


# In[49]:


np.r_[0:10, -10:0]


# In[50]:


sns.heatmap(bonferroni_genes_sorted.iloc[np.r_[0:10, -10:0], 1:-3])


# # False Discovery Rate (FDR) - Adjusted P-Value - Q-value

# In[51]:


# Install an external library 
get_ipython().system('pip install statsmodels')


# In[56]:


import statsmodels


# In[58]:


rejected , qvalues = statsmodels.stats.multitest.fdrcorrection(pvalList)


# In[59]:


qvalues


# In[60]:


pvalList


# In[61]:


qvalues < 0.05


# In[62]:


rejected


# dfdsf
# sdfs
# # Header 1
# ## header 2
# ### header 3

# In[ ]:




