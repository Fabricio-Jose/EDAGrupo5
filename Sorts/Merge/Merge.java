import java.util.Scanner;
import java.io.*;


public class Merge
{ 
	
    public static void main(String args[]) 
    {   
		int pruebas[]={100000,200000,500000,700000,800000,1000000};
		int veces=5;
    	for (int i = 0; i < pruebas.length; i++)
    	{

    		//Leer_fichero entrada=new Leer_fichero();
    		//int A[]=new int[pruebas[i]];
			
    		Prueba test=new Prueba(pruebas[i],veces);
    		//contador
    		test.ejecutar(pruebas[i]);
    		//contador

    	}

 
        
    }
}

class Prueba
{
	private int A[];
	private FileReader ento;
	int veces;

	public Prueba(int n,int v)
	{
		veces=v;
	}
	public void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[mid + j + 1];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void msort(int arr[], int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            msort(arr, left, mid);
            msort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

	public double promedio(double b[], int n)
	{
		double prom=b[0];
		for(int i=1;i<n;i++)
		{
			prom=prom+b[i];
		}
		return (prom/n);
	}

	public void ejecutar(int n)
	{
		
		try{
			double tiempo;
			double inicio;
			double fin;
			double b[];
			b=new double[veces];
			for(int v=0;v<veces;v++)
			{
				
				ento = new FileReader("../entrada5M.txt");
				BufferedReader mibuffer = new BufferedReader(ento);

				String linea="";
				int entero;

				int A[];
				A=new int[n];
				
				for (int i=0;i<n;i++)
				{
					linea=mibuffer.readLine();
					if(linea!=null)
					{
						linea=linea.substring(0,linea.length()-1);
						entero = Integer.parseInt(linea);
						A[i]=Integer.parseInt(linea);
					}  
				}
				inicio = System.currentTimeMillis();

				msort(A,0, n-1); 

				fin = System.currentTimeMillis();
				tiempo = (fin - inicio)/1000;
				b[v]=tiempo;


			}
			
			
			escribir(String.valueOf(n)+" , "+String.valueOf(promedio(b,veces)));
            
                      
        }catch (IOException e){
            System.out.println("No hay arch");
        }finally{
        
            try{
                ento.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

	}
	public void escribir(String frase)
    {
        //frase="algo";
        try 
        {
            FileWriter escritura=new FileWriter("mergejavaM.txt",true);
            for(int i=0;i<frase.length();i++)
            {
            	escritura.write(frase.charAt(i));
        	}
        	escritura.write("\n");
            escritura.close(); 
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}




    
