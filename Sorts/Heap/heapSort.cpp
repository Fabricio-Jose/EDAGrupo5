#include <iostream> 
#include <ctime>
#include <fstream>
const int MAXIMO = 10000;
using namespace std; 
  

void heapify(int arr[], int n, int i) 
{ 
    int largest = i; // Initialize largest as root 
    int l = 2 * i + 1; // left = 2*i + 1 
    int r = 2 * i + 2; // right = 2*i + 2 
  
 
    if (l < n && arr[l] > arr[largest]) 
        largest = l; 
 
    if (r < n && arr[r] > arr[largest]) 
        largest = r; 
  
    
    if (largest != i) { 
        swap(arr[i], arr[largest]); 
  
        
        heapify(arr, n, largest); 
    } 
} 
  

void heapSort(int arr[], int n) 
{ 
  
    for (int i = n / 2 - 1; i >= 0; i--) 
        heapify(arr, n, i); 
  
    
    for (int i = n - 1; i >= 0; i--) { 
        // Move current root to end 
        swap(arr[0], arr[i]); 
  
        heapify(arr, i, 0); 
    } 
} 

  
// Driver program 
int main() 
{ 
    int n;
    unsigned t0, t1;
 
    int cadena;
    ifstream file("entrada.txt");
    ofstream salida("heapSortCpp.txt");
    for (int i=50000;i<300001;i+=50000){
        int arreglo[ i ] = { 0 };
        for (int j=0;j<i;j++){
            file>>cadena;
            arreglo[j]=cadena;
                   
        }
        t0=clock();
        heapSort(arreglo,i);
        t1 = clock();

        double time = (double(t1-t0)/CLOCKS_PER_SEC);
        salida<<i<<"\t"<<time<<"\n";
        cout << "Execution Time: " << time << endl;
        
    }
    file.close();
    salida.close();

    cout << "Sorted array is \n";cin>>n; 
   
}