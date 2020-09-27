from time import time
from io import open

def mergeSort(arr): 
    if len(arr) > 1: 
        mid = len(arr)//2
        L = arr[:mid]
        R = arr[mid:]

        mergeSort(L)
        mergeSort(R)
  
        i = j = k = 0

        while i < len(L) and j < len(R): 
            if L[i] < R[j]: 
                arr[k] = L[i] 
                i+= 1
            else: 
                arr[k] = R[j] 
                j+= 1
            k+= 1
          
        while i < len(L): 
            arr[k] = L[i] 
            i+= 1
            k+= 1
          
        while j < len(R): 
            arr[k] = R[j] 
            j+= 1
            k+= 1
  
def promedio(b,n):
	prom=b[0]
	for i in range(1,n):
		prom=prom+b[i]
	return (prom/n) 

pruebas=[100000,200000,500000,700000,800000,1000000]
veces=5

for x in pruebas:
	f = open("../entrada5M.txt", "r")
	b=[0]*veces
	for v in range(veces):
		A=[0]*x
		for i in range(x):
			A[i]=int(f.readline())
	
		inicioCrono = time()
		mergeSort(A)
		finCrono = time() - inicioCrono
		b[v]=finCrono
	resul=promedio(b,veces)
	res=str(x)+" , "+str(resul)+"\n"
	print(res)
	sal = open("mergepyM.txt", "a+")
	sal.write(res)
	sal.close()
	f.close()




