#!/usr/bin/env python
# coding: utf-8

# # Strings

# In[1]:


'Hello my name is Lefteris'.split()


# In[2]:


a = 'Hello my name is Lefteris'.split()


# In[3]:


a


# In[4]:


' '.join(a)


# # Dictionaries

# In[5]:


phones = {"Dimitris": 222222, "Maria": 333333, "Takis": 45353635}


# In[6]:


print(phones)


# In[7]:


for name, number in phones.items():
    print("The phone number of %s is %d" % (name, number))


# In[8]:


del phones["Maria"]
print(phones)


# # Functions

# In[9]:


def my_function():
    print("Hello world !")


# In[10]:


my_function()


# In[11]:


def my_sum(x1, y1):
    return x1 + y1


# In[12]:


my_sum(12, 45)


# In[13]:


def f(n):
    return n/2, n//2


# In[14]:


a, b = f(11)
print(a, b)


# ### Functions

# In[15]:


def fact(n):
    print("Computing factorial for N=", n)
    if n==1:
        return 1
    return n*fact(n-1)


# In[16]:


fact(2)


# In[17]:


fact(15)


# # List Comprehension

# In[18]:


x = []
for ch in 'BioInformatics':
    x.append(ch)
print(x)


# In[19]:


x2 = [ ch for ch in 'BioInformatics']
print(x2)


# In[20]:


x = [2,54,67,2,657,87,4,234,654,65,76,43,23465,45,56,54,4]
s = 0
for i in x:
    if i%2 == 1:
        s+= i
s    


# In[21]:


sum([i for i in x if i%2 == 1])


# # Lambda Functions

# In[22]:


def f(x1):
    return x1/2


# In[23]:


f(4)


# In[24]:


f2 = lambda x1 : x1/2


# In[25]:


f2(10)


# # NumPy

# In[26]:


import numpy as np


# In[27]:


np.ones((3,2))


# In[28]:


np.zeros(23)


# In[29]:


np.arange(12342, 12350)


# In[30]:


A = np.ones((4,3))
B = np.zeros((4,3))


# In[31]:


np.concatenate([A,B])


# In[32]:


np.concatenate([B,A])


# In[33]:


np.concatenate((B, A), axis=1)


# In[34]:


A = np.ones((4,1))


# In[35]:


A


# In[36]:


np.concatenate([B,A], axis = 1)


# In[37]:


rnd = np.random.random()


# In[38]:


rnd


# In[39]:


np.random.random((10, 3))


# In[40]:


rnd = np.random.random((10, 3)) * 100


# In[41]:


rnd.reshape(5,-1)


# In[42]:


rnd


# In[43]:


rnd.T


# In[44]:


rnd*5


# In[45]:


np.sqrt(rnd)


# In[46]:


np.isnan(rnd)

