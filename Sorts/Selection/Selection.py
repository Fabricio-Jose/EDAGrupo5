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

def promedio(b,n):
	prom=b[0]
	for i in range(1,n):
		prom=prom+b[i]
	return (prom/n)


pruebas=[10000, 15000, 20000, 25000, 30000,35000]
veces=5

for x in pruebas:
	f = open("../entrada5M.txt", "r")
	b=[0]*veces
	for v in range(veces):
		A=[0]*x
		for i in range(x):
			A[i]=int(f.readline())
	
		inicioCrono = time()
		Selection(A,x)
		finCrono = time() - inicioCrono
		b[v]=finCrono
	resul=promedio(b,veces)
	res=str(x)+" , "+str(resul)+"\n"
	print(res)
	sal = open("selectionpy.txt", "a+")
	sal.write(res)
	sal.close()
	f.close()



