import java.util.Scanner;
class Selection{
	void Sele(int A[]){ 
		int n = A.length; 
		for (int i=0;i<n-1;i++){ 
			int menor = i; 
			for (int j=i+1;j<n;j++) 
				if (A[j] < A[menor]) 
					menor = j; 
			int temp = A[menor]; 
			A[menor] = A[i]; 
			A[i] = temp; 
		} 
	} 
	void printArray(int A[]){ 
		int n = A.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(A[i]+" "); 
		System.out.println(); 
	} 

	public static void main(String args[]){ 
        java.util.Scanner obj = new java.util.Scanner(System.in);
		int n = 100000; /*TAMAÑO DE ARRAY*/
		int A[];
		A=new int[n];
		for (int i=0; i<n; ++i) 
            A[i]=obj.nextInt();
            
        Selection ob = new Selection(); 
        ob.Sele(A); 
		 
		ob.printArray(A); 
	} 
}
