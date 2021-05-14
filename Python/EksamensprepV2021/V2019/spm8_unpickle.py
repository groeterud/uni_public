from spm7 import Hund
import pickle

FILENAME_PICK='hunder.dat'

def main():

    end_of_file = False

    # Open the file.
    input_file = open(FILENAME_PICK, 'rb')
    # Read to the end of the file.
    while not end_of_file:
        try:
            # Unpickle the next object.
            hund = pickle.load(input_file)
            #print objektet
            print(hund)
            #objektet 'husker' at det tilhører klassen og trenger ikke instansieres igjen.
            print(hund.get_hundenavn())
        except EOFError:
            # Set the flag to indicate the end
            # of the file has been reached.
            end_of_file = True
    # Close the file.
    input_file.close()

main()