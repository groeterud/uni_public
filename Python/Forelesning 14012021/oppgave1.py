def les_hele_sum():
    summen=0

    try:
        tall_fil=open('tullballiversen.txt','r')

        tall=tall_fil.readline()
        try:
            while tall!='':
                tall=tall.rstrip('\n')
                tall=int(tall)

                summen+=tall

                tall=tall_fil.readline()
            
        except ValueError:
            print('Er du sikker på at det bare er tall der?? ')
            print('Jaja... Summen så langt er iaff',summen)
        
        else:
            print('Summen av tallene er:',summen) 

        finally:
            tall_fil.close()

    except IOError:
        print('Fant ikke fila')
         
les_hele_sum()
