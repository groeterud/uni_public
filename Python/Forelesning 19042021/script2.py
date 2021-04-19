import pickle
class Laerer:
    def __init__(self,fornavn,etternavn,epost):
        self.__fornavn=fornavn
        self.__etternavn=etternavn
        self.__epost=epost
    def get_fornavn(self):
        return self.__fornavn
    def get_etternavn(self):
        return self.__etternavn
    def get_epost(self):
        return self.__epost

    def __str__(self):
        return "\nNavn: "+self.__fornavn+' '+self.__etternavn+'\nepost: '+self.__epost
def main():
    laerer_dct={}
    ansattfil=open('laerer.txt','r',encoding='utf-8')
    fornavn=ansattfil.readline()
    while fornavn!='':
        fornavn=fornavn.rstrip('\n')
        etternavn=ansattfil.readline().strip('\n')
        epost=ansattfil.readline().strip('\n')
        
        ansatt=Laerer(fornavn,etternavn,epost)
        laerer_dct[fornavn]=ansatt
        fornavn=ansattfil.readline()

    ansattfil.close()
    output_file = open('Laerer.dat', 'wb')
    pickle.dump(laerer_dct, output_file)
    output_file.close()

    #skriver ut resultatet.
    input_file = open('Laerer.dat', 'rb')
    # Unpickle the dictionary.
    laerer_dct = pickle.load(input_file)
    
    #print loop
    for studentnr in laerer_dct:
        print(laerer_dct.get(studentnr))

main()
