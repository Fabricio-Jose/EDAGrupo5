import numpy as np
import time 

def heapify(arr, n, i):
      largest = i
      l = 2 * i + 1
      r = 2 * i + 2
  
      if l < n and arr[i] < arr[l]:
          largest = l
  
      if r < n and arr[largest] < arr[r]:
          largest = r
  
      if largest != i:
          arr[i], arr[largest] = arr[largest], arr[i]
          heapify(arr, n, largest)
  
  
def heapSort(arr):
      n = len(arr)
  
      # max heap
      for i in range(n//2, -1, -1):
          heapify(arr, n, i)    
  
      for i in range(n-1, 0, -1):
          # Swap
          arr[i], arr[0] = arr[0], arr[i]
  
          # Heapify 
          heapify(arr, i, 0)
   
File = open("heapSortPython.txt","w")
entrada = open("entrada.txt",'r')
lineas = entrada.readlines()
x = [0]
for i in range(50000,300001,40000):
    print(i)
    for j in range(0,i):
        x.append(int(lineas[j]))
        
 
    # print ("array sin ordenar",x)
    time0=time.time()
    heapSort(x)
    timeF=time.time()
    tiempo=timeF-time0 
     #print ("array ordenado ",x)
     #print("tiempo de ordenacion =",tiempo)
    File.write(str(i)+"\t" + str(tiempo)+"\n")     
    x= [0]
File.close()
entrada.close()
