from BilDeling import Bil

FILNAVN='Bil.txt'

bilListe=[]
bil_2d={}
f=open(FILNAVN,'r')

regnr=f.readline()

while regnr!='':
    regnr=regnr.rstrip('\n')
    merke=f.readline().rstrip('\n')
    modell=f.readline().rstrip('\n')
    startdato=f.readline().rstrip('\n')
    posisjon=f.readline().rstrip('\n')

    bil=Bil(regnr,merke,modell,startdato,posisjon)
    bilListe+=[bil]

    bil_2d[regnr]={
        'merke':merke,
        'modell':modell,
        'startdato':startdato,
        'posisjon':posisjon
    }

    regnr=f.readline()

f.close()

again=True

while again:
    sporring=input('Skriv inn regnr: ')

    for bil in bilListe:
        if bil.get_regnr()==sporring:
            print('\nInformasjon for bil med regnr:',sporring)
            print('Merke:\t',bil.get_merke())
            print('Modell:\t',bil.get_modell())
            print('Startdato:\t',bil.get_startdato())
            print()
    
    if sporring in bil_2d:
        print('\nInformasjon for bil med regnr:',sporring)
        print('Merke:\t',bil_2d[sporring]['merke'])
        print('Modell:\t',bil_2d[sporring]['modell'])
        print('Startdato:\t',bil_2d[sporring]['startdato'])
        print()
    
    igjen=input('Søk opp en til bil? (y/n): ')

    if igjen=='n':
        again=False