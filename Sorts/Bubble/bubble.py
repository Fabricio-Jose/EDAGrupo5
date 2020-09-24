from time import time

def burbuja(A,n):
	for i in range(n):
		for j in range(0,n-i-1):
			if(A[j]>A[j+1]):
				A[j],A[j+1]=A[j+1],A[j]

pruebas=[10000, 15000, 20000, 25000, 30000,35000]

for x in pruebas:
	f = open("entrada.txt", "r")
	A=[0]*x
	for i in range(x):
		A[i]=int(f.readline())
	f.close()
	start_time = time()
	burbuja(A,x)
	elapsed_time = time() - start_time

	res=str(x)+" , "+str(elapsed_time)+"\n"
	print(res)
	sal = open("bubblepy.txt", "a+")
	sal.write(res)
	sal.close()
	f.close()
