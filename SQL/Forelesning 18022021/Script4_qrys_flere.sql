-- https://www.dbsys.info/Databasesystemer/2_Losninger/kap4losning.html
USE ansattpersonal2021;

-- Data i tabellen Ansatt
SELECT *
FROM ansatt;

-- Data i tabellen postkatalog
SELECT *
FROM postkatalog;


-- Kryssproduktet av postkatalog og ansatt
SELECT *
FROM postkatalog,ansatt;

-- Likekobling, liste over ansatte med postadresser, med WHERE-betingelse
SELECT *
FROM postkatalog,ansatt
WHERE postkatalog.Postnr=ansatt.Postnr;


-- Likekobling, liste over ansatte med postadresser, med INNER-JOIN --> jfr s 100
SELECT *
FROM postkatalog INNER JOIN 
    ansatt 
    ON postkatalog.Postnr = ansatt.Postnr;


-- Med kolonneutvalg
SELECT ansatt.*,Poststed
FROM postkatalog,ansatt
WHERE ansatt.Postnr=postkatalog.Postnr;

-- med kolonneutvalg, mer spesifisert
SELECT Ansattnr, Fornavn, Etternavn, Gateadresse, ansatt.Postnr,Poststed
FROM postkatalog,ansatt
WHERE ansatt.Postnr=postkatalog.Postnr;


-- Likekobling 3 tabeller, liste over ansatte, hvilken stilling vedkommende har og hvilken avdeling personen tilhører. 
SELECT Ansattnr,Fornavn,Etternavn,Stillingsbetegnelse,Avdelingsnavn
FROM ansatt,avdeling,stillingstype
WHERE ansatt.Stillingskode = stillingstype.Stillingskode
    AND ansatt.Avdelingsnr = avdeling.Avdelingsnr;


-- Samme som over, med INNER-JOIN
SELECT Ansattnr,Fornavn,Etternavn,Stillingsbetegnelse,Avdelingsnavn
FROM ansatt 
    INNER JOIN stillingstype
        ON ansatt.Stillingskode = stillingstype.Stillingskode
    INNER JOIN avdeling
        ON ansatt.Avdelingsnr = avdeling.Avdelingsnr;

-- Eller du kan velge å være vanskelig
SELECT Ansattnr,Fornavn,Etternavn,Stillingsbetegnelse,Avdelingsnavn
FROM stillingstype INNER JOIN 
    (ansatt INNER JOIN avdeling
        ON ansatt.Avdelingsnr=avdeling.Avdelingsnr)
    ON stillingstype.Stillingskode = ansatt.Stillingskode;


-- Bruk av view/utsnitt (virtuell tabell)
-- Oppretting av View Anstattliste 
-- Etternavn, Fornavn, Stillingsbetegnelse, Avdelingsnavn 
-- Med info fra de tre tabellene: Ansatt, Avdeling, Stillingstype

DROP VIEW IF EXISTS Ansattliste;

CREATE VIEW Ansattliste(Etternavn, Fornavn, Stilling, Avdeling) AS(
    SELECT Etternavn, Fornavn, Stillingsbetegnelse, Avdelingsnavn
    FROM ansatt,avdeling,stillingstype
    WHERE ansatt.Stillingskode = stillingstype.Stillingskode
        AND ansatt.Avdelingsnr = avdeling.Avdelingsnr
);

SELECT * FROM Ansattliste;


-- Ytre koblinger
-- Ønsker også stillingsbetegnelser som ikke er i bruk 
-- https://www.softwaretestinghelp.com/inner-join-vs-outer-join 
SELECT *
FROM Stillingstype LEFT OUTER JOIN ansatt
    ON Stillingstype.Stillingskode = ansatt.Stillingskode;
    

-- Ekvialent
SELECT *
FROM ansatt RIGHT OUTER JOIN Stillingstype
    ON ansatt.Stillingskode=Stillingstype.Stillingskode;

SELECT *
FROM ansatt 
    Right Outer JOIN Avdeling
        ON ansatt.Avdelingsnr=Avdeling.Avdelingsnr
;