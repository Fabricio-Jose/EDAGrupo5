from io import open
from time import time
#import math

def getMax(A,size): 
    maxi = A[1];
    for i in range(size):
        if A[i]>maxi:
            maxi=A[i]
    return maxi

def CountSort(A,size): 
    output=[0]*(size+1)
    maxi=getMax(A,size)
    
    count=[0]*(maxi+1)
#    for i in range(maxi+1):
#        count[i]=0
    for i in range(1,size):
        count[int(A[i])] +=1
    for i in range(1,maxi+1):
        count[i]+=count[i-1]
    for i in range(size-1,0):
        output[count[int(A[i])]]=A[i]
        count[int(A[i])]-=1
    for i in range(0,size):
        A[i]=output[i]
    

tams = [100000,200000,500000,700000,800000,1000000]
times = [0,0,0,0,0,0]
f=open("CountPy.txt","w")

for j in range(6):            
    archivo=open("entrada.txt","r")
    lista=archivo.readlines()
    archivo.close()
    n=tams[j];
    for i in range(n):
        lista[i]=int(lista[i])
    t0=time()
    CountSort(lista,n)     
    tiempo =time()-t0
    tiempo=round(tiempo,3)
    print(tiempo)
    lista.clear()
    f.write(str(tams[j])+" , "+str(tiempo)+"\n")
