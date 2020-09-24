#include<iostream>
#include<algorithm>
#include <ctime>
#include <fstream>
#include <vector>

using namespace std;

void countingSort(vector<int>& arr) 
{ 
    cout<<"entrando "<<endl;
    int max = *max_element(arr.begin(), arr.end()); 
    int min = *min_element(arr.begin(), arr.end()); 
    int range = max - min + 1; 
  
    vector<int> count(range), output(arr.size()); 
    for (int i = 0; i < arr.size(); i++) 
        count[arr[i] - min]++; 
  
    for (int i = 1; i < count.size(); i++) 
        count[i] += count[i - 1]; 
  
    for (int i = arr.size() - 1; i >= 0; i--) { 
        output[count[arr[i] - min] - 1] = arr[i]; 
        count[arr[i] - min]--; 
    } 
  
    for (int i = 0; i < arr.size(); i++) 
        arr[i] = output[i]; 
} 
  
void printArray(vector<int>& arr) 
{ 
    for (int i = 0; i < arr.size(); i++) 
        cout << arr[i] << " "; 
    cout << "\n"; 
} 
int main() {
    
    int n;
    unsigned t0, t1;
 
    int cadena;
    ifstream file("entrada.txt");
    ofstream salida("countingSortCpp.txt");
    vector <int> arreglo;
    for (int i=50000;i<300001;i+=50000){
        //int arreglo[i] = {0}; 
        for (int j=0;j<i;j++){
            file>>cadena;
            cadena=cadena / 10000 ;
            arreglo.push_back(cadena);
            //printArray(arreglo);
                   
        }
        t0=clock();
        //printArray(arreglo);
        countingSort(arreglo);
        t1 = clock();

        double time = (double(t1-t0)/CLOCKS_PER_SEC);
        salida<<i<<"\t"<<time<<"\n";
        cout << "Execution Time: " << time << endl;
        arreglo.clear();      
    }
    file.close();
    salida.close();

    cout << "Sorted array is \n";cin>>n;
   
}