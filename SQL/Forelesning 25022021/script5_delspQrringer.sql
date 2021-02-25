USE Hobbyhuset;

-- Introduksjon til delspørringer, delspørringer i betingelser. 

SELECT * FROM kunde;


-- Hvem har "bestilt varer"? dvs minst en ordre
SELECT * FROM ordre;

SELECT *
FROM kunde
WHERE KNr IN (SELECT KNr FROM ordre);


-- Komplimentære spørringer.
-- Kunder som ALDRI har bestilt noe
SELECT *
FROM kunde
WHERE KNr NOT IN (SELECT KNr FROM ordre);


-- View'et GodeKunder
CREATE VIEW GodeKunder AS (
    SELECT * 
    FROM kunde 
    WHERE KNr IN 
    (
        SELECT KNr
        FROM ordre
    )
);



-- Spørre mot viewet isteden
SELECT * FROM GodeKunder;


-- Videre arbeid / forberedelse til neste gang: 
-- Finn gullklubben. 
-- Lag en spørring, lag en view av den spørringen for å plukke ut kunder med 10 eller flere bestillinger. 
-- Gullklubben - liste ti sjefen med informasjon alle kunder i Gullklubben.

SELECT *, COUNT(Knr) AS Antall_kjop
FROM ordre
GROUP BY KNr;


CREATE VIEW AntallKjop AS (
    SELECT *, COUNT(Knr) AS Antall_kjop
    FROM ordre
    GROUP BY KNr
);

SELECT * FROM AntallKjop WHERE Antall_kjop>=10;

CREATE VIEW Antall_kjop_over_ti AS (
    SELECT *
    FROM AntallKjop
    WHERE Antall_kjop>=10
);

SELECT Kunde.KNr,Fornavn,Etternavn,Antall_kjop_over_ti.Antall_kjop
FROM kunde,Antall_kjop_over_ti;

DROP VIEW IF EXISTS Gullklubben;
CREATE VIEW Gullklubben AS (
    SELECT Kunde.KNr,Fornavn,Etternavn,Antall_kjop_over_ti.Antall_kjop
    FROM kunde,Antall_kjop_over_ti
    WHERE kunde.KNr=Antall_kjop_over_ti.KNr
);

SELECT * FROM Gullklubben;


-- Andreas er lettere hjerneskadet. Se under for Terje sin gode løsning. 
SELECT KNr, COUNT(*) AS antall_kjop, Fornavn,Etternavn
FROM ordre JOIN 
    kunde USING (KNr)
GROUP BY KNr HAVING antall_kjop>9
ORDER BY antall_kjop DESC;


CREATE VIEW Gullklubben_Terje AS (
   SELECT KNr, COUNT(*) AS antall_kjop, Fornavn,Etternavn
    FROM ordre JOIN 
        kunde USING (KNr)
    GROUP BY KNr HAVING antall_kjop>9
    ORDER BY antall_kjop DESC
);

SElECT * FROM Gullklubben_Terje;
