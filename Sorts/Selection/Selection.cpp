#include <iostream>
#include <iostream>
#include <sstream> 
#include <fstream>
#include <ctime> 
#include <string> 

using namespace std;


unsigned t0, t1;
ofstream fs("SelectionCpp.txt");

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

int main(){
	int tam [6] = {20000, 30000, 50000, 70000,80000,100000}; // los tamaños que probaremos
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
    selectionSort(a,tam[j]);
        t1 = clock();
        double time = (double(t1-t0)/CLOCKS_PER_SEC);
        //cout << "Execution Time: " << time << endl;
        fs<< tam[j]<< " , " <<time<<endl;
        delete[] a;
    }

	return 0;

} 
