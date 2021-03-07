-- Grunnstrukturen i SQL (dette er rekkefølgen man MÅ FØLGE):   VI FÅR SQL PÅ EKSAMEN!! DETTE ER VIKTIG!
-- SELECT (minimumskrav)
-- FROM (minimumumskrav)
-- WHERE (kobler tabeller eller velge ut poster/rader)
-- GROUP BY (grupper/sorter etter (alt som står i select, skal stå her))
-- HAVING (Antall)
-- ORDER BY
 
-- Men man må ikke alltid ha med alt
-- Har vi n tabeller, må vi ha n-1 koblinger (eks. 3 tabeller = 2 koblinger, 2 tabeller=1 kobling osv.)
-- Ikke tillatt å bruke mengdefunksjoner i WHERE-betingelser! 
-- OBS!!!! ALT VI SELECTERER PÅ ER DET VI GRUPPERER PÅ ! SELECT = GROUP BY!!!
-- NATURAL JOIN brukes IKKE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 

-- Algoritmeforklaringer
	-- Hele klassen puster litt tungt når vi hører Algoritme (men dette skal gå bra, pust med magen...)
USE Hobbyhuset;

-- Første SELECT'n s. 102
-- " Ordre.* "  Betyr at den velger alle felt fra tabellen Ordre
SELECT Ordre.*,Fornavn,Etternavn,Poststed
FROM Ordre, Kunde, Poststed
WHERE Ordre.KNr=Kunde.KNr
	AND Kunde.Postnr=Poststed.Postnr;

-- ^ Her skulle man ha fått 2192 rader, jeg fikk 1000.... Story of my life....
-- Viser seg at jeg har en limit xD Nå har jeg også fått 2192! Livet er herlig

-- Den(PC'en) gjør først FROM-linjen, Så WHERE-linjen og til slutt SELECT-linjen, når den jobber

-- Her bruker den KNr(kundenummer) å sortere den nye tabellen på 
	-- Fordi den har funnet ut at KNr er nøkkel i flere tabeller, eller noe sånt

-- Siste SELECT'n s 103 
-- ALT VI SELECTERER PÅ ER DET VI GRUPPERER PÅ !
SELECT Kunde.KNr,Etternavn,COUNT(*) AS AntallOrdre
FROM Kunde,Ordre
WHERE Kunde.KNr=Ordre.KNr
GROUP BY Kunde.KNr,Etternavn;

-- ^ Her får vi 405 rader: Fordi det er 405 kunder som har lagt inn minst 1 ordre! 
	-- Og dette vet vi fordi vi sjekka det forrige time 
-- Algoritmeforklaringa:
	-- Betyr hva SQL gjør når
		-- Den starter på FROM (Det kartesiske produktet), så tar den WHERE, GROUP BY, SELECT og til slutt COUNT
        -- (Det gikk veldig fort, men mener det var denne rekkefølgen Ståle sa)




-- Utvidet med gruppebetingelse, kun de kundene med 10 ordrer eller flere 
SELECT Kunde.KNr,Etternavn,COUNT(*) AS AntallOrdre
FROM Kunde,Ordre
WHERE Kunde.KNr=Ordre.KNr
GROUP BY Kunde.KNr,Etternavn
HAVING AntallOrdre>=10;

-- ^ Her fikk vi 20. Det er altså 20 kunder som har 10 eller flere ordre! 

-- Han sier hele tiden "kartesisk produkt", dette må jeg lese på hva er, skjønner ikke hva han babler om

-- ALTSÅ: Vi lager spørringen på en måte, SQL utfører spørringen på en annen måte (algoritmeforklaring)


-- Kortnavn/alias
-- Alias her er da: Kunde=K og Ordre=O 
SELECT K.KNr,Etternavn,COUNT(*) AS AntallOrdre
FROM Kunde AS K, Ordre AS O
WHERE K.KNR=O.KNr
GROUP BY K.KNr,Etternavn
HAVING AntallOrdre>=10;




-- Egenkobling (vi skal lage en egen database som heter egenkobling hjemme, på bakrgunn av "Hobbyhuset")

	-- Fremmednøkkel i egen tabell, altså en FK i tabellen som peker på PK i samme tabellen (tror jeg)
	-- Her blir det en "leder" som er FK og den peker mot "ansattnr" PK i samme tabellen
	-- Derfor må alltid leder legges inn før ansatt
USE Egenkobling;

SELECT *
FROM Ansatt;

-- For å finne navnet på lederen til alle ansatte, kan vi koble tabellen ansatt med seg selv:
	-- Da MÅ vi bruke kortnavn på tabellene! 
	-- Alle ansatte med navn på leder
    -- Ansatte = alias (tabellen heter ansatt, ikke ansatte... aldri flertallsnavn på tabeller)
		-- Annsatte er derfor et alias. Ansatt og Ansatte er ikke det samme her! 
    -- Her gjelder det å holde tunga rett i munn!
SELECT Ansatt.AnsNr, Ansatte.Fornavn,Ansatte.Etternavn,Lederen.Etternavn AS TheBoss
FROM Ansatt AS Ansatte, Ansatt AS Lederen 
WHERE Ansatt.Leder=Lederen.AnsNr
ORDER BY TheBoss,Ansatte.Etternavn,Ansatte.Fornavn;

-- På linje 93 (WHERE) Har vi en likekobling
	-- Den gjør at de ansatte som ikke har en leder, ikke kommer med i denne tabellen
		-- I dette tilfellet er det EN ansatt som ikke kommer med (Gunnlaug), fordi hun er øverste leder 
    

-- Nå skal du prøve selv:
	-- Hva med de ansatte som ikke har en leder? Hvordan skal vi få med de? 
	-- Her kunne vi da visstnok ha brukt en OUTER JOIN (han viste oss aldri det, skal finne det ut selv)





-- Til egenarbeid
	-- Skal lage et view, som skal gjøre det lettere å gjøre egenarbeidet etterpå
    -- View til produksjon av salgsrapporter
    -- HUSK: VIEW Kan bare kjøres EN gang! 
USE Hobbyhuset;
    
-- Denne står også i boka på en eller annen side:
CREATE VIEW Salg AS 
(
-- O=Ordre, OL = Ordrelinje, V=Vare, K=Kategori (Alias)
SELECT OL.*,V.Betegnelse,K.Navn AS Kategori,O.OrdreDato,O.KNr
FROM Ordre AS O,Ordrelinje AS OL,Vare AS V,Kategori AS K
-- Vi har 4 tabeller, derfor må vi ha 3 koblinger på WHERE):
WHERE OL.OrdreNr=O.OrdreNr
	AND OL.VNr=V.VNr
    AND V.KatNr=K.KatNr
    );
-- Det skal komme opp et grønt kryss når vi kjører denne, men ikke noe mer, vi har nå lagd 1 view


SELECT *
FROM Salg;

SELECT *
FROM Ordrelinje;

-- Disse to gir det samme antallet rader. Fordi view'et vi lagde går på antall orderelinjer vi  har. 


-- Egenarbeid:
	-- Lag ulike salgsrapporter
    -- Med utgangpunkt i dataene i salg (View'et vi lagde), kan vi gjør utvalg på dato, kategorier osv. 



-- Utvalg:
	-- Kan enten være som "mengdetilnærming" IN/NOT IN
    -- Eller som "logisk tilnærming" EXISTS/NOT EXISTS 
		-- Om en delspørring har elementer eller ikke
        -- EXISTS  brukes for å sjekke om en delspørring gir et tomt resultat
        -- Er det et svar der eller ikke (dette er visst ikke "NOT NULL eller ikke", men "eksisterer eller ikke") 
	-- disse kan ikke brukes om hverandre. Ikke bruk EXISTS når skal sjekke mengde! 



-- Kunder uten bestillinger ved bruk av NOT EXISTS
SELECT *
FROM Kunde
WHERE NOT EXISTS
	(SELECT KNr FROM Ordre
    WHERE Kunde.KNr=Ordre.KNr);
    
-- Kunder med bestillinger ved bruk av EXISTS 
SELECT *
FROM Kunde
WHERE EXISTS
	(SELECT KNr FROM Ordre
    WHERE Kunde.KNr=Ordre.KNR);




-- Leksa fra forrige forelesning til i dag
	-- SHIT, hadde vi lekser??! xD Hupps....
-- Gullklubben, spørring og senere view for å plukke ut kunder med 10 eller flere bestillinger
-- Gullklubblista, "liste til sjefen" med info om alle kunder i gullklubben
-- med info om alle kunder i gullklubben basert på viewet 
USE Hobbyhuset;

-- Her er det lurt å lage Lista først, så man ser at det går, etterpå lager man VIEW av den lista:

-- Gullklubb og gullklubblista
-- LISTA
SELECT KNr,COUNT(*) AS AntallBestillinger
FROM Ordre
GROUP BY KNr
HAVING AntallBestillinger>=10;

-- VIEW
CREATE VIEW Gullklubben AS 
(SELECT KNr,COUNT(*) AS AntallBestillinger
FROM Ordre
GROUP BY KNr
HAVING AntallBestillinger>=10
);

-- Nå kan vi bruke view'et til å spørre mot 
SELECT *
FROM Gullklubben;
-- Da får jeg ut samme info som jeg fikk fra den store lista vi akkurat lagde.
-- Har på en måte bare lagd denne lista i en virtuell tabell (view) 
	-- som vi nå kan bruke som en hvilken som helst annen tabell

-- MEN sjefen vil ha mer info (kundeinfo)
-- Gullklubblista:
SELECT Gullklubben.KNr,Fornavn,Etternavn,Adresse,Kunde.Postnr,Poststed,AntallBestillinger
FROM Gullklubben,Kunde,Poststed
WHERE Gullklubben.KNr=Kunde.KNr
	AND Kunde.Postnr=Poststed.Postnr;
    

-- Nå lager vi et nytt view, som da blir et view av 2 tabeller og 1 view
	-- Fordi vi her bruker listene kunde og poststed + view'et gullklubben (til å lage et view)
CREATE VIEW Gullklubblista AS
(
SELECT Gullklubben.KNr,Fornavn,Etternavn,Adresse,Kunde.Postnr,Poststed,AntallBestillinger
FROM Gullklubben,Kunde,Poststed
WHERE Gullklubben.KNr=Kunde.KNr
	AND Kunde.Postnr=Poststed.Postnr
);


-- Nå bruker vi dette view'et
SELECT *
FROM Gullklubblista;


-- Oppgave:
	-- Gullklubblista som en spørring uten bruk av noen view!
		-- tips: pass på gruppekriteriet 
	-- Alt skal stå i samme rekkefølge og se likt ut, men ikke bruk view! og kun 1 spørring ! 
    


-- Gjentar: NATURAL JOIN brukes IKKE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
USE ansattpersonal2021;
SELECT *
FROM Ansatt NATURAL JOIN Stillingstype;


SELECT *
FROM Ansatt NATURAL JOIN Stillingstype NATURAL JOIN Avdeling;


-- Litt info på tavla til slutt
-- Hva vi må beherske angående mengder for å kunne lage avanserte spørringer:
	-- komplimentære = enten havner i de i det vi spør om, eller ikke. Enten A eller B
		-- kan ikke havne i begge, må havne i en av de 
	-- A U B = Mengden av de som er med i enten A eller B eller begge (U=Union)
    -- A n B = Mengden som er med i begge (Både A og B) (n=Snitt)
    -- A\B= A minus B (De elementene som er med i A, men ikke i B
    -- B\A = B minus A (De elementene som er med i B, men ikke i A) 
    
    
    
    
    
    
