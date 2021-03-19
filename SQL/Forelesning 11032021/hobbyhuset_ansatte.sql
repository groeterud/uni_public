DROP TABLE IF EXISTS ansatt;
CREATE TABLE `ansatt` (
  `AnsNr` smallint NOT NULL,
  `Fornavn` varchar(50) NOT NULL,
  `Etternavn` varchar(50) NOT NULL,
  `Adresse` varchar(100) DEFAULT NULL,
  `PostNr` char(4) NOT NULL,
  `Fødselsdato` date DEFAULT NULL,
  `Kjønn` char(1) DEFAULT NULL,
  `Stilling` varchar(50) DEFAULT NULL,
  `Årslønn` decimal(8,2) NOT NULL,
  PRIMARY KEY (`AnsNr`),
  KEY `AnsattPoststedFN` (`PostNr`),
  CONSTRAINT `AnsattPoststedFN` FOREIGN KEY (`PostNr`) REFERENCES `poststed` (`PostNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;









