# Database normalization
## Normalization definitions
### 1NF
A relation is in first normal form if and only if the domain of each attribute contains only atomic (indivisible) values, and the value of each attribute contains only a single value from that domain.

*Source: [Wikipedia](https://en.wikipedia.org/wiki/First_normal_form).*
### 2NF
A relation is in the second normal form if it fulfills the following two requirements:
- It is in first normal form.
- It does not have any non-prime attribute that is functionally dependent on any proper subset of any candidate key of the relation. **A non-prime attribute of a relation** is an attribute that is not a part of any candidate key of the relation.
  
Put simply, a relation is in 2NF if it is in 1NF and every non-prime attribute of the relation is dependent on the whole of every candidate key.

*Source: [Wikipedia](https://en.wikipedia.org/wiki/Second_normal_form).*
### 3NF
A table is in 3NF *if and only* if both of the following conditions hold:
- The relation R (table) is in second normal form (2NF).
- Every non-prime attribute of R is non-transitively dependent on every key of R.

A non-prime attribute of R is an attribute that does not belong to any candidate key of R.

*Source [Wikipedia](https://en.wikipedia.org/wiki/Third_normal_form).*
## Example
### Database in no normal form
<!-- TODO: Add initial table in no normal form -->
### Database in 1NF
<!-- TODO: Change previous table to be in 1NF -->
### Database in 2NF
<!-- TODO: Change previous table to be in 2NF -->
### Database in 3NF
<!-- TODO: Change previous table to be in 3NF -->
