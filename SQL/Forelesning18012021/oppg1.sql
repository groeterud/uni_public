USE hobbyhusetkap2;

-- Hele tabellen
SELECT *
FROM vare;

-- Hele tabellen sortert på varenr 
SELECT *
FROM vare
ORDER BY Vnr;

-- Hele varesortimentet, ingen identiske rader 
SELECT Vnr, 
       Betegnelse
FROM vare
ORDER BY Vnr;

-- Noen spørringer kan gi like rader  
SELECT Kategori
FROM vare;

-- Fjerne duplikater
SELECT DISTINCT Kategori
FROM vare;

-- plukke ut varer i kategorien fiske  
SELECT *
FROM vare
WHERE Kategori='Fiske';

-- Standarden er case-sensitiv, det er ikke MySQL.
SELECT * 
FROM vare
WHERE Kategori='fiske';

-- Generell løsning
SELECT *
FROM vare
WHERE UPPER(Kategori)='FISKE';

-- Tallutrykk
SELECT * 
FROM vare
WHERE Pris<100;

SELECT * 
FROM vare
WHERE Pris>=100;

-- To betingelser
SELECT * 
FROM vare
WHERE (Pris>=100) AND (Pris<=200);

-- Spørring på NULL
SELECT *
FROM vare
WHERE Hylle IS NULL;

-- Ignorer rader med NULL i følgende kategori:
SELECT * 
FROM vare
WHERE Hylle IS NOT NULL;

SELECT LEFT(Hylle,1) AS Seksjon, Kategori, COUNT(*) AS Antall
FROM Vare
WHERE Hylle IS NOT NULL
GROUP BY LEFT(Hylle,1),Kategori;