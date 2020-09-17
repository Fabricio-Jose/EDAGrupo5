
public class mergesort {
    static void print_array(int A[], int size){
        for (int i = 0; i < size; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    void mergeS(int A[], int l, int m, int r){
        int B[] = new int[r - l];
        int i, j;

        for (i=l; i<m; ++i){
            B[i] = A[i];
        }
        for (j=m; j<r; ++j){
            B[r+m-j-1] = A[j];
        }

        i = l; j = r-1;

        for (int k=l; k<r; ++k){
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
        if (l < r){
            int m = (r+l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            mergeS(arr,l,m+1,r+1);
        }
    }
    public static void main(String[] args){
        int arr[] = { 12, 9, 3, 5, 6, 7 };

        mergesort test = new mergesort();
        test.mergeSort(arr, 0, arr.length-1);

        print_array(arr, arr.length);
    }
}
