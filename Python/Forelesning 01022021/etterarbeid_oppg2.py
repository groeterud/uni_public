from typing import TYPE_CHECKING

def tell_rader(filnavn,kolonner):
    fil=open(filnavn,'r')

    antall_linje=sum(1 for line in fil)
    print('Antallet linjer på fila er',antall_linje)
    fil.close()
    rader=antall_linje//kolonner
    return(rader)

def lag_2d_liste(filnavn,kolonner):
    rader=tell_rader(filnavn,kolonner)
    
    ansatte=[['' for c in range(kolonner)] for r in range(rader)]

    fil=open(filnavn,'r',encoding='utf-8')

    for r in range(rader):
        for c in range(kolonner):
            ansatte[r][c]=fil.readline().rstrip('\n')
    fil.close()

    return(ansatte)

def printListe(liste,kolonner):
    for x in range(0,len(liste)):
        for k in range(kolonner):
            print(liste[x][k])
    print()

def printUtvalg(liste,kolonner,rader,utvalg_en,utvalg_to,utvalg_tre,conditional=0):
    print('Her følger print av utvalg informasjon')
    if conditional!=0:
        for r in range(rader):
            for c in range(kolonner):
                if liste[r][c]==conditional:
                    print(liste[r][utvalg_en],liste[r][utvalg_to],liste[r][utvalg_tre])
                    print()
                    
    else:
        if conditional==0:
            for r in range(rader):
                print(liste[r][utvalg_en],liste[r][utvalg_to],liste[r][utvalg_tre])
                print()

                    
    


def main():
    kolonner=7
    studentListe=lag_2d_liste('Studenter.txt',kolonner)
    rader=tell_rader('Studenter.txt',kolonner)
    
    igjen=True

    while igjen:
        print('Velkommen til studentmenyen. Du får nå 5 valg')
        print()
        print('Tast 1 for hele listen over studentopplysninger')
        print('Tast 2 for fornavn, etternavn og fødselsdato for alle studenter')
        print('Tast 3 for fornavn, etternavn og e-post for alle kvinner')
        print('Tast 4 for fornavn, etternavn og kjønn for alle studenter på studiet "Bach IT og IS"')
        print('Tast 0 for å avslutte')
        menyvalg=int(input('Vennligst velg: '))
        if menyvalg==1:
            printListe(studentListe,kolonner)
        else:
            if menyvalg==2:
                #parametere er: listenavn,kolonner,rader,kolonneutvalg#1,kolonneutvalg#2,kolonneutvalg#3,conditional(opt)
                printUtvalg(studentListe,kolonner,rader,1,2,4)
            else:
                if menyvalg==3:
                    #parametere er: listenavn,kolonner,rader,kolonneutvalg#1,kolonneutvalg#2,kolonneutvalg#3,conditional(opt
                    printUtvalg(studentListe,kolonner,rader,1,2,3,'F')
                else: 
                    if menyvalg==4:
                        #parametere er: listenavn,kolonner,rader,kolonneutvalg#1,kolonneutvalg#2,kolonneutvalg#3,conditional(opt
                        printUtvalg(studentListe,kolonner,rader,1,2,5,'Bach IT og IS')
                    else:
                        if menyvalg==0:
                            print('Avsluttet')
                            igjen=False
                        else:
                            print('Ugyldig input, prøv igjen.')

main()

