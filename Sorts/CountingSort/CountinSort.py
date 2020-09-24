from io import open
from time import time

def getMax(A,size): 
    maxi = int(A[0])
    for i in range(1,size):
        if int(A[i])>int(maxi):
            maxi=int(A[i])
    return maxi

def Counting(A,n):
    size = n
    output = [0] * size

    maxi=getMax(A,n)
    
    count=[0]*(maxi+1)

    for i in range(0, size):
        count[int(A[i])] += 1

    for i in range(1, maxi+1):
        count[i] += count[i - 1]

    for i in range(size-1,0,-1):
        output[int(count[int(A[i])]) - 1] = A[i]
        count[int(A[i])] -= 1

    for i in range(0, size):
        A[i] = output[i]


tam = [100000, 200000, 500000, 600000,800000,1000000]
times = [0,0,0,0,0,0]
f=open("CountinPy.txt","w")

for j in range(6):            
    file = open("entrada.txt","r")
    A = file.readlines()
    file.close()

    lista=[0]*tam[j]
    
    for i in range(tam[j]):
        lista[i]=int(A[i])

    t0=time()
    Counting(lista,tam[j])
    tiempo = time()-t0
    tiempo = round(tiempo,3)
    
    #print(lista)
    A.clear()
    f.write(str(tam[j])+" , "+str(tiempo)+"\n")
