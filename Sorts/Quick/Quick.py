def particion(A,p,r): 
    i=(p-1) 
    x=A[r]
    for j in range(p,r): 
        if A[j]<x:  
            i=i+1
            A[i],A[j]=A[j],A[i] 
    A[i+1],A[r] = A[r],A[i+1] 
    return (i+1)

def quicksort(A,p,r): 
    if p<r:
        q = particion(A,p,r)
        quicksort(A,p,q-1)
        quicksort(A,q+1,r)

#n=int(input())
n=1000000
A=range(n)
for i in range(n):
    A[i]=int(input())
quicksort(A,0,n-1) 
for i in range(n): 
    print(A[i]), 
