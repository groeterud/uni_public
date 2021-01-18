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
SELECT DISTINCT 
       Kategori
FROM vare;