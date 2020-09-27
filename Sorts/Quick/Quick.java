import java.util.Scanner;
import java.io.*;


public class Quick
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

				quickk(A,0, n-1); 

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
            FileWriter escritura=new FileWriter("quickjavaM.txt",true);
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


