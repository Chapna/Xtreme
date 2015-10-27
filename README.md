# Xtreme
## Introduction
## Problems
### Digit Fun
Recurrence relations are an important tool for the computer scientist.
Many algorithms, particularly those that use divide and conquer, have time complexities best modeled by recurrence relations. A recurrence relation allows us to recursively define a sequence of values by defining the nth value in terms of certain of its predecessors.
Many natural functions, such as factorials and the Fibonacci sequence, can easily be expressed as recurrences. The function of interest for this problem is described below.
Let $|A_n|$ denote the number of digits in the decimal representation of $A_n$. Given any number $A_0$, we define a sequence using the following recurrence:
$A_i = |A_{i-1}| for i > 0$
The goal of this problem is to determine the smallest positive i such that $A_i = A_{i-1}$.
