#input kundeinfo
try:
    print() 
    #åpne kundefil
    try:
        print()
        #lese kundefil inn i liste
        #se om kunden eksisterer allerede
    except ValueError:
        print('Kundefilen er korrupt, enkelte tall kan være bokstaver eller symboler')
    #lukk kundefil
    try:
        print()
        #åpne kundefil i append
        #skriv hundeinfo
        try:
            print()
            #åpne hundefila
            try:
                print()
                #lese hundefil inn i lista
                #se om hunden allerede eksisterer
            except ValueError:
                print('Hundefilen er korrupt, enkelte tall kan være bokstaver eller symboler')
            #lukk hundefila
            try:
                print()
                #åpne hundefila i append
                #skriv hundeinfo
            except IOError:
                print('Fant ikke hundevila ved skriving, vennligst sjekk filnavnet!')
        except IOError:
            print('Fant ikke hundefila ved innlesning, vennligst sjekk filnavnet!')
    except IOError:
        print('Finner ikke kundefilen ved skriving, vennligst sjekk filnavnet|')
except IOError:
    print('Finner ikke kundefilen ved lesning, vennligst dobbeltsjekk filnavnet')



try:
    #do something
    print()
except IOError:
    print('Fant ikke en av femti forskjellige filer')
except ValueError:
    print('En fil hadde ett datafelt som hadde feil datatype, vet ikke hvilken eller hvor da...')






