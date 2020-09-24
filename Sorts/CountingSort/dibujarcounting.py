import numpy as np

#import cv2
from matplotlib import pyplot as plt

x,y = np.loadtxt('countingCpp.txt' , delimiter=',' , unpack=True)
x1,y1 = np.loadtxt('CountinPy.txt' , delimiter=',' , unpack=True)
x2,y2 = np.loadtxt('countjava.txt' , delimiter=',' , unpack=True)


plt.plot(x,y,color="blue",label="Counting Sort C++")
plt.plot(x1,y1,color="red",label="Counting Sort Python")
plt.plot(x2,y2,color="yellow",label="Counting Sort Java")

plt.legend()
# plt.plot(s,d,color="red")
plt.title('Counting Sort Algorithm')
plt.xlabel('Dates')
plt.ylabel('Seconds')
plt.show()
