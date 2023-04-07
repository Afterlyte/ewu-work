# Ian Kaiserman
# Phone book
#

def init():
    fileName = "entries.txt"
    file = open(fileName, "r")
    lName = []
    fName = []
    phone = []
    fillLists(file,lName,fName,phone)
    choice = 0
    while True:
        while True:
            try:
                choice = menu()
                if choice < 1 or choice > 4:
                    raise ValueError
                break
            except ValueError:
                print("\nSorry, that is an invalid menu option. Please try again.")
            except:
                print("\nSorry, that is an invalid menu option. Please try again.")
        if choice == 1 or choice == 2 or choice == 3:
            lookUp(file,lName,fName,phone,choice)
        elif choice == 4:
            file.close()
            print("\nThanks for playing!")
            break

def menu():
    print("""

    Please select from the following menu choices:

    1. Look up contact by last name
    2. Look up contact by first name
    3. Look up contact by phone number
    4. Quit

    """)
    choice = int(input("Choice --> "))
    return choice

def fillLists(file,lName,fName,phone):
    count = 0
    for item in file:
        count += 1
        item = item.strip()
        if count % 3 == 1:
            lName.append(item)
        elif count % 3 == 2:
            fName.append(item)
        else:
            phone.append(item)

def lookUp(file,lName,fName,phone,choice):
    if choice == 1:
        searchType = lName
        search = input("\nEnter contact's last name: ")
    if choice == 2:
        searchType = fName
        search = input("\nEnter contact's first name: ")
    if choice == 3:
        searchType = phone
        search = input("\nEnter contact's phone number\nNOTE: Please use format ###-###-#### : ")
    search = search.strip().lower()
    count = 0
    for num in range(0,len(searchType)):
        itemLower = searchType[num].lower()
        if search == itemLower:
            print()
            print(fName[num],lName[num])
            print(phone[num])
            count += 1
    if count == 0:
        print("\nThere are no results for '{}'".format(search))

init()
