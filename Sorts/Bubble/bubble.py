def burbuja(A,n):
	for i in range(n):
		for j in range(0,n-i-1):
			if(A[j]>A[j+1]):
				A[j],A[j+1]=A[j+1],A[j]

A=[10,9,8,7,6,5,4,3,2,1]

burbuja(A,10)
print(A)