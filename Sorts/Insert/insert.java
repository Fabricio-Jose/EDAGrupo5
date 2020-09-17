class Insert
{
	void insercion(int A[],int n)
	{
		for(int i=1;i<n;i++)
		{
			int x=A[i];
			int j=i-1;
			while(j>=0 && A[j]>x)
			{
				A[j+1]=A[j];
				j=j-1;
			}
			A[j+1]=x;
		}
	}
	void mostrar(int A[],int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.println(A[i]+" ");
		}
		System.out.println();
	}
    public static void main(String args[]) 
    {     
    	Insert prueba=new Insert();
    	int A[]={10,9,8,7,6,5,4,3,2,1};
    	prueba.insercion(A,10);
    	prueba.mostrar(A,10);
        
    }
}