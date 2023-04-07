def gcd(a,b):
    r = 0
    while b > 0:
        r = a % b
        a = b
        b = r
    print(a)
gcd(35,15)
