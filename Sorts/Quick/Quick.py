from io import open
from time import time
#import math

def particion(A,p,r): 
    i=(p-1) 
    x=A[r]
    for j in range(p,r): 
        if A[j]<x:  
            i=i+1
            A[i],A[j]=A[j],A[i] 
    A[i+1],A[r] = A[r],A[i+1] 
    return (i+1)

def quicksort(A,p,r): 
    if p<r:
        q = particion(A,p,r)
        quicksort(A,p,q-1)
        quicksort(A,q+1,r)

def promedio(b,n):
	prom=b[0]
	for i in range(1,n):
		prom=prom+b[i]
	return (prom/n)


pruebas=[100000, 300000, 500000, 700000,900000,1000000]
veces=5

for x in pruebas:
	f = open("../entrada5M.txt", "r")
	b=[0]*veces
	for v in range(veces):
		A=[0]*x
		for i in range(x):
			A[i]=int(f.readline())
	
		inicioCrono = time()
		quicksort(A,0,x-1)
		finCrono = time() - inicioCrono
		b[v]=finCrono
	resul=promedio(b,veces)
	res=str(x)+" , "+str(resul)+"\n"
	print(res)
	sal = open("quickpyM.txt", "a+")
	sal.write(res)
	sal.close()
	f.close()