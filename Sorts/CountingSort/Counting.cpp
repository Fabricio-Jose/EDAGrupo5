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



int getMax(int array[], int size) {
   int max = array[0];
   for(int i = 1; i<=size; i++) {
      if(array[i] > max)
         max = array[i];
   }
   return max; 
}
void countSort(int *array, int size) {
   int output[size+1];
   int max = getMax(array, size);
   int count[max+1]; 
   for(int i = 0; i<=max; i++)
      count[i] = 0;  
    
   for(int i = 0; i <size; i++)
      count[array[i]]++;  
   
   for(int i = 1; i<=max; i++)
      count[i] += count[i-1]; 
   
   for(int i = size-1; i>=1; i--) {
      output[count[array[i]]-1] = array[i];
      count[array[i]] --; 
   }
   for(int i = 0; i<size; i++) {
      array[i] = output[i]; 
   }
}
int main()
{
	std::ofstream salida("countingcppM.txt");
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
			countSort(a,x);
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
