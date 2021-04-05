#!/usr/bin/env python
# coding: utf-8

# # Strings

# In[2]:


'Hello my name is    Lefteris'.split()


# In[4]:


a = 'Hello    my      name     is    Lefteris'.split()


# In[5]:


a


# In[6]:


' '.join(a)


# # Dictionaries

# In[7]:


phones = {}


# In[8]:


phones["Dimitris"] = 222222


# In[9]:


phones["Maria"] = 333333
phones["Takis"] = 45353635


# In[10]:


print(phones)


# In[11]:


for name, number in phones.items():
    print("The phone number of %s is %d" % (name, number))


# In[12]:


del phones["Maria"]
print(phones)


# # Functions

# In[13]:


def my_function():
    print("Hello world !");


# In[14]:


my_function()


# In[15]:


def my_sum(a,b):
    return (a+b)


# In[16]:


my_sum(12, 45)


# In[17]:


def f(n):
    return n/2, n//2


# In[18]:


a, b = f(11)
print(a,b)


# ### Functions

# In[19]:


def fact(N):
    print("Computing factorial for N=", N);
    if(N==1):
        return 1;
    return N*fact(N-1);


# In[20]:


fact(2)


# In[21]:


fact(15)


# # List Comprehension

# In[22]:


x = []
for ch in 'BioInformatics':
    x.append(ch);
print(x)


# In[23]:


x2 = [ ch for ch in 'BioInformatics']
print(x2)


# In[25]:


x = [2,54,67,2,657,87,4,234,654,65,76,43,23465,45,56,54,4]
s = 0
for i in x:
    if i%2 == 1:
        s+= i;
s    


# In[26]:


sum([i for i in x if i%2 == 1])


# # Lambda Functions

# In[27]:


def f(x):
    return(x/2)


# In[28]:


f(4)


# In[29]:


f2 = lambda x : x/2


# In[30]:


f2(10)


# # NumPy

# In[31]:


import numpy as np


# In[33]:


np.ones((3,2))


# In[34]:


np.zeros(23)


# In[36]:


np.arange(12342, 12350)


# In[37]:


A = np.ones((2,3))
B = np.zeros((4,3))


# In[38]:


np.concatenate([A,B])


# In[39]:


np.concatenate([B,A])


# In[40]:


np.concatenate([B,A], axes = 1)


# In[41]:


A = np.ones((4,1))


# In[42]:


A


# In[44]:


np.concatenate([B,A], axis = 1)


# In[47]:


rnd = np.random.random()


# In[51]:


rnd


# In[53]:


np.random.random((10, 3))


# In[55]:


rnd = np.random.random((10, 3)) * 100


# In[60]:


rnd.reshape(5,-1)


# In[61]:


rnd


# In[62]:


rnd.T


# In[63]:


rnd*5


# In[64]:


np.sqrt(rnd)


# In[65]:


np.isnan(rnd)


# In[ ]:




