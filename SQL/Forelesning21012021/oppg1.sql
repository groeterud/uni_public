USE hobbyhusetkap2;
SELECT *
FROM Vare;

-- Operatorpresedens, AND/OR mot "og/eller i dagligtale"
-- Varer som koster under 100kr i kategoriene bøker og keramikk, s45
-- Først en forced fail
SELECT *
FROM Vare
WHERE (Pris<100)
	AND (Kategori='Bøker') OR (Kategori='Keramikk');

-- Spørringen tolkes som, operatorpresedens
SELECT * 
FROM Vare
WHERE ((Pris<100) AND (Kategori='Bøker')) 
	OR (Kategori='Keramikk');

-- Den "korrekte" spørringen
SELECT * 
FROM Vare
WHERE (Pris<100)
	AND ((Kategori='Keramikk') OR (Kategori='Bøker'));
    
-- Avledet informasjon, med avrunding til 2 desimaler og eget navn. 
SELECT VNr, Betegnelse, Pris AS Pris_eks_MVA, ROUND(PRIS*1.25,2) AS Pris_ink_MVA
FROM Vare;

-- NB!!! Ikke bruk TRUNCATE, den avkorter bare.
SELECT VNR,Betegnelse,Pris,
	Pris*1.25 AS PrisInklMVA,
    2*ROUND(Pris*1.25,2) AS Dobbel,
	TRUNCATE(Pris*1.25,2) AS PrisInklMvaAvkortet
FROM Vare;


-- Fortolkning
-- bokstaven i hylle viser hylleseksjon, bruker left til å trekke ut et gitt antall tegn fra venstre
-- LEFT(Kategori,Hvor mange tall)
SELECT Vnr, Betegnelse, LEFT(Hylle,1) AS Hylleseksjon
FROM Vare
WHERE Hylle IS NOT NULL
ORDER BY Hylleseksjon;

-- Dette funker ikke.... 
SELECT Vnr, Betegnelse, LEFT(Hylle,1) AS Hylleseksjon
FROM Vare
WHERE Hylleseksjon IS NOT NULL
ORDER BY Hylleseksjon;

-- Vi kan trekke ut for å sortere vekk de som bare starter på B.. Ikke at jeg vet hvorfor man skulle ønske å gjøre det. 
SELECT Vnr, Betegnelse, LEFT(Hylle,1) AS Hylleseksjon
FROM Vare
WHERE Hylle IS NOT NULL 
	AND Hylle LIKE 'B%'
ORDER BY Hylleseksjon;


-- Intervalsøk, flere ulikheter med AND/OR eller bruk av BETWEEN 
SELECT *
FROM Vare
WHERE (Pris>=57) AND (Pris<=75.50);

-- BETWEEN [a,b] (fra og med til og med) 
SELECT * 
FROM Vare
WHERE (Pris BETWEEN 57 AND 75.50);


-- Jokernotasjon / Mønstersammenligning
-- NB!!! må bruke LIKE i stedet for =  ved mønstersammenligning.
-- Varer som begynner på M 
SELECT *
FROM Vare
WHERE UPPER(Betegnelse) LIKE 'M%';

-- Varer som begynner på M 
-- Uten Mønstersammenligning/dvs test på likhet
SELECT * 
FROM Vare 
WHERE UCASE(LEFT(Betegnelse,1))='M';

-- Varer som inneholder Marsipan i navnet
SELECT * 
FROM Vare
WHERE LOWER(Betegnelse) LIKE '%marsipan%';
