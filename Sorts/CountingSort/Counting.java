import java.util.Scanner;
import java.io.*;


public class Counting{ 
	
    public static void main(String args[]) 
    {   
    	int pruebas[]={100000, 200000, 500000, 600000,800000,1000000};
    	for (int i = 0; i < pruebas.length; i++)
    	{
    		//Leer_fichero entrada=new Leer_fichero();
    		//int A[]=new int[pruebas[i]];
    		Prueba test=new Prueba(pruebas[i]);
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

	public Prueba(int n)
	{
		A=leer(n);
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

	boolean verificar(int A[],int n)
	{
		for(int i=1;i<n;i++)
		{
			if(A[i]<A[i-1])
			{
				return false;
			}
				
		}
		return true;
	}


	void mostrar(int A[],int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}

	public double ejecutar(int n)
	{
		double tiempo;
		double inicio;
		double fin;
		inicio = System.currentTimeMillis();

		count(A, n); 
		if(!verificar(A,n))
		{
			System.out.println("tu codigo no funciona :(  ....atte java");
		}

        fin = System.currentTimeMillis();
        tiempo = (fin - inicio)/1000;
        escribir(String.valueOf(n)+" , "+String.valueOf(tiempo));
        return tiempo;

	}
	public void escribir(String frase){
        //frase="algo";
        try 
        {
            FileWriter escritura=new FileWriter("countjava.txt",true);
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

    public int[] leer(int n)
    {
        try{
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
            return A;
                      
        }catch (IOException e){
            System.out.println("No hay arch");
        }finally{
        
            try{
                ento.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
            return A;

    }
    //return t_1;
    
    


}
