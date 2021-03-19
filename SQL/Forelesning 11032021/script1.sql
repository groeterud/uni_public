USE Hobbyhuset;

SELECT *
FROM Gullklubblista
ORDER BY AntallBestillinger DESC;

-- Uten VIEW 
SELECT KNr, COUNT(*) AS antall_kjop, Fornavn,Etternavn
FROM ordre JOIN 
    kunde USING (KNr)
GROUP BY KNr 
HAVING antall_kjop>9
ORDER BY antall_kjop DESC;



USE Egenkobling;
-- Vis ledere tilhørende hver enkelt ansatt
SELECT Ansatte.AnsNr,Ansatte.Fornavn,Ansatte.Etternavn,Lederen.Etternavn AS HarSomLeder
FROM (ansatt AS Ansatte) LEFT OUTER JOIN (ansatt AS Lederen)
ON Ansatte.Leder=Lederen.AnsNr
ORDER BY HarSomLeder,Ansatte.Etternavn,Ansatte.Fornavn;

USE Egenkobling;
SELECT *
FROM ansatt;

-- Delspørringer
-- Finne varer billigere enn gjennomsnittet ADD 
USE Hobbyhuset;
SELECT VNr, Betegnelse, Pris 
FROM vare
WHERE Pris<(SELECT AVG(Pris) FROM vare);

-- Finn de(n) billigste varen(e) i hver kategori 
-- vekselvirkende del-spørringer. 
SELECT Vare1.VNr,Vare1.Betegnelse,Vare1.Pris,Vare1.KatNr
FROM Vare as Vare1
WHERE Vare1.Pris=
    (SELECT MIN(Vare2.Pris)
    FROM vare AS Vare2
    WHERE Vare1.KatNr=Vare2.KatNr)
ORDER BY KatNr;

-- Billigste vare i hver kategori ved bruk av view

CREATE VIEW BilligstIKategori AS (
    SELECT Vare1.VNr,Vare1.Betegnelse,Vare1.Pris,Vare1.KatNr
    FROM Vare as Vare1
    WHERE Vare1.Pris=
        (SELECT MIN(Vare2.Pris)
        FROM vare AS Vare2
        WHERE Vare1.KatNr=Vare2.KatNr)
    ORDER BY KatNr
);

SELECT *
FROM BilligstIKategori;



