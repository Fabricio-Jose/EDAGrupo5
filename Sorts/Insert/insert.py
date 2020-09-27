from time import time

def insercion(A,n):
	for i in range(1,n):
		x=A[i]
		j=i-1
		while j>=0 and A[j]>x:
			A[j+1]=A[j]
			j=j-1
		A[j+1]=x
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
		insercion(A,x)
		finCrono = time() - inicioCrono
		b[v]=finCrono
	resul=promedio(b,veces)
	res=str(x)+" , "+str(resul)+"\n"
	print(res)
	sal = open("insertpy.txt", "a+")
	sal.write(res)
	sal.close()
	f.close()



