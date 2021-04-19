import pickle
from student import Student

# Global constants for menu choices
LOOK_UP = 1
ADD = 2
CHANGE = 3
DELETE = 4
QUIT = 5
# Global constant for the filename
FILENAME = 'studenter.dat'

# main function
def main():

    # Load the existing contact dictionary and
    # assign it to studenter.
    studenter = load_studenter()
    # Initialize a variable for the user's choice.
    choice = 0
    # Process menu selections until the user
    # wants to quit the program.
    while choice != QUIT:
        # Get the user's menu choice.
        choice = get_menu_choice()
        # Process the choice.
        if choice == LOOK_UP:
            look_up(studenter)
        elif choice == ADD:
            add(studenter)
        elif choice == CHANGE:
            change(studenter)
        elif choice == DELETE:
            delete(studenter)
    # Save the studenter dictionary to a file.
    save_contacts(studenter)

def load_studenter():
    try:
        # Open the contacts.dat file.
        input_file = open(FILENAME, 'rb')
        # Unpickle the dictionary.
        studenter_dct = pickle.load(input_file)
        # Close the phone_inventory.dat file.
        input_file.close()
    except IOError:
        # Could not open the file, so create
        # an empty dictionary.
        studenter_dct = {}
        # Return the dictionary.
    return studenter_dct

def get_menu_choice():
    print()
    print('Menu')
    print('---------------------------')
    print('1. Vis en student')
    print('2. Legg til ny student')
    print('3. Endre student')
    print('4. Slett student')
    print('5. Avslutt program')
    print()

    # Get the user's choice.
    choice = int(input('Skriv inn valg: '))
    # Validate the choice.
    while choice < LOOK_UP or choice > QUIT:
        choice = int(input('Skriv inn valid valg: '))
    # return the user's choice.
    return choice

# The look_up function looks up an item in the
# specified dictionary.
def look_up(studenter):
    studentnr = input('Skriv inn studentnr: ')
    # Look it up in the dictionary.
    print(studenter.get(studentnr, 'That student is not found.'))

# The add function adds a new entry into the
# specified dictionary.
def add(studenter):

    studentnr = input('Studentnr: ')
    fornavn = input('Fornavn: ')
    etternavn = input('Etternavn: ')
    epost = input('Email: ')
    studium = input('Studium: ')

    entry=Student(studentnr,fornavn,etternavn,epost,studium)
    # If the name does not exist in the dictionary,
    # add it as a key with the entry object as the
    # associated value.
    if studentnr not in studenter:
        studenter[studentnr] = entry
        print('The entry has been added.')
    else:
        print('That studnr already exists.')

# The change function changes an existing
# entry in the specified dictionary.
def change(studenter):
    studentnr = input('Skriv inn studentnr: ')

    if studentnr in studenter: 
        fornavn = input('Skriv inn nytt fornavn: ')
        etternavn =input('Skriv inn nytt etternavn: ')
        epost = input('Skriv inn ny epost: ')
        studium = input('Skriv inn ny studium: ')
        entry=Student(studentnr,fornavn,etternavn,epost,studium)
        # Update the entry.
        studenter[studentnr] = entry
        print('Information updated.')
    else:
        print('That name is not found.')

# The delete function deletes an entry from the
# specified dictionary.
def delete(studenter):
    studentnr = input('Skriv inn studentnr: ')

    if studentnr in studenter:
        del studenter[studentnr]
        print('Entry deleted.')
    else:
        print('That name is not found.')

# The save_contacts funtion pickles the specified
# object and saves it to the contacts file.
def save_contacts(studenter):
    # Open the file for writing.
    output_file = open(FILENAME, 'wb')

    # Pickle the dictionary and save it.
    pickle.dump(studenter, output_file)
    # Close the file.
    output_file.close()

main()