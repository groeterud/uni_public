DROP SCHEMA IF EXISTS testdatabase;

CREATE SCHEMA testdatabase;

USE testdatabase;


-- test av ulike datatyper
-- oppretter tabellen Datatyper
CREATE TABLE Datatyper
(
    Postnr1 INTEGER,
    Postnr2 CHAR(4),
    Dato1 DATE,
    Dato2 DATE
);
INSERT INTO Datatyper VALUES (0304,'0304','2021-02-25','20210225');


-- Endring av tabeller 
CREATE TABLE Telefonliste
(
    Mobilnr CHAR (8) PRIMARY KEY,
    Fornavn CHAR (15)
);

INSERT INTO Telefonliste VALUES ('12345678','Ståle');

-- Legge til ny kolonne e-postadresse

ALTER TABLE Telefonliste
ADD COLUMN epost CHAR (30);

UPDATE Telefonliste
SET epost='s.vikhagen@usn.no',Mobilnr='93176231'
WHERE Fornavn='Ståle';


-- Opprette en ny tabell: Postkatalog
CREATE TABLE Postkatalog
(
    Postnr CHAR(4) PRIMARY KEY,
    Poststed CHAR(20) NOT NULL
);


-- Legge til kolonne postnr, som er FK mot postkatalog, i Telefonliste.
ALTER TABLE Telefonliste
ADD COLUMN Postnr CHAR(4);

ALTER TABLE Telefonliste
ADD CONSTRAINT TelefonlistePostkatalogFK FOREIGN KEY(Postnr) REFERENCES Postkatalog(Postnr);


INSERT INTO Postkatalog VALUES ('3470','Slemmestad'),('6400','Molde');

-- Oppdaterer Telefonliste
UPDATE Telefonliste
SET Postnr='3470'
WHERE Fornavn='Ståle';


-- Legger til Jens på postnr 64000
INSERT INTO Telefonliste VALUES ('99999999','Jens',NULL,'6400');

-- Se om FK fungerer slik det skal
SELECT Mobilnr,Fornavn,epost,telefonliste.Postnr,Poststed
FROM Telefonliste 
    INNER JOIN postkatalog
        ON telefonliste.Postnr=postkatalog.Postnr;

-- Nødvendig å oppdatere postkalogen for att '44444444' kan settes inn pga FK constrainten i Telefonliste
INSERT INTO Postkatalog VALUES ('7800','Namsos');

-- KJØRBAR?  NIX, lar seg ikke kjøre uten av vi kjører inserten over
INSERT INTO Telefonliste (Mobilnr,Fornavn,Postnr) VALUES ('44444444','Kari','7800')

