USE ansattpersonal2021;

INSERT INTO Kurs (Kursnr, Kursnavn)
VALUES (
    '1000','HMS'
),
(
    '2000', 'Brannvakt'
),
(
    '3000', 'Førstehjelp'
),
(
    '4000', 'Krisehjelp'
);

INSERT INTO Avdeling (Avdelingsnr, Avdelingsnavn)
VALUES (
    '1000', 'IT'
),
(
    '2000', 'Administrasjon'
),
(
    '3000', 'Økonomi'
),
(
    '4000', 'Personal'
),
(
    '5000', 'Vedlikehold'
);

INSERT INTO Postkatalog (Postnr, Poststed)
Values (
    '1000', 'Herøy'
),
(
    '1500', 'Hitra'
),
(
    '2000', 'Andalsnes'
),
(
    '2500', 'Arna'
),
(
    '3000', 'Oslo'
),
(
    '3500', 'Alta'
);

INSERT INTO Stillingstype (Stillingskode, Stillingsbetegnelse)
VALUES (
    '1000', 'Avdelingssjef'
),
(
    '2000', 'Konsulent'
),
(
    '3000', 'Økonomimedarbeider'
),
(
    '4000', 'Sekretær'
),
(
    '5000', 'Trainee'
);


INSERT INTO Ansatt (Ansattnr, Fornavn, Etternavn, Gateadresse, Telefonnr, Stillingskode, Avdelingsnr, Postnr)
VALUES (
    '1000', 'Ola', 'Nordmann', 'Tulleveien 14', '48813223', '1000','3000','3500'
),
(
    '2000', 'Kari', 'Vilikke', 'Kankeveien 12', '98776321', '3000','3000','3000'
),
(
    '3000', 'Andreas', 'Jørgensen', 'Skrantegata 9', '12345678', '2000','2000','3000'
),
(
    '4000', 'Kari', 'Jaquesson', 'Konspiratia 911', '12394567','1000','1000','1000'
),
(
    '5000', 'Donald','Drumpf',NULL, '93276992','2000','4000','2000'
);

INSERT INTO kursdeltagelse (Ansattnr,Kursnr,Aarstall,Vurdering)
VALUES (
    '1000','1000','2021-02-21','Bestått'
),
(
    '1000','2000','2020-10-31','Ikke møtt'
),
(
    '2000','1000','2019-01-30','Gjennomført'
),
(
    '2000','2000','2021-02-21','Ikke bestått'
),
(
    '3000','3000','2012-03-20','Bestått'
),
(
    '4000','2000','2011-9-12','Gjennomført'
),
(
    '5000','2000','1998-12-13','Ikke møtt'
),
(
    '5000','3000','2001-12-31','Ikke bestått'
);
