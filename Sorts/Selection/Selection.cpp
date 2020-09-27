#include <iostream>
#include <fstream>
#include <time.h>


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
  
void selectionSort(int *arr, int n)  
{  
    int i, j, min_idx;  
    for (i = 0; i < n-1; i++){  
        min_idx = i;  
        for (j = i+1; j < n; j++)  
        if (arr[j] < arr[min_idx])  
            min_idx = j;  
  
        swap(&arr[min_idx], &arr[i]);  
    }  
}
int main()
{
	std::ofstream salida("selectioncpp.txt");
	int pruebas[]={10000, 15000, 20000, 25000, 30000,35000};//colocar aqui los tamaños
	double t0,t1,time;
	int veces=5;
	double *b=new double[veces];
	for(auto x:pruebas)
	{
		salida<<x<<" , ";
		int *a=new int[x];
		std::ifstream entrada("../entrada5M.txt",std::ifstream::in);
		for(int v=0;v<veces;v++)
		{
			for (int i=0;i<x;++i)
			{
				entrada>>a[i];
			}

			t0=clock();//Inicio del cronometro
			selectionSort(a,x);
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


  
