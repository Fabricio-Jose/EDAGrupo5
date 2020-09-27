import numpy as np
from matplotlib import pyplot as plt

x,y = np.loadtxt('quickcppM.txt' , delimiter=',' , unpack=True)
x1,y1 = np.loadtxt('quickpyM.txt' , delimiter=',' , unpack=True)
x2,y2 = np.loadtxt('quickjavaM.txt' , delimiter=',' , unpack=True)


plt.plot(x,y,color="blue",label="Quick Sort C++")
plt.plot(x1,y1,color="red",label="Quick Sort Python")
plt.plot(x2,y2,color="yellow",label="Quick Sort Java")

plt.legend()
plt.title('Quick Sort Algorithm')
plt.xlabel('Data')
plt.ylabel('Seconds')
plt.show()
