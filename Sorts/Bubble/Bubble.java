import java.util.Scanner;
import java.io.*;


public class Bubble
{ 
	
    public static void main(String args[]) 
    {   
    	int pruebas[]={10000,20000};
    	for (int i = 0; i < pruebas.length; i++)
    	{
    		//Leer_fichero entrada=new Leer_fichero();
    		//int A[]=new int[pruebas[i]];

    		Prueba test=new Prueba(pruebas[i]);
    		//contador
    		test.ejecutar(pruebas[i]);
    		System.out.println("continuamoooos");
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

	public double ejecutar(int n)
	{
		double tiempo;
		double inicio;
		double fin;
		inicio = System.currentTimeMillis();

		burbuja(A, n); 

        fin = System.currentTimeMillis();
        tiempo = (fin - inicio)/1000;
        escribir(String.valueOf(n)+" "+String.valueOf(tiempo));
        return tiempo;

	}
	public void escribir(String frase)
    {
        //frase="algo";
        try 
        {
            FileWriter escritura=new FileWriter("salida.txt",true);
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
