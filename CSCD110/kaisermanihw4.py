# Ian Kaiserman
# Conversions Calculator
# 

# Initiation of program and interprets menu choices
def init():
    print("Welcome to Conversions Calculator")
    choice = 0
    while choice != 6:
        choice = menu()
        if choice == 1:
            feetToMeters()
        if choice == 2:
            metersToFeet()
        if choice == 3:
            fToC()
        if choice == 4:
            cToF()
        if choice == 5:
            displayBackwards()
    print("\nThanks for playing!")

# Displays the menu and asks for a choice input
def menu():
    print("""

    Please select from the following menu choices:

    1. Convert feet to meters
    2. Convert meters to feet
    3. Convert Fahrenheit to Celsius
    4. Convert Celsius to Fahrenheit
    5. Display a phrase or number backwards
    6. Quit
    
    """)
    choice = int(input("Choice --> "))
    # ** int check here
    return choice

# Conversion from feet to meters
def feetToMeters():
    feet = float(input("\nPlease enter number of feet --> "))
    meters = feet * 0.3048
    print() # Spacing line
    print(feet, "feet equals {:.4f} meters.".format(meters))

# Conversion from meters to feet
def metersToFeet():
    meters = float(input("\nPlease enter number of meters --> "))
    feet = meters * 3.28084
    print() # Spacing line
    print(meters, "meters equals {:.4f} feet.".format(feet))

# Conversion from degrees Fahrenheit to degrees Celsius
def fToC():
    degreesF = float(input("\nPlease enter degrees Fahrenheit --> "))
    degreesC = (degreesF - 32) * 5 / 9
    print() # Spacing line
    print(degreesF, "degrees Fahrenheit equals {:.4f} degrees Celsius.".format(degreesC))

# Conversion from degrees Celsius to degrees Fahrenheit
def cToF():
    degreesC = float(input("\nPlease enter degrees Celsius --> "))
    degreesF = (degreesC * 9 / 5) + 32
    print() # Spacing line
    print(degreesC, "degrees Celsius equals {:.4f} degrees Fahrenheit.".format(degreesF))

# Displays characters of input in reverse order
def displayBackwards():
    phrase = str(input("\nEnter a phrase to print backwards --> "))
    print()
    print(phrase[::-1])

# Calls initiation function to start the program
init()
