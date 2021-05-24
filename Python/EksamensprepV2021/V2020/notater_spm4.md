# Lag vindu for å registre nytt utleie
    - hvor en velger vil fra en liste over biler som er ledige
      - oppgir mobilnr på kunde som skal leie bilen 

## Sjekk at kunden ikke har noe uavsluttede leieforhold fra før 

Forutsetning: Vi må ha UI til dette 

#1: Hent biler som er ledige
    #1 SQL spørring?
        SELECT *
        FROM Utleie
        WHERE innlevert IS NULL 
    #2 Dytt i liste 
    #3 vis i GUI 
    #4 Knytt gui til #4 når trykkes (listboxselect)
#2: Oppgi mobilnr på kunde
    # sørge for å ha en entry med StringVar()
#3: Sjekk om kunden har utleieforhold
    #1 var mobilnr som .get på StringVar til mobilnr i GUI
    #2 SQL spørring på mobilnr
        SELECT Mobilnr
        FROM Utleie
        WHERE Innlevert IS NULL
    #3 for løkke --> sjekke om row[0]==mobilnr
        
    #4 om det er det, endre en Bool variabel (True/False)  

            duplikat=False
            for row in markor:
                if row[0]==mobilnr:
                    duplikat=True


#4: Endelig registrering (Trigges av lagre-knapp)
    If duplikat==False:           ### OBS OBS !!! 
        regnr=valgt[0]

        #SQL SPørring for KmUt
        SELECT MAX(KmInn)
        FROM Utleie
        WHERE Regnr=%s

            ## Få KMUT 
            #for row in markor:
                kmut=row[0]
            
        #insert SQL spørring
            INSERT INTO Utleie VALUES
            (%s,CURRENT_TIMESTAMP,%s,%s,NULL,NULL,NULL)
            -------------------------------------------------- 
            (Regnr,Utlevert,KmUt,Mobilnr,Innlevert,KmInn,Belop)

            #variabler vi må: Regnr, KmUt, Mobilnr
    else:
        print('DUPLIKAT PÅ DETTE MOBILNUMMER')
