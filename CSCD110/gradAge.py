# Ian Kaiserman
# Age at grad
# *Extra Credit at 4th comment

# Welcome message
print("Welcome to the age at grad calculator!")

# Asks user for birth- and graduation-date input
bYear = int(input("Please enter your birth year: "))
bMonth = int(input("Please enter your birth month: "))
bDay = int(input("Please enter your birth day: "))

gYear = int(input("Please enter your grad year: "))
gMonth = int(input("Please enter your grad month: "))
gDay = int(input("Please enter your grad day: "))

# Calculation factors for user's age in years
aYears = gYear - bYear

if bMonth > gMonth:
    aYears = aYears - 1
elif bMonth == gMonth and bDay > gDay:
    aYears = aYears - 1

# Calculation factors for user's extra age in months *EXTRA CREDIT
aMonths = ((gYear - bYear) * 12 + (gMonth - bMonth)) % 12

if bDay > gDay:
    aMonths = aMonths - 1
if aMonths < 0:
    aMonths = 12 + aMonths

# Print message with finished calculations
print("You will be", aYears, "years and", aMonths, "months when you graduate. Congratulations!")
