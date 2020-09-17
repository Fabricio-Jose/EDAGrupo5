#include <iostream>

void insercion(int* A,int n)
{
	int i, x, j;  
    for (i = 1; i < n; i++) 
    {  
        x = A[i];  
        j = i - 1;  
        while (j >= 0 && A[j] > x) 
        {  
            A[j + 1] = A[j];  
            j = j - 1;  
        }  
        A[j + 1] = x;  
    } 
}
int main()
{
	int tam = 100 ;
	int *a = new int[tam];
	for(int k=0;k<tam;k++) 
	{
        	std::cin>>a[k];            
	} 
	insercion(a, tam );
	for(int i=0;i<tam;i++)
        std::cout<<a[i]<<std::endl;
	delete []a;
	return 0;
}
