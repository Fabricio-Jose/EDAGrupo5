from time import time
from io import open

def heapify(arr, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2

    if l < n and arr[i] < arr[l]:
        largest = l

    if r < n and arr[largest] < arr[r]:
        largest = r

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heapSort(arr):
    n = len(arr)

    for i in range(n//2, -1, -1):
        heapify(arr, n, i)

    for i in range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)
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
		heapSort(A)
		finCrono = time() - inicioCrono
		b[v]=finCrono
	resul=promedio(b,veces)
	res=str(x)+" , "+str(resul)+"\n"
	print(res)
	sal = open("heappyM.txt", "a+")
	sal.write(res)
	sal.close()
	f.close()



