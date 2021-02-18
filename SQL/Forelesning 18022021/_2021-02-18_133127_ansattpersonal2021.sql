DROP TABLE IF EXISTS ansatt;
CREATE TABLE `ansatt` (
  `Ansattnr` char(4) NOT NULL,
  `Fornavn` char(15) NOT NULL,
  `Etternavn` char(20) NOT NULL,
  `Gateadresse` char(25) DEFAULT NULL,
  `Telefonnr` char(8) NOT NULL,
  `Stillingskode` char(4) DEFAULT NULL,
  `Avdelingsnr` char(4) DEFAULT NULL,
  `Postnr` char(4) DEFAULT NULL,
  PRIMARY KEY (`Ansattnr`),
  KEY `AnsattStillingstypeFK` (`Stillingskode`),
  KEY `AnsattAvdelingFK` (`Avdelingsnr`),
  KEY `AnsattPostkatalogFK` (`Postnr`),
  CONSTRAINT `AnsattAvdelingFK` FOREIGN KEY (`Avdelingsnr`) REFERENCES `avdeling` (`Avdelingsnr`),
  CONSTRAINT `AnsattPostkatalogFK` FOREIGN KEY (`Postnr`) REFERENCES `postkatalog` (`Postnr`),
  CONSTRAINT `AnsattStillingstypeFK` FOREIGN KEY (`Stillingskode`) REFERENCES `stillingstype` (`Stillingskode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS avdeling;
CREATE TABLE `avdeling` (
  `Avdelingsnr` char(4) NOT NULL,
  `Avdelingsnavn` char(20) NOT NULL,
  PRIMARY KEY (`Avdelingsnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS kurs;
CREATE TABLE `kurs` (
  `Kursnr` char(4) NOT NULL,
  `Kursnavn` char(20) NOT NULL,
  PRIMARY KEY (`Kursnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS kursdeltagelse;
CREATE TABLE `kursdeltagelse` (
  `Ansattnr` char(4) NOT NULL,
  `Kursnr` char(4) NOT NULL,
  `Aarstall` date NOT NULL,
  `Vurdering` char(20) DEFAULT NULL,
  PRIMARY KEY (`Aarstall`,`Kursnr`,`Ansattnr`),
  KEY `KursdeltagelseAnsattFK` (`Ansattnr`),
  KEY `KursdeltagelseKursFK` (`Kursnr`),
  CONSTRAINT `KursdeltagelseAnsattFK` FOREIGN KEY (`Ansattnr`) REFERENCES `ansatt` (`Ansattnr`),
  CONSTRAINT `KursdeltagelseKursFK` FOREIGN KEY (`Kursnr`) REFERENCES `kurs` (`Kursnr`),
  CONSTRAINT `VurderingsRegel` CHECK ((`Vurdering` in (_utf8mb4'Bestått',_utf8mb4'Ikke bestått',_utf8mb4'Gjennomført',_utf8mb4'Ikke møtt')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS postkatalog;
CREATE TABLE `postkatalog` (
  `Postnr` char(4) NOT NULL,
  `Poststed` char(20) NOT NULL,
  PRIMARY KEY (`Postnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS stillingstype;
CREATE TABLE `stillingstype` (
  `Stillingskode` char(4) NOT NULL,
  `Stillingsbetegnelse` char(20) NOT NULL,
  PRIMARY KEY (`Stillingskode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




