from spm7 import Hund
import pickle

FILENAME_PICK='hunder.dat'
FILENAME_TXT='hund.txt'

def main():
    input_file=open(FILENAME_TXT,'r',encoding='utf-8')

    hunder=[]

    hundeID=input_file.readline()

    while hundeID!='':
        hundeID=hundeID.rstrip('\n')
        hundenavn=input_file.readline().rstrip('\n')
        rase=input_file.readline().rstrip('\n')
        eier=input_file.readline().rstrip('\n')
        startdato=input_file.readline().rstrip('\n')

        hund=Hund(hundeID,hundenavn,rase,eier,startdato)
        
        hunder+=[hund]

        hundeID=input_file.readline()
    
    input_file.close()

    output_file=open(FILENAME_PICK,'wb')
    
    for x in range(len(hunder)):
        pickle.dump(hunder[x],output_file)
        print('DUMPED:\t',hunder[x])
    
    output_file.close()
    print('Alle hunder lagret i ',FILENAME_PICK)

main()
