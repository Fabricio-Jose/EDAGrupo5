import java.util.Scanner;
class Quick{ 
	int particion(int A[], int p, int r){ 
		int x = A[r]; 
		int i = (p-1); 
		for (int j=p; j<r; j++){ 
			if (A[j] < x){ 
				i++; 
				int temp = A[i]; 
				A[i] = A[j]; 
				A[j] = temp; 
			} 
		}
		int temp = A[i+1]; 
		A[i+1] = A[r]; 
		A[r] = temp; 
		return i+1; 
	} 

	void quickk(int A[], int p, int r){ 
		if (p < r)	{ 
			int q = particion(A, p, r);
			quickk(A, p, q-1); 
			quickk(A, q+1, r); 
		} 
	} 
	static void printArray(int A[]){ 
		int n = A.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(A[i]+" "); 
		System.out.println(); 
	} 
	public static void main(String args[]){ 
        Scanner obj = new Scanner(System.in);
		int n = 6; /*TAMAÑO DE ARRAY*/
		int A[];
		A=new int[n];
		for (int i=0; i<n; ++i) 
            A[i]=obj.nextInt();
		Quick ob = new Quick(); 
		ob.quickk(A, 0, n-1); 

		printArray(A); 
	} 
} 
