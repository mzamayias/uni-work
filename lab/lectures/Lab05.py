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

# In[13]:


df['rank'] == 'Prof'


# In[14]:


profs = df[df['rank'] == 'Prof']


# In[15]:


profs


# In[16]:


profs.describe()


# In[17]:


df.describe()


# ## Slicing

# In[18]:


df.loc[10:20]


# In[19]:


df.loc[10:20, ['phd', 'sex']]


# In[20]:


df.iloc[10:20, [2,4]]


# In[21]:


df.iloc[-10:, :3]


# ## Sorting

# In[22]:


df.sort_values( by =['salary'])


# In[23]:


df.sort_values( by =['salary'], ascending = False)


# In[24]:


df.sort_values( by =['salary', 'service'], ascending = [False, True])


# In[25]:


df['newColumn'] = df['salary'] + df['service']


# In[26]:


df


# # Gene Expressions

# In[27]:


genes = pd.read_csv("http://139.91.190.186/tei/bioinformatics/genes.txt", sep = '\t')


# In[28]:


genes


# In[29]:


geneNames = genes['Gene']


# In[30]:


geneNames


# ## Visualization

# In[31]:


import seaborn as sns


# In[32]:


sns.heatmap(genes.iloc[:, 1:])


# In[33]:


genes.iloc[:, 1:]


# In[34]:


genes.iloc[:, 12:21]


# In[35]:


genes['CancerMean'] = genes.iloc[:, 1:11].mean(axis=1)


# In[36]:


genes


# In[37]:


genes['NormalMean'] = genes.iloc[:, 12:21].mean(axis=1)


# In[38]:


genes


# In[39]:


genes['Diff']=genes['CancerMean']-genes['NormalMean']


# In[40]:


genes


# In[41]:


sortedGenes = genes.sort_values(by='Diff')


# In[42]:


sortedGenes


# In[43]:


sns.heatmap(sortedGenes.iloc[:, 1:-3])


# In[44]:


sns.heatmap(sortedGenes.iloc[0:30, 1:-3])


# In[45]:


sns.heatmap(sortedGenes.iloc[-30:, 1:-3])


# In[46]:


import numpy as np


# In[47]:


# Select the 20 first and the 20 last rows
np.r_[0:20 , -20:0]


# In[48]:


genes.iloc[np.r_[0:20 , -20:0]]


# In[49]:


sns.heatmap(sortedGenes.iloc[np.r_[0:10 , -10:0], 1:-3])


# # Statistics

# ## t-test

# In[50]:


import scipy.stats as stats


# In[51]:


pvalList = []
for x in range(genes.shape[0]):
    st, pval = stats.ttest_ind(genes.iloc[x, 1:11] , genes.iloc[x, 12:21])
    pvalList.append(pval)
    if pval < 0.05:
        print(f'{x:05d}', genes.iloc[x,0], pval)


# In[ ]:




