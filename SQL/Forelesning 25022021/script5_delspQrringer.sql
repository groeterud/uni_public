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