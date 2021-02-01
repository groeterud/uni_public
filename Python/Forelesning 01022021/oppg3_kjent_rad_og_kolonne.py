def lag_2d_liste(filnavn,kolonner):

    ansattfil=open(filnavn,'r')

    antall_linje=sum(1 for line in ansattfil)
    print('Antallet linjer på fila er',antall_linje)
    ansattfil.close()
    rader=antall_linje//kolonner
    
    ansatte=[['' for c in range(kolonner)] for r in range(rader)]

    ansattfil=open('laerer.txt','r',encoding='utf-8')

    for r in range(rader):
        for c in range(kolonner):
            ansatte[r][c]=ansattfil.readline().rstrip('\n')
    ansattfil.close()

    #skriv ut etternavn
    print('Etternavn:')
    for r in range(rader):
        print(ansatte[r][1],ansatte[r][2])


    return(ansatte)

ansattListe=lag_2d_liste('laerer.txt',3)

print(ansattListe)

