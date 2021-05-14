from spm7 import Hund
import pickle

FILENAME_PICK='hunder.dat'

def main():

    end_of_file = False
    alle_hunder=[]
    # Open the file.
    input_file = open(FILENAME_PICK, 'rb')
    # Read to the end of the file.
    while not end_of_file:
        try:
            # Unpickle the next object.
            hund = pickle.load(input_file)
            #legg til i liste
            alle_hunder+=[hund]
        except EOFError:
            # Set the flag to indicate the end
            # of the file has been reached.
            end_of_file = True
    # Close the file.
    input_file.close()

    for hund in alle_hunder:
        print(hund.get_hundenavn())
main()