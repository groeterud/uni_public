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
WHERE Stillingskode IS NOT NULL
GROUP BY Stillingskode;

-- det høyeste og laveste lønnstrinnet innenfor hver stillingskode. 
SELECT Stillingskode, MIN(Lønnstrinn) AS LavesteLønn, MAX(Lønnstrinn) AS HøyesteLønn
FROM Ansatt
WHERE Stillingskode IS NOT NULL
GROUP BY Stillingskode;