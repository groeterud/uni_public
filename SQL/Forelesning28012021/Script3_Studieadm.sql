DROP SCHEMA IF EXISTS Studieadm;

CREATE SCHEMA IF NOT EXISTS Studieadm;

USE Studieadm;

CREATE TABLE Student
(
    Studentnr CHAR(6) PRIMARY KEY,
    Fornavn VARCHAR(30),
    Etternavn VARCHAR(30),
    Epost VARCHAR(30),
    Fødselsdato CHAR(6),
    Kjønn CHAR(1),
    Studium VARCHAR(15)
);

INSERT INTO Student
VALUES(
    '240214','Andreas','Grøterud','ikkedoxdegselv@gmail.com','170591','M','Bach IT og IS'
),
(
    '21323','Kari','Jaquesson','ingenmaske@online.no','240361','F','Bach økadm'
),
(
    '204112','Ola','Nordmann','brukerstyrt@yahoo.com','050101','M','Bach IT og IS'
),
(
    '211934','Helene','Olafssen','kontakt@senkveld.no','131086','F','Bach økadm'
),
(
    '241680','Kari','Vilikke','vilikke_kare@hotmail.com','150294','F','Bach økadm'
),
(
    '233514','Johann','Filtvedt','jfiltvedt@gmail.com','200297','M','Bach IT og IS'
),
(
    '303404','Fredrik','Solheim','debatt@nrk.no','010575','M','Bach IT og IS'
),
(
    '240216','Jenny','Jensen','syngedame@danseband.no','050666','F','Bach økadm'
),
(
    '240001','Heidi','Ødegård','heidisport22@yahoo.no','100300','F','Bach IT og IS'
),
(
    '241337','Ståle','Vikhagen','stalev@online.no','050164','M','Bach IT og IS'
);

SELECT *
FROM student;