#include <iostream>
#include <cstdlib>
#include <cmath>
using namespace std;


int main() {
        int n=5000000;
        for(int i=0; i<n; i++) {
            cout << rand()%50000<< ' ';
            cout<< endl;
        }
        return 0;
}
