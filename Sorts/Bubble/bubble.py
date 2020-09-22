from time import time

def burbuja(A,n):
	for i in range(n):
		for j in range(0,n-i-1):
			if(A[j]>A[j+1]):
				A[j],A[j+1]=A[j+1],A[j]

pruebas=[10000,20000,30000,40000,50000]

for x in pruebas:
	f = open("entrada.txt", "r")
	A=[0]*x
	for i in range(x):
		A[i]=int(f.readline())
	f.close()
	start_time = time()
	burbuja(A,x)
	elapsed_time = time() - start_time

	print(x," ",elapsed_time)
