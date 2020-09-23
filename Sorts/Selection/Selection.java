import java.util.Scanner;
import java.io.*;

class Selection{
	void Sele(int A[]){ 
		int n = A.length; 
		for (int i=0;i<n-1;i++){ 
			int menor = i; 
			for (int j=i+1;j<n;j++) 
				if (A[j] < A[menor]) 
					menor = j; 
			int temp = A[menor]; 
			A[menor] = A[i]; 
			A[i] = temp; 
		} 
	} 
	void printArray(int A[]){ 
		int n = A.length; 
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
        tams[0] =5000;
        tams[1] =10000;
        tams[2] =20000;
        tams[3] =30000;
        tams[4] =40000;
        tams[5] =50000;

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
                        Selection ob = new Selection(); 
                        TInicio = System.currentTimeMillis();
                        ob.Sele(A); 
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
            FileWriter escritura=new FileWriter("SelectionJava.txt");
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

