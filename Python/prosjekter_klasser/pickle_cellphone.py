from os import pathsep
import pickle
import cellphone

#constant for filename
FILENAME = 'cellphones.dat'

def main():
    again='y'

    output_file=open(FILENAME,'wb')

    while again.lower()=='y':
        man=input('Enter Manufacturer: ')
        mod=input('Enter Model: ')
        ret=float(input('Enter Retail Price: '))

        phone=cellphone.Cellphone(man,mod,ret)
        pickle.dump(phone,output_file)

        again=input('Enter more phone data? (y/n): ')
    
    output_file.close()
    print('The data was written to',FILENAME)

main()