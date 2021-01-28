-- Gruppering
USE gruppering;
SELECT * 
FROM Ansatt;
-- hvor mange ansatte
SELECT COUNT(*) AS AntallAnsatte
FROM Ansatt
WHERE Ansattnr IS NOT NULL;

-- hvor mange forskjellige stillingskoder
SELECT COUNT(Stillingskode) AS AntallStillingskoder
FROM Ansatt
WHERE Stillingskode IS NOT NULL;

-- hvor mange ansatte pr stillingskode
SELECT COUNT(*) AS Antall, Stillingskode
FROM Ansatt
GROUP BY Stillingskode;

-- det høyeste og laveste lønnstrinnet innenfor hver stillingskode. 
SELECT Stillingskode, MIN(Lønnstrinn) AS LavesteLønn, MAX(Lønnstrinn) AS HøyesteLønn
FROM Ansatt
GROUP BY Stillingskode;


-- Dobbelgruppering, viser alle unike kombinasjoner. 
SELECT Stillingskode, Lønnstrinn
FROM Ansatt
GROUP BY Stillingskode, Lønnstrin;


-- noe som lar oss telle antall treff i de unike kombinasjonene: 
-- hvor mange ansatte pr stillingskode
SELECT COUNT(*) AS Antall, Stillingskode, Lønnstrinn
FROM Ansatt
GROUP BY Stillingskode, Lønnstrinn;


-- Oppsummering
-- Gruppekriteriet: i SELECT-delen og GROUP BY
-- Gruppebetingelse: HAVING
-- COUNT(*) vs COUNT(kolonnenavn)
