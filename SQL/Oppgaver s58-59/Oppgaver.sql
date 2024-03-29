USE oppgave1kap2;
SELECT *
FROM film;
-- a 
-- All informasjon om filmer produsert i 1988
SELECT * 
FROM film
WHERE År=1988;

-- b
-- Tittel på amerikanske filmer produsert på 1980-tallet
SELECT Tittel AS TittelPåAmerikanseFilmer
FROM film
WHERE Land='USA';

-- c
-- Komedier med aldersgrense under 10 år og spilletid under 130 min
SELECT * 
FROM film
WHERE Alder<=10 AND Tid<=130;

-- d
-- Tittel på alle action og western
SELECT Tittel
FROM film
WHERE Sjanger='Western' OR Sjanger='Action';

-- e 
-- Alle produksjonslands, sortert og uten gjentakelser
SELECT DISTINCT Land
FROM film 
ORDER BY Land ASC;

-- JEG HAR GJORT EN ENDRING

-- f 
-- korteste og lengste spilletid innen hver sjanger
SELECT Sjanger, MIN(Tid) AS KORTESTE, MAX(Tid) AS Lengste 
FROM film
GROUP BY Sjanger;

-- g
-- Antall filmer som ikke er til salgs. 
SELECT COUNT(*) AS AntallIkkeTilSalgs 
FROM film
WHERE Pris IS NULL;

-- h 
-- Antall filmer under 100kr
SELECT COUNT(*) AS AntallUnder100kr
FROM film
WHERE Pris<100;

-- i
-- Filmer med tittel som slutter på now
SELECT *
FROM film
WHERE Tittel LIKE '%now';

-- j
-- Gjennomsnittspris for sjangre med flere enn 2 filmer.
SELECT Sjanger, AVG(Pris) AS Gjennomsnittspris
FROM film
GROUP BY Sjanger
HAVING COUNT(*)>1;

-- k
-- Differansen mellom dyreste og billigste film innen hver sjanger. 
SELECT Sjanger, MAX(Pris)-MIN(Pris) AS Differanse
FROM film
WHERE Pris IS NOT NULL
GROUP BY Sjanger
ORDER BY Differanse DESC;

-- l
-- totalt antall filmer og antall filmer til salgs, fordelt på produksjonsland. 
SELECT Land, COUNT(*) AS AntallFilmer, COUNT(Pris) AS TilSalgs
FROM film
GROUP BY Land;

-- m
-- antall år siden utgivelse for filmer eldre enn 60 år. Tips, legg A lister på navn på noen daton for dagens dato 
-- og en funksjon for å trekke ut årstallet fra en dato 
SELECT Tittel, år, (EXTRACT(YEAR FROM CURDATE()) - år) AS AntallÅrSiden
FROM film
WHERE (EXTRACT(YEAR FROM CURDATE()) - år)>=60;



-- Oppg2
-- Hytte(_Nr_, Beskrivelse, AvstandAlpin, AntallSenger, Ukepris, Strøm, Dusj) 

-- a) Nummer og beskrivelse for hytter med 4 senger eller fler, samt ukespris under 4500
SELECT Nr, Beksrivelse
FROM Hytte
WHERE (AntallSenger>=4) 
	AND (Ukepris<4500);

-- b) Hytter med strøm og dusj, sortert med stigende pris.
SELECT *
FROM Hytte
WHERE (Strøm='J' AND Dusj='J')
ORDER BY Ukepris ASC;

-- c) Antall hytter med 2 senger, antall med 3 etc. 
SELECT AntallSenger, COUNT(AntallSenger) AS Kvanta 
FROM Hytte
GROUP BY AntallSenger;

-- d) Gjennomsnittlig ukespris for hytter med 4 senger
SELECT AVG(Ukepris) AS Gjennomsnitt
FROM Hytte
WHERE AntallSenger=4;

-- e) hytter med mindre enn 500m fra alpinbakkene. 
SELECT COUNT(*) AS AntallHytter
FROM HYTTE 
WHERE AvstandAlpin<500;


-- Oppgave 3 
-- prøvde på LIKE '%[0-9]g', men den ville ikke returne så idk... 
SELECT Betegnelse 
FROM hobbyhusetkap2.vare
WHERE (Betegnelse LIKE '%gr') OR
	(Betegnelse LIKE '%g') OR
    (Betegnelse LIKE '%stk');