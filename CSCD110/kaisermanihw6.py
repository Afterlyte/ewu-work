# Ian Kaiserman
# Sieve of Eratosthenes
#

def init():
    choice = 0
    while choice != 3:
        choice = menu()
        while choice < 1 or choice > 3:
            print("\nSorry, that is an invalid menu option. Please try again.")
            choice= menu()
        if choice == 1:
            primes = getPrimes()
        if choice == 2:
            listPrimes(primes)
    print("\nThanks for playing!")

def menu():
    print("""

    Please select from the following menu choices:

    1. Find the prime numbers between 2 and the number you enter
    2. Print the prime numbers
    3. Quit

    """)
    choice = int(input("Choice --> "))
    return choice

def getPrimes():
    while True:
        try:
            n = int(input("\nPlease enter a positive integer larger than 2 --> "))
            if n < 3:
                raise ValueError
            break
        except ValueError:
            print("\nSorry, that integer is not larger than 2. Please try again.")
        except:
            print("\nSorry, that is an invalid data type. Please input an integer larger than 2.")
    primes = []
    for x in range(2,n): 
        prime = True
        for y in range(2,x):
            if x % y == 0:
                prime = False
                break
        if prime == True:
            primes.append(x)
    return primes

def listPrimes(primes):
    print("\nThe prime numbers between 2 and your number are {}".format(primes))

init()
