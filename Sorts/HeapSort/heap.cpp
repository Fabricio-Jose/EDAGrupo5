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



void heapify(int arr[], int n, int i){ 
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
 
    if (l < n && arr[l] > arr[largest]) 
        largest = l; 
 
    if (r < n && arr[r] > arr[largest]) 
        largest = r; 
  
    if (largest != i) { 
        std::swap(arr[i], arr[largest]); 
        heapify(arr, n, largest); 
    } 
} 
  

void heapSort(int arr[], int n){
    for (int i = n / 2 - 1; i >= 0; i--) 
        heapify(arr, n, i); 
  
    for (int i = n - 1; i >= 0; i--) { 
        std::swap(arr[0], arr[i]); 
        heapify(arr, i, 0); 
    } 
} 
int main()
{
	std::ofstream salida("heapcppM.txt");
	int pruebas[]={100000, 300000, 500000, 700000,900000,1000000};//colocar aqui los tamaños
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
			heapSort(a,x);
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


