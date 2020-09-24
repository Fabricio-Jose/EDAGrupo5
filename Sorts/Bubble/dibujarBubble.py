import numpy as np

#import cv2
from matplotlib import pyplot as plt

x,y = np.loadtxt('bubblecpp.txt' , delimiter=',' , unpack=True)
x1,y1 = np.loadtxt('bubblepy.txt' , delimiter=',' , unpack=True)
x2,y2 = np.loadtxt('bubblejava.txt' , delimiter=',' , unpack=True)


plt.plot(x,y,color="blue",label="BUbble Sort C++")
plt.plot(x1,y1,color="red",label="BUbble Sort Python")
plt.plot(x2,y2,color="yellow",label="BUbble Sort Java")

plt.legend()
# plt.plot(s,d,color="red")
plt.title('BUbble Sort Algorithm')
plt.xlabel('Data')
plt.ylabel('Seconds')
plt.show()
