from io import open
from time import time
#import sys 
def Selection(A,tam):
    for i in range(tam): 
        menor = i 
        for j in range(i+1,tam):
            #x=A[menor]
            if A[j]<A[menor]:#>A[j]: 
                menor=j 
        A[i],A[menor]=A[menor],A[i]

tams = [10000, 15000, 20000, 25000, 30000,35000]
#tams = [4,4,4,4,4,4]
times = [0,0,0,0,0,0]
f=open("SelectionPy.txt","w")

for j in range(6):            
    archivo=open("entrada.txt","r")
    lista=archivo.readlines()
    archivo.close()
    n=tams[j];
    for i in range(n):
        lista[i]=int(lista[i])
    t0=time()
    Selection(lista,tams[j]) 
    tiempo =time()-t0
    tiempo=round(tiempo,3)
    print(tiempo)
    lista.clear()
    f.write(str(tams[j])+" , "+str(tiempo)+"\n")

 
