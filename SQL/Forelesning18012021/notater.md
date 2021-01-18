
Formale krav til tabeller
https://en.wikipedia.org/wiki/Boyce%E2%80%93Codd_normal_form

alle tabeller skal ha navn. 
tabellnavnet oppgis (vanligvis) i entallsform. 

Hver tabell har flere kolonner med attributter
Hver rad har en post / tuppel          tuppel = liste hvor du IKKE kan endre innholdet. 

                    Eksempel tabell: STUDENT
        studentnr   fornavn etternavn   fødselsdato kjønn   studium
        {20214,ola,normann,010661,m,økad}


                    utvalg av data

    vertikalt utvalg / utvalg av kolonne / felt
    - plukke ut bestemte kolonner fra tabellen.
    - f.eks plukke ut alle fornavn, etternavn og studium 

    horisontale utvalg
    utvalg av poster / rader 
    - f.eks; gi meg alle studenter som går studiet økad.

    kombinasjon av felt- og postutvalg 
    - f.eks: lag en ny tabell med alle studentene som går økad, men bare ta med fornavn, etternavn og studium. 
    ref figur 2.3 s36 i Kristoffersen. 


SELECT 'KOLONNER'       <--MUST

FROM 'TABELL'           <--MUST

WHERE 'BETINGELSE' radutvalg/postutvalg>

ORDE BY 'visningsrekkefølge på data'

