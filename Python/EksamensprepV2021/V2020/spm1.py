from BilDeling import Kunde

FILNAVN='Kunde.txt'

kundeliste=[]
kundeliste_2d=[]
f=open(FILNAVN,'r')

mobilnr=f.readline()

while mobilnr!='':
    mobilnr=mobilnr.rstrip('\n')
    fornavn=f.readline().rstrip('\n')
    etternavn=f.readline().rstrip('\n')
    betalingskortnr=f.readline().rstrip('\n')

    kunde=Kunde(mobilnr,fornavn,etternavn,betalingskortnr)
    kundeliste+=[kunde]

    kundeliste_2d+=[[mobilnr,fornavn,etternavn,betalingskortnr]]

    mobilnr=f.readline()

f.close()

for kunde in kundeliste:
    print()
    print(kunde.get_mobilnr())  
    print(kunde.get_fornavn())
    print(kunde.get_etternavn())


for x in range(len(kundeliste_2d)):
    print()
    print(kundeliste_2d[x][0])
    print(kundeliste_2d[x][1])
    print(kundeliste_2d[x][2])