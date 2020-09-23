import java.util.Scanner;
import java.io.*;


class Quick{ 
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
	static void printArray(int A[],int t){ 
	
		int n = t; 
		for (int i=0; i<n; ++i) 
			System.out.print(A[i]+" "); 
		System.out.println(); 
	} 
	public static void main(String args[]){   
        Leer_fichero acc = new Leer_fichero();
        Escribir out= new Escribir();
        double a;
        int tams[];
        tams = new int[6];
        tams[0] =100000;
        tams[1] =200000;
        tams[2] =500000;
        tams[3] =600000;
        tams[4] =700000;
        tams[5] =1000000;

        double times[];
        times = new double[6];
        
        for(int i=0;i<6;i++){
            a=acc.lee(tams[i]);
            times[i]=a;
        }
     
        out.escr(tams,times);
    }
} 

class Leer_fichero{
    public double lee(int n){
        double t_1=1.1;
        try{
            ento = new FileReader("entrada.txt");
            BufferedReader mibuffer = new BufferedReader(ento);
            
            String linea="";
          	double TInicio, TFin;//, t_1;

            int A[];
            A=new int[n];
            
            int entero,i;
            i=0;
            while(linea!=null){
                
                linea=mibuffer.readLine();
                      
                if(linea!=null){
                    linea=linea.substring(0,linea.length()-1);
                    entero = Integer.parseInt(linea);
                    
                    A[i]=entero;
                    i=i+1;
                    if(i==n){
                        Quick ob = new Quick(); 
                        TInicio = System.currentTimeMillis();
                        ob.quickk(A, 0, n-1); 
                        TFin = System.currentTimeMillis();
                        t_1 = (TFin - TInicio)/1000;
                        break;
                    }                
                }
            }           
        }catch (IOException e){
            System.out.println("No hay arch");
        }finally{
            try{
                ento.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    return t_1;
    }    
    FileReader ento;
}

class Escribir{
    public void escr(int tams [], double times[]){   
        try {
            FileWriter escritura=new FileWriter("QuickJava.txt");
            String tipeo;
            String tam_1;
            for(int i=0;i<6;i++){
                tipeo=times[i]+"";
                tam_1=tams[i]+"";
                
                escritura.write(tams[i]+" , "+tipeo+"\n");
            }
            escritura.close(); 
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
