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



INSERT INTO ansatt(AnsNr,Fornavn,Etternavn,Adresse,PostNr,Fødselsdato,Kjønn,Stilling,Årslønn) VALUES(1,'Georg','Barth','Kringsjågrenda 3F','3841','1982-10-20','M','Lagerleder',604900.00),(2,'Gunnlaug','Angeltveit','Langmyrgrenda 9','3800','1969-03-29','K','Markedssjef',643200.00),(3,'Morgan','Dalland','Jansbergveien 19','3830','1974-01-10','M','Innkjøper',670500.00),(6,'Vilde','Aksnes','Minister Ditleffs vei 44','3810','1977-10-11','K','Databaseadministrator',693200.00),(7,'Henriette','Brobakken','Stubberud Sognsvann 1','3800','1971-10-01','K','Daglig leder',833800.00),(8,'Synøve','Bakketun','Vassøyveien 7','3840','1985-05-15','K','Kundebehandler',518100.00),(9,'Ragnvald','Allum','Utsikten 4','3812','1992-03-07','M','Kundebehandler',484700.00),(11,'Oliver','Abrahamsen','Tarjei Vesaas\' vei 3A','3812','1989-01-20','M','Lagermedarbeider',466900.00),(13,'Oda','Cappelen','Norheimskneiken 12','3800','1991-02-28','K','Produktutvikler',653100.00),(16,'Andrine','Ebbesen','Kristianias gate 9','3800','1988-12-27','K','Regnskapssekretær',532300.00),(17,'Karl Anton','Hoff','Furustia 3','3840','1997-08-03','M','Kundebehandler',472300.00),(18,'Johanna','Li','Krogsteinveien 101A','3841','1996-05-17','K','Kundebehandler',478600.00);







