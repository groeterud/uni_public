-- Script for basisstruktur ansattpersonal2021
-- Utvidet med skranke: Ikke tillatte NULL_merke
-- Ny utvidelse: skranker for masseoppdatering https://www.sqlshack.com/delete-cascade-and-update-cascade-in-sql-server-foreign-key/

DROP SCHEMA IF EXISTS ansattpersonal2021;
CREATE SCHEMA IF NOT EXISTS ansattpersonal2021;
USE ansattpersonal2021;
-- Oppreter tabeller, runde (1) - tabeller uten fremmednøkler.
CREATE TABLE Kurs (
    Kursnr CHAR(4),
    Kursnavn CHAR(20) NOT NULL,
    CONSTRAINT KursPK PRIMARY KEY (Kursnr)
);
CREATE TABLE Postkatalog (
    Postnr CHAR(4),
    Poststed CHAR(20) NOT NULL,
    CONSTRAINT PostkatalogPK PRIMARY KEY (Postnr)
);

CREATE TABLE Avdeling (
    Avdelingsnr CHAR(4),
    Avdelingsnavn CHAR(20) NOT NULL,
    CONSTRAINT AvdelingPK PRIMARY KEY (Avdelingsnr)
);
CREATE TABLE Stillingstype (
    Stillingskode CHAR(4),
    Stillingsbetegnelse CHAR(20) NOT NULL,
    CONSTRAINT StillingstypePK PRIMARY KEY (Stillingskode)
);
-- Oppretter tabeller, runde (2) - tabeller med fremmednøkler.
CREATE TABLE Ansatt (
    Ansattnr CHAR(4),
    Fornavn CHAR(15) NOT NULL,
    Etternavn CHAR(20) NOT NULL,
    Gateadresse CHAR(25),
    Telefonnr CHAR(8) NOT NULL,
    Stillingskode CHAR(4),
    Avdelingsnr CHAR(4),
    Postnr CHAR(4),
    CONSTRAINT AnsattPK PRIMARY KEY (Ansattnr),
    CONSTRAINT AnsattStillingstypeFK FOREIGN KEY (Stillingskode) REFERENCES Stillingstype(Stillingskode),
    CONSTRAINT AnsattAvdelingFK FOREIGN KEY (Avdelingsnr) REFERENCES Avdeling(Avdelingsnr) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT AnsattPostkatalogFK FOREIGN KEY (Postnr) REFERENCES Postkatalog(Postnr) 
);
-- Oppretter tabeller, runde (3) - tabeller med fremmednøkler, og sammensatte primærnøkler.
-- Samt fremmednøkkel som var avhengig av primærnøkkel fra Ansatt
CREATE TABLE Kursdeltagelse (
    Ansattnr CHAR(4),
    Kursnr CHAR(4),
    Aarstall DATE,
    Vurdering CHAR(20),
    CONSTRAINT KursdeltagelsePK PRIMARY KEY (Aarstall,Kursnr,Ansattnr),
    CONSTRAINT KursdeltagelseAnsattFK FOREIGN KEY (Ansattnr) REFERENCES Ansatt(Ansattnr),
    CONSTRAINT KursdeltagelseKursFK FOREIGN KEY (Kursnr) REFERENCES Kurs(Kursnr),
    CONSTRAINT VurderingsRegel CHECK (Vurdering in ('Bestått','Ikke bestått','Gjennomført','Ikke møtt'))
);