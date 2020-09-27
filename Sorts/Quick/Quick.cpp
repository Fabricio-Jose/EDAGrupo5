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



void swapp(int &a, int &b){
    int temp = a;
    a=b;
    b=temp;
}

int particion(int *A, int p, int r){
    int x=A[r];
    int i=p-1;
    for(int j=p;j<r;j++){
        if (A[j]<=x){
            i=i+1;
            swapp(A[i],A[j]);
        }
    }
    swapp(A[i+1],A[r]);
    return i+1;
}
void quickk(int *A, int p, int r){
    int q;
    if (p<r){
        q=particion(A,p,r);
        quickk(A,p,q-1);
        quickk(A,q+1,r);
    }
}
int main()
{
	std::ofstream salida("quickcppM.txt");
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
			quickk(a,0,x-1);
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


