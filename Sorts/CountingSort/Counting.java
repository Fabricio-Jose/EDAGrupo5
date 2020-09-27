import java.util.Scanner;
import java.io.*;


public class Counting
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
	int getMax(int A[],int n)
	{
		int max=A[0];
		for(int i=1;i<n;i++)
		{
			if(A[i]>max)
			{
				max=A[i];
			}
		}
		return max;
	}


	void count(int A[],int n)
	{
		int ouput[];
		ouput=new int[n];
		int max=getMax(A,n);
		
		int nuevoN=max+1;
		int count[];
		count=new int[nuevoN];
		for(int i=0;i<nuevoN;i++)
		{
			count[i]=0;
		}

		for(int i=0;i<n;i++)
		{
			count[A[i]]++;
		}
		for(int i=1;i<nuevoN;i++)
		{
			count[i]+=count[i-1];
		}
		for(int i=n-1;i>-1;i--)
		{
			ouput[count[A[i]]-1]=A[i];
			count[A[i]]--;
		}
		for(int i=0;i<n;i++)
		{
			A[i]=ouput[i];
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

				count(A, n); 

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
            FileWriter escritura=new FileWriter("countingjavaM.txt",true);
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



	