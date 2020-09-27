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



void merge(int* arr, int l, int m, int r){
    int n1 = m - l + 1;
    int n2 = r - m;
    int* L = new int[n1];
    int* R = new int[n2];
    int i, j, k;

    for (i=0; i<n1; i++){
        *(L+i) = *(arr+l+i);
    }
    for (j=0; j<n2; j++){
        *(R+j) = *(arr+m+j+1);
    }

    i = 0; j = 0; k = l;
    while (i<n1 && j<n2){
        if (*(L+i) <= *(R+j)){
            *(arr+k) = *(L+i);
            i++;
        } else {
            *(arr+k) = *(R+j);
            j++;
        }
        k++;
    }
    while (i < n1){
        *(arr+k) = *(L+i);
        i++; k++;
    }
    while (j < n2){
        *(arr+k) = *(R+j);
        j++; k++;
    }
}
void mergesort(int* arr, int l, int r){
    if (r > l){
        int m = (l+r)/2;
        mergesort(arr, l, m);
        mergesort(arr, m+1, r);
        merge(arr, l, m, r);
    }
}

int main()
{
	std::ofstream salida("mergecppM.txt");
    //100000,200000,500000,700000,800000,1000000
	int pruebas[]={100000,200000,500000,700000,800000,1000000};//colocar aqui los tamaños
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
			mergesort(a,0,x-1);
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







