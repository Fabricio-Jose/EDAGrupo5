from time import time

def insercion(A,n):
	for i in range(1,n):
		x=A[i]
		j=i-1
		while j>=0 and A[j]>x:
			A[j+1]=A[j];
			j=j-1;
		A[j+1]=x



pruebas=[10000,20000,30000,40000,50000]

for x in pruebas:
	f = open("entrada.txt", "r")
	A=[0]*x
	for i in range(x):
		A[i]=int(f.readline())
	f.close()
	start_time = time()
	insercion(A,x)
	elapsed_time = time() - start_time

	print(x," ",elapsed_time)

