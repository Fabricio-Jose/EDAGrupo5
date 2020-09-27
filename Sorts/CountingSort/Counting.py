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
		Counting(A,x)
		finCrono = time() - inicioCrono
		b[v]=finCrono
	resul=promedio(b,veces)
	res=str(x)+" , "+str(resul)+"\n"
	print(res)
	sal = open("countingpyM.txt", "a+")
	sal.write(res)
	sal.close()
	f.close()


