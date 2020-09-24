import java.util.Scanner;
import java.io.*;


public class Insert
{ 
	
    public static void main(String args[]) 
    {   
    	int pruebas[]={10000, 15000, 20000, 25000, 30000,35000};
    	for (int i = 0; i < pruebas.length; i++)
    	{

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
			System.out.print(A[i]+" , ");
		}
		System.out.println();
	}

	public double ejecutar(int n)
	{
		double tiempo;
		double inicio;
		double fin;
		inicio = System.currentTimeMillis();

		insercion(A, n); 

        fin = System.currentTimeMillis();
        tiempo = (fin - inicio)/1000;
        escribir(String.valueOf(n)+" , "+String.valueOf(tiempo));
        return tiempo;

	}
	public void escribir(String frase)
    {
        //frase="algo";
        try 
        {
            FileWriter escritura=new FileWriter("insertjava.txt",true);
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




