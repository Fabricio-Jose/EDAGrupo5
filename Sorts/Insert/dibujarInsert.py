import numpy as np

#import cv2
from matplotlib import pyplot as plt

x,y = np.loadtxt('insertcpp.txt' , delimiter=',' , unpack=True)
x1,y1 = np.loadtxt('insertpy.txt' , delimiter=',' , unpack=True)
x2,y2 = np.loadtxt('insertjava.txt' , delimiter=',' , unpack=True)


plt.plot(x,y,color="blue",label="Insert Sort C++")
plt.plot(x1,y1,color="red",label="Insert Sort Python")
plt.plot(x2,y2,color="yellow",label="Insert Sort Java")

plt.legend()
# plt.plot(s,d,color="red")
plt.title('Insert Sort Algorithm')
plt.xlabel('Data')
plt.ylabel('Seconds')
plt.show()
