def les_fra_fil_til_liste(filnavn):
    tall_liste=[]

    try:
        tall_fil=open(filnavn)

        tall=tall_fil.readline()

        while tall!='':
            tall=int(tall)
            tall_liste+=[tall]
            tall=tall_fil.readline()
        
        tall_fil.close()
        
    except IOError:
        return('Vi fant ikke fila')
    
    except ValueError:
        return('Feil format i fila')
    
    else:
        return(tall_liste)


def sorter_liste(liste_input):
    print('doing the thing')


tall_liste=les_fra_fil_til_liste('Tallintrokap7.txt')
print(tall_liste)