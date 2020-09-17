import sys 
def Selection(A):
    for i in range(len(A)): 
        menor = i 
        for j in range(i+1, len(A)): 
            if A[menor] > A[j]: 
                menor = j	 
        A[i], A[menor] = A[menor], A[i]

n=100000
A=range(n)
for i in range(n):
    A[i]=int(input())
Selection(A)
for i in range(len(A)): 
	print("%d" %A[i]), 
 
