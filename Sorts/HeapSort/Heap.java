import java.util.Scanner;
import java.io.*;


public class Heap
{ 
	
    public static void main(String args[]) 
    {   
		int pruebas[]={100000, 300000, 500000, 700000,900000,1000000};
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
	public void hsort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }


	void mostrar(int A[],int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(A[i]+" ");
		}
		System.out.println();
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

				hsort(A); 

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
            FileWriter escritura=new FileWriter("heapjavaM.txt",true);
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

