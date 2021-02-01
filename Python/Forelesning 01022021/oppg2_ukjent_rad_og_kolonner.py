import io


def les_2d_list_fra_fil(filnavn):
    try:
        fil=open(filnavn,'r',encoding='utf-8')

        linje=fil.readline()

        laerer_liste=[]
        
        poster=0

        while linje!='':
            fornavn=linje.rstrip('\n')
            etternavn=fil.readline().rstrip('\n')
            epost=fil.readline().rstrip('\n')
        
            laerer_liste+=[[fornavn,etternavn,epost]]
            poster+=1
            linje=fil.readline()
        

        fil.close()
        print('Antall poster:',poster)
        return(laerer_liste)
        
    
    except IOError:
        return('verifiser filnavn')


laerer_liste=les_2d_list_fra_fil('laerer.txt')



print(laerer_liste)


