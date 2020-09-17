#include <iostream>


void swap(int *xp, int *yp)  
{  
    int temp = *xp;  
    *xp = *yp;  
    *yp = temp;  
}  


void burbuja(int *A,int n)
{
	int i, j;  
    for (i = 0; i < n-1; i++)      
    	for (j = 0; j < n-i-1; j++)  
        	if (A[j] > A[j+1])  
            	swap(&A[j], &A[j+1]);
}
int main()
{
	int tam = 100 ;
	int *a = new int[tam];
	for(int k=0;k<tam;k++) 
	{
        	std::cin>>a[k];            
	} 
	burbuja(a, tam );
	for(int i=0;i<tam;i++)
        std::cout<<a[i]<<std::endl;
	delete []a;
	return 0;
}
