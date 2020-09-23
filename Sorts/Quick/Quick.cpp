#include <iostream>
#include <sstream> 
#include <fstream>
#include <ctime> 
#include <string> 

using namespace std;

unsigned t0, t1;
ofstream fs("QuickCpp.txt");

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

int main(){
	int tam [6] = {100000, 300000, 500000, 700000,900000,1000000}; // los tamaños que probaremos
    double *b = new double[6]; // 6 pruebas para diferentes tamaños
    for(int j=0;j<6;j++){
        int *a = new int[tam[j]];
        ifstream archivo;
        string num;
        int num_int=0;
        
        archivo.open("entrada.txt",ios::in);
        int i=0;
        while(!archivo.eof() && i<=tam[j]){
            getline(archivo,num);
            stringstream convert(num);
            
            convert>>num_int;
            a[i]=num_int;
            i++;
        }
        archivo.close();
        t0=clock();
        quickk(a,0,tam[j]-1);
        t1 = clock();
        double time = (double(t1-t0)/CLOCKS_PER_SEC);
        //cout << "Execution Time: " << time << endl;
        fs<< tam[j]<< " , " <<time<<endl;
        delete[] a;
    }


	return 0;

} 
