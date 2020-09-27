#include <iostream>
#include <fstream>
#include <time.h>


bool verificar(int *A,int n)
{
	for(int i=1;i<n;++i)
	{
		if(A[i-1]>A[i])
		{
			return 0;
		}
		
	}
	return 1;
}

double promedio(double *b,int n)
{
	double prom=b[0];
	for(int i=1;i<n;++i)
	{
		prom=prom+b[i];
	}
	return (prom/n);
}

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
	std::ofstream salida("bubblecpp.txt");
	int pruebas[]={10000, 15000, 20000, 25000, 30000,35000};//colocar aqui los tamaños
	double t0,t1,time;
	int veces=5;
	double *b=new double[veces];
	for(auto x:pruebas)
	{
		salida<<x<<" , ";
		int *a=new int[x];
		std::ifstream entrada("../entrada.txt",std::ifstream::in);
		for(int v=0;v<veces;v++)
		{
			
			
			
			for (int i=0;i<x;++i)
			{
				entrada>>a[i];
			}

			t0=clock();//Inicio del cronometro
			burbuja(a,x);
			t1=clock();//FIn de cronometro
			time = (double(t1-t0)/CLOCKS_PER_SEC);
			b[v]=time;
			
		}
		salida <<promedio(b,veces)<< std::endl;

			delete [] a;
			entrada.close();
		
	}
	delete [] b;
	salida.close();
	
	
	return 0;
}