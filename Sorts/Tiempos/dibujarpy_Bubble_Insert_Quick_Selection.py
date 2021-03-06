
import numpy as np

#import cv2
from matplotlib import pyplot as plt


# x,y ,s,d = np.loadtxt('entrada.csv' , delimiter=',' , unpack=True)
x,y = np.loadtxt('bubblepy.txt' , delimiter=',' , unpack=True)
x1,y1 = np.loadtxt('countingpy.txt' , delimiter=',' , unpack=True)
x2,y2 = np.loadtxt('heappy.txt' , delimiter=',' , unpack=True)
x3,y3 = np.loadtxt('insertpy.txt' , delimiter=',' , unpack=True)
x4,y4 = np.loadtxt('mergepy.txt' , delimiter=',' , unpack=True)
x5,y5 = np.loadtxt('quickpy.txt' , delimiter=',' , unpack=True)
x6,y6 = np.loadtxt('selectionpy.txt' , delimiter=',' , unpack=True)



plt.plot(x,y,color="blue",label="Burbble Sort")
plt.plot(x1,y1,color="red",label="Counting Sort")
plt.plot(x2,y2,color="yellow",label="Heap Sort")
plt.plot(x3,y3,color="green",label="Insert Sort")
plt.plot(x4,y4,color="pink",label="Merge Sort")
plt.plot(x5,y5,color="orange",label="Quick Sort")
plt.plot(x6,y6,color="brown",label="Selection Sort")

plt.legend()
# plt.plot(s,d,color="red")
plt.title('Algoritmos Python')
plt.xlabel('Datos')
plt.ylabel('Segundos')
plt.show()
