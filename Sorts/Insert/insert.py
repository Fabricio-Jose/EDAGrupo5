def insercion(A,n):
	for i in range(1,n):
		x=A[i]
		j=i-1
		while j>=0 and A[j]>x:
			A[j+1]=A[j];
			j=j-1;
		A[j+1]=x

A=[10,9,8,7,6,5,4,3,2,1]

insercion(A,10)
print(A)