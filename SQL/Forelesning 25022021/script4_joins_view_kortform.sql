USE ansattpersonal2021;

SELECT *
FROM Ansattliste
ORDER BY Avdeling;


-- Kryssprodukt ved bruk av INNER JOIN (uten å bruke ON)

SELECT *
FROM Ansatt
    INNER JOIN Postkatalog;

-- kryssproduktet ved fjerning av nøkkelorder INNER (DVS en JOIN er en INNER JOIN)

SELECT *
FROM Ansatt JOIN Postkatalog;


-- likekobling
-- Liste over ansattemed postadresser, med inner join og fjerning av nøkkelordet INNER 

SELECT Ansattnr,Fornavn,Etternavn,Gateadresse,Ansatt.Postnr,Poststed
FROM Ansatt JOIN Postkatalog ON Ansatt.Postnr = Postkatalog.Postnr;

-- og videre med kortvarianten USING 
SELECT Ansattnr,Fornavn,Gateadresse,Ansatt.Postnr,Poststed
FROM Ansatt JOIN Postkatalog USING (Postnr);


-- Og med tre tabeller får vi (JOIN OG USING)
SELECT Etternavn,Fornavn,Stillingsbetegnelse,Avdelingsnavn
FROM Stillingstype JOIN 
    (Ansatt JOIN Avdeling
        USING (Avdelingsnr))
    USING (Stillingskode);

--alternativt
SELECT Etternavn,Fornavn,Stillingsbetegnelse,Avdelingsnavn
FROM Ansatt
    JOIN Stillingstype USING (Stillingskode)
    JOIN Avdeling USING(Avdelingsnr);


-- Ytre koblinger, tilsvarende kan nøkkelordet OUTER utelates ved LEFT OUTER JOIN og RIGHT OUTER JOIN
-- DVS at LEFT JOIN er det samme som LEFT OUTER JOIN 

SELECT * FROM Stillingstype
LEFT JOIN Ansatt ON Stillingstype.Stillingskode=Ansatt.Stillingskode;

-- Kortform USING 
SELECT * FROM Stillingstype
LEFT JOIN Ansatt USING(Stillingskode); 

