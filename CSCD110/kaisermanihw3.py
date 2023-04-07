# Ian Kaiserman
# Menu Driven Application
# Extra credit at 6th comment section ("primesInRange" function)

# Initiation function; runs the loops to function the program and evaluates menu choice.
def init():
    print("Welcome to Integer Fun!")
    num = intInput()
    choice = 0
    while choice != 5:
        choice = menu()
        if choice == 1:
            num = intInput()
        if choice == 2:
            oddEvenZero(num)
        if choice == 3:
            primesInRange(num)
        if choice == 4:
            sumOfDigits(num)
    print("\nThanks for playing!")

# Asks user for a positive integer, returns for storing
def intInput():
    userNum = int(input("\nPlease enter a non-negative integer --> "))
    while userNum < 0:
        print("\nSorry, that is not a non-negative integer.")
        userNum = int(input("\nPlease enter a non-negative integer --> "))
    return userNum

# Prints the menu, asks user for a choice, returns for storing
def menu():
    print("""

    Please select from the following menu choices:

    1. Enter a new number
    2. Print the number of odd, even and zero digits in the integer
    3. Print the prime numbers between 2 and the integer
        *NOTE: Numbers longer than 4 digits may take a while*
    4. Print the sum of the digits of the integer
    5. Quit the program

    """)
    menuChoice = int(input("Choice --> "))
    return menuChoice

# Function to determine the odd, even, and zero digits in the given number
def oddEvenZero(num):
    oddDigits = 0
    evenDigits = 0
    zeroDigits = 0
    while num > 0:
        digit = num % 10
        if digit == 0:
            zeroDigits = zeroDigits + 1
        elif digit % 2 == 1:
            oddDigits = oddDigits + 1
        elif digit % 2 == 0:
            evenDigits = evenDigits + 1
        num = num // 10
    print("\nodd -", oddDigits)
    print("even -", evenDigits)
    print("zero(s) -", zeroDigits)

# Function to determine the sum of all the digits in the given number
def sumOfDigits(num):
    intSum = 0
    while num > 0:
        digit = num % 10
        intSum = intSum + digit
        num = num // 10
    print("\nThe sum of the digits is", intSum)

# Function to determine all primes between 2 and the given number
def primesInRange(num):
    primes = []
    for i in range(2,num):          # Just one of these loops would only determine if the number itself is prime
        prime = True
        for j in range(2,i):        # Nesting it inside another loop with the same range takes each number between 2 and the given number and determines if it is prime
            if i % j == 0:
                prime = False
        if prime == True:           # This results in a list of prime numbers, rather than just the number itself
            primes.append(i)        # (I researched this term to use instead of looping print, found at https://www.programiz.com/python-programming/methods/list/append)
    print("The prime numbers are", primes)

# Program initiation
init()
