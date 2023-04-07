# Ian Kaiserman
# List Traversal & Exception Handling
#

# Initiation function with menu choice interpretation and applicable error checking
def init():
    print("\nWelcome to the array calculator!")
    array = []
    choice = 0
    while choice != 6:
        try:
            choice = menu()
            while choice > 6 or choice < 1:
                print("\nSorry, that is an incorrect menu choice. Please try again.")
                choice = menu()
            if choice == 1:
                addNum(array)
            if choice == 2:
                getMean(array)
            if choice == 3:
                getMedian(array)
            if choice == 4:
                printArray(array)
            if choice == 5:
                printArrayReverse(array)
        except:
            print("\nSorry, that is an incorrect menu choice. Please try again.")
    print("\nThanks for playing!")

# Function that prints the menu and accepts a menu choice from the user, returns it
def menu():
    print("""

    Please select from the following menu choices:

    1. Add a number to the array
    2. Calculate the mean
    3. Calculate the median
    4. Print the array
    5. Print the array in reverse order
    6. Quit

    """)
    choice = int(input("Menu choice --> "))
    return choice

# Function to add a number to the array with applicable error checking
def addNum(tempArray):
# This while loop and run value keeps the check going while preventing init() from running the exception block in case of error
    run = 1
    while run != 0:
        try:
            num = int(input("\nPlease enter a positive integer --> "))
            while num < 0:
                print("\nSorry, that is not a positive integer. Please try again.")
                num = int(input("\nPlease enter a positive ingeger --> "))
            run = 0
        except:
            print("\nSorry, that is not a positive integer. Please try again.")
    tempArray.append(num)
    tempArray.sort() # Sorts array after every number input (mainly for getMedian function)
    print("\nYour array is now {}".format(tempArray))

# Function to calculate the mean of the array
def getMean(tempArray):
    total = 0
    for item in tempArray:
        total += item
    mean = total / len(tempArray)
    print("\nThe mean of the array numbers is {}".format(mean))

# Function to find or calculate the median of the array
def getMedian(tempArray):
    if len(tempArray) % 2 == 0:
        median = ((tempArray[len(tempArray) // 2 - 1] + tempArray[len(tempArray) // 2]) / 2)
    if len(tempArray) % 2 == 1:
        median = (tempArray[len(tempArray) // 2])
    print("\nThe median of the array numbers is {}".format(median))

# Function to print the array as-is
def printArray(tempArray):
    print("The current array is {}".format(tempArray))

# Function to print the array in reverse order (does NOT change array order)

def printArrayReverse(tempArray):
    print("The current array in reverse order is {}".format(tempArray[::-1]))

# Calls initiation function
init()
