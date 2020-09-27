import numpy as np

#import cv2
from matplotlib import pyplot as plt

x,y = np.loadtxt('selectioncpp.txt' , delimiter=',' , unpack=True)
x1,y1 = np.loadtxt('selectionpy.txt' , delimiter=',' , unpack=True)
x2,y2 = np.loadtxt('selectionjava.txt' , delimiter=',' , unpack=True)


plt.plot(x,y,color="blue",label="Selection Sort C++")
plt.plot(x1,y1,color="red",label="Selection Sort Python")
plt.plot(x2,y2,color="yellow",label="Selection Sort Java")

plt.legend()
# plt.plot(s,d,color="red")
plt.title('Algoritmos Selection')
plt.xlabel('Datos')
plt.ylabel('Segundos')
plt.show()
