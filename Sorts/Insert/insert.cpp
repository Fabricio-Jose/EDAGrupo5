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
    int pruebas[]={10000, 15000, 20000, 25000, 30000,35000};//colocar aqui los tamaños
    double t0,t1,time;
    for(auto x:pruebas)
    {
        std::cout<<x<<" , ";
        int *a=new int[x];
        std::ifstream entrada("entrada.txt",std::ifstream::in);
        for (int i=0;i<x;++i)
        {
            entrada>>a[i];
            //std::cout<<a[i]<<std::endl;
        }

        //auto start = std::chrono::system_clock::now();
        t0=clock();//Inicio del cronometro
        insercion(a,x);
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