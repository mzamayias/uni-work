#!/usr/bin/env python
# coding: utf-8

# # Pandas

# In[1]:


import pandas as pd


# In[2]:


df = pd.read_csv("http://139.91.190.186/tei/Salaries.csv")


# In[3]:


df.head()


# In[4]:


df.dtypes


# In[5]:


df.tail()


# In[6]:


df['rank']


# In[7]:


df['rank'].dtype


# In[8]:


df.describe()


# In[9]:


df.max()


# In[10]:


df['phd']


# In[11]:


df.phd


# In[12]:


df.head(10)


# ### Filters

# In[15]:


df['rank'] == 'Prof'


# In[16]:


profs = df[df['rank'] == 'Prof']


# In[17]:


profs


# In[18]:


profs.describe()


# In[19]:


df.describe()


# ## Slicing

# In[20]:


df.loc[10:20]


# In[21]:


df.loc[10:20, ['phd', 'sex']]


# In[23]:


df.iloc[10:20, [2,4]]


# In[24]:


df.iloc[-10:, :3]


# ## Sorting

# In[27]:


df.sort_values( by =['salary'])


# In[28]:


df.sort_values( by =['salary'], ascending = False)


# In[29]:


df.sort_values( by =['salary', 'service'], ascending = [False, True])


# In[30]:


df['newColumn'] = df['salary'] + df['service']


# In[31]:


df


# # Gene Expressions

# In[34]:


genes = pd.read_csv("http://139.91.190.186/tei/bioinformatics/genes.txt", sep = '\t')


# In[35]:


genes


# In[36]:


geneNames = genes['Gene']


# In[37]:


geneNames


# ## Visualization

# In[38]:


import matplotlib.pyplot as plt
import seaborn as sns


# In[43]:


sns.heatmap(genes.iloc[:, 1:])


# In[42]:


genes.iloc[:, 1:]


# In[47]:


genes.iloc[:, 12:21]


# In[51]:


genes['CancerMean'] = genes.iloc[:, 1:11].mean(axis=1)


# In[52]:


genes


# In[53]:


genes['NormalMean'] = genes.iloc[:, 12:21].mean(axis=1)


# In[54]:


genes


# In[55]:


genes['Diff']=genes['CancerMean']-genes['NormalMean']


# In[56]:


genes


# In[59]:


sortedGenes = genes.sort_values(by='Diff')


# In[61]:


sortedGenes


# In[60]:


sns.heatmap(sortedGenes.iloc[:, 1:-3])


# In[63]:


sns.heatmap(sortedGenes.iloc[0:30, 1:-3])


# In[64]:


sns.heatmap(sortedGenes.iloc[-30:, 1:-3])


# In[66]:


import numpy as np


# In[71]:


# Select the 20 first and the 20 last rows
np.r_[0:20 , -20:0]


# In[70]:


genes.iloc[np.r_[0:20 , -20:0]]


# In[73]:


sns.heatmap(sortedGenes.iloc[np.r_[0:10 , -10:0], 1:-3])


# # Statistics

# ## t-test

# In[75]:


import scipy.stats as stats


# In[77]:


pvalList = []
for x in range(genes.shape[0]):
    st, pval = stats.ttest_ind(genes.iloc[x, 1:11] , genes.iloc[x, 12:21])
    pvalList.append(pval)
    if(pval < 0.05):
        print(x, genes.iloc[x,0], pval)


# In[ ]:




