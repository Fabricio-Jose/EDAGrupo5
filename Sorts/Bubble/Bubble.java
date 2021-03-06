import java.util.Scanner;
import java.io.*;


public class Bubble
{ 
	
    public static void main(String args[]) 
    {   
		int pruebas[]={10000, 15000, 20000, 25000, 30000,35000};
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
				
				ento = new FileReader("entrada.txt");
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

				burbuja(A, n); 

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
            FileWriter escritura=new FileWriter("bubblejava.txt",true);
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
