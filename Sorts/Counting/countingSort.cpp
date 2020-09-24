#include <iostream>
#include <sstream> 
#include <fstream>
#include <ctime> 
#include <string> 
#include<algorithm>
using namespace std;

unsigned t0, t1;
ofstream fs("countingCpp.txt");

int getMax(int array[], int size) {
   int max = array[1];
   for(int i = 2; i<=size; i++) {
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
   for(int i = 1; i <=size; i++)
      count[array[i]]++;  
   for(int i = 1; i<=max; i++)
      count[i] += count[i-1];  
   for(int i = size; i>=1; i--) {
      output[count[array[i]]] = array[i];
      count[array[i]] -= 1; 
   }
   for(int i = 1; i<=size; i++) {
      array[i] = output[i]; 
   }
}
int main() {
	int tam [6] = {100000, 200000, 500000, 600000,700000,1000000}; // los tamaños que probaremos
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
        countSort(a,tam[j]);
        t1 = clock();
        double time = (double(t1-t0)/CLOCKS_PER_SEC);
        //cout << "Execution Time: " << time << endl;
        fs<< tam[j]<< " , " <<time<<endl;
        delete[] a;
    }


	return 0;

} 


