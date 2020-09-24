# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import numpy as np
import time

def countingSort(Array):
    n = max(Array)
    sizeArray = len(Array)
    #contadorArray = np.zeros(n+1)
    """ cambio
    """
    contadorArray = np.arange(n+1)
    for i in range(0,len(contadorArray)):
        contadorArray[i] = 0
    #print (contadorArray)
    """ hasta aca el cambio
    """
    for i in range (0,sizeArray):
        contadorArray[Array[i]]+=1
    #print(contadorArray)
    
    for i in range (1,len(contadorArray)):
        contadorArray[i]+=contadorArray[i-1]
    ordenadoArray =np.arange(sizeArray+1) #np.zeros(sizeArray+1)
    #print(contadorArray)
    #print(ordenadoArray)
    
    for i in range(0,len(contadorArray)):
        temp = int(contadorArray[i])
        #print(temp)
        while(temp!=0 and temp!=int(contadorArray[i-1])):
            ordenadoArray[temp] = i
            temp-=1
    return ordenadoArray[1:len(ordenadoArray)]

                       
File = open("countingSortPython.txt","w")
entrada = open("entrada.txt",'r')
lineas = entrada.readlines()
x = [0]
for i in range(50000,300001,40000):
    print(i)
    for j in range(0,i):
        x.append(int(lineas[j]))
        
 
    # print ("array sin ordenar",x)
    time0=time.time()
    countingSort(x)
    timeF=time.time()
    tiempo=timeF-time0 
     #print ("array ordenado ",x)
     #print("tiempo de ordenacion =",tiempo)
    File.write(str(i)+"\t" + str(tiempo)+"\n")     
    x= [0]
File.close()
entrada.close()