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
	int pruebas[]={10000,20000,30000,40000,50000};//colocar aqui los tamaños
	double t0,t1,time;
	for(auto x:pruebas)
	{
		std::cout<<x<<" ";
		int *a=new int[x];
		std::ifstream entrada("entrada.txt",std::ifstream::in);
		for (int i=0;i<x;++i)
		{
			entrada>>a[i];
			//std::cout<<a[i]<<std::endl;
		}

		//auto start = std::chrono::system_clock::now();
 		t0=clock();//Inicio del cronometro
		burbuja(a,x);
        t1=clock();//FIn de cronometro
        time = (double(t1-t0)/CLOCKS_PER_SEC);
        std::cout <<time<< std::endl;



		//auto end = std::chrono::system_clock::now();

		//std::chrono::duration<double> elapsed = end - start;
    	//std::cout << "Elapsed time: " << elapsed.count() << "s";

		
		if(!verificar(a,x))
		{
			std::cout<<"ERROR en el ordenamiento"<<std::endl;
		}
		delete [] a;
		entrada.close();
	}
	
	
	return 0;
}