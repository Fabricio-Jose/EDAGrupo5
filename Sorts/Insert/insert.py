from time import time

def insercion(A,n):
	for i in range(1,n):
		x=A[i]
		j=i-1
		while j>=0 and A[j]>x:
			A[j+1]=A[j];
			j=j-1;
		A[j+1]=x



pruebas=[10000, 15000, 20000, 25000, 30000,35000]

for x in pruebas:
	f = open("entrada.txt", "r")
	A=[0]*x
	for i in range(x):
		A[i]=int(f.readline())
	f.close()
	start_time = time()
	insercion(A,x)
	elapsed_time = time() - start_time

	sal = open("insertpy.txt", "a+")
	res=str(x)+" , "+str(elapsed_time)+"\n"
	sal.write(res)
	sal.close()
	f.close()

