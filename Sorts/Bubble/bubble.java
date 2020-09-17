class Bubble{ 
	void burbuja(int A[],int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(A[j]>A[j+1])
				{
					int temp=A[j];
					A[j]=A[j+1];
					A[j+1]=temp;
				}
			}
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
    	Bubble prueba=new Bubble();
    	int A[]={10,9,8,7,6,5,4,3,2,1};
    	prueba.burbuja(A,10);
    	prueba.mostrar(A,10);
        
    }
}