#include <iostream>
#include <stdlib.h>

using namespace std;

void swap(int *xp, int *yp)
{
    if (xp != yp){
        int temp = *xp;
        *xp = *yp;
        *yp = temp;
    }
}

void mergeS(int A[], int l, int m, int r){
    int B[r-l];
    int i, j;
    for (i=l; i<m; i++){
        B[i] = A[i];
    }

    for (j=m; j<r; j++){
        B[r+m-j-1] = A[j];
    }

    i = l; j = r-1;

    for (int k=l; k<r; k++){
        if (B[i] <= B[j]){
            A[k] = B[i];
            i++;
        }
        else {
            A[k] = B[j];
            j--;
        }
    }
}


void mergeSort(int arr[], int l, int r){
    if (l+1 == r){
        if (arr[l] > arr[r])
            swap(&arr[l], &arr[r]);
    }
    else {
        if (l < r){
            int m = (r+l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            mergeS(arr,l,m+1,r+1);
        }
    }
}

int main(){
    
}