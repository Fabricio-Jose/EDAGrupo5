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

tams = [100000,200000,500000,700000,800000,1000000]
times = [0,0,0,0,0,0]
f=open("QuickPy.txt","w")

for j in range(6):            
    archivo=open("entrada.txt","r")
    lista=archivo.readlines()
    archivo.close()
    n=tams[j];
    for i in range(n):
        lista[i]=int(lista[i])
    t0=time()
    quicksort(lista,0,n-1) 
    tiempo =time()-t0
    tiempo=round(tiempo,3)
    print(tiempo)
    lista.clear()
    f.write(str(tams[j])+" , "+str(tiempo)+"\n")
