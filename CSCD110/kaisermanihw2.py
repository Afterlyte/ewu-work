# Ian Kaiserman
# Grace Hopper's Museum
# No extra credit attempted

# Welcome statement
print("Hello, welcome to Hopper's Computer Museum!\nTo determine your entrance fee, please enter the following:\n")

# Asks for single-line input for DOB and current date and formats into individual variables
# Also asks for a coupon
bMonth, bDay, bYear = input("Your Date of Birth (mm dd yyyy)-->").split()
bMonth, bDay, bYear = [int(bMonth), int(bDay), int(bYear)]
cMonth, cDay, cYear = input("Today's date (mm dd yyyy)-->").split()
cMonth, cDay, cYear = [int(cMonth), int(cDay), int(cYear)]
coupon = input("Do you have a coupon(y/n)?-->")

# Calculates current age, taking unfinished months into account
age = cYear - bYear

if bMonth > cMonth:
    age = age - 1
elif bMonth == cMonth and bDay > cDay:
    age = age - 1

# Calculates fee according to age guidelines and coupon
if age < 15:
    price = 5.00
elif age >= 65:
    price = 7.50
else:
    price = 9.00
if coupon == "y" or coupon == "Y":
    price = price - 1.00

print("\nYour admission fee is ${:.2f}, enjoy your visit!".format(price))
