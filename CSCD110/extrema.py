high = -999999
low = 999999
x = -1
while x <= 3:
    y = 2*x**3 - 8*x**2 + x + 16
    if y > high:
        high = y
        highX = x
        highY = y
    if y < low:
        low = y
        lowX = x
        lowY = y
    x += 0.001
print("The local maximum of y is {:.3f} located at ({:.3f}, {:.3f}).".format(high,highX,highY))
print("The local minimum of y is {:.3f} located at ({:.3f}, {:.3f}).".format(low,lowX,lowY))
