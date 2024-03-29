# Notater forelesning 1102

## generell fremgangsmåte for datamodellereing.
Fra konseptuell modell (analyse) til logisk datamodell.
_"Dette er grunnlaget, den viktigste jobben. Resten er teknikk"_
1. Finn de egentlige/rene entitetstypene. 
2. Finn / bestem relasjonstypene. 
3. Finn attributtene til de rene entitetstypene
4. Finn attributtene til "relasjonstypene" ved (n:m) relasjonstyper + entitisering. 
5. Normaliser = "vask" entititetsypene mot 1.-3. NF/BCNF s240-242

## Mange til mange relasjonstype

| Studentnr(PK) | Emnekode(PK) | Semester(PK) | Resultat | 
| --------- | -------- | -------- | -------- |
| 1000 | PRG1000 | H2020 | F |
| 2000 | PRG1000 | H2020 | B |
| 1000 | WEB1100 | H2020 | C |
| 1000 | PRG1000 | V2021 | D |

### Konseptuell vs logisk datamodell. 
Den konseptuelle datamodellen skal representere hvordan systemet virker i den virkelige verden. 
Den logiske datamodellen er hvordan den fysiske databasen skal struktureres. Dette skal, og bør være forskjellig. 

### Entitetisering
Vi kan fint ha mange til mange relasjon i den konseptuelle modellen, mens i den logiske modellen er det nødvendig å konkretisere ned til slik at vi bare kan ha "en til en", eller "en til mange" relasjon.
For å hindre mange til mange relasjon må vi introdusere en ny entitet med spesifike attributter som tillater oss å ha mange til en relasjon. Denne prosessen kaller vi for entitetisering. Samtidig er det viktig å huske på at man ønsker å beholde "mange til mange" forhold så lenge som overhodet mulig, slik at den logiske modellen er så spesifikk som mulig.

En måte å tenke på dette er en å tenke over hvilke attributter som fører til "mange til mange" relasjon, og hvordan vi kan dra disse ut til en entitet som kan fungere som en bro mellom to entiteter fra den konseptuelle modellen. 

## Primærnøkler (PK) og Fremmednøkler(FK)
Når vi entitetiserer vil Primærnøkkelen i én-siden av relasjonen alltid bli en fremmednøkkel i mange-siden av relasjonen, selv om det evt er en sammensatt nøkkel. 
Ved en til mange (1:n) relasjoner i den konseptuelle modeller vil primærnøkkelen i 1-delen være til stede i n-delen som en fremmednøkkel, men den vil bare være en del av primærnøkkelen i n-delen dersom det er en hensiktsmessig måte å identifisere entiteten på. 

**IKKE** erstatt gode sammensatte nøkler med generiske attributter bare fordi de er enklere. Dette betyr jo ogsås amtidig at når man innfører attributter som 'ansattID' så må vi også være sikker på at disse er nødvendige som identifikator.
**SAMTIDIG** vil en sammensatt primærnøkkel ha innebygd verifisering av at dataene er unike. Dersom du erstatter en sammensatt primærnøkkel med en genereisk primærnøkkel / autonummer nøkkel så flytter du all kontroll på inn-data over fra databasesystemet over på applikasjonslaget, noe som nødvendigjør ytterligere arbeid og som åpner for potensielle feil. 

## Relasjonsdatabaser vs relasjoner i datamodeller
Disse har ikke noe med hverandre å gjøre utover å dele navn. 
Relasjonsdatabaser er databaser bestående av normaliserte tabeller. En normalisert tabell er normalisert når den kan tikke av en to-tre ja/nei spørsmål. 

## Normalisering av tabeller og normalform
### Determinering
Et attributt eller en gruppe av attributter som bestemmer / determinerer verdien av et annet attributt.
### 1NF - Atomærkravet 
1. Attributtet skal ike kunne deles opp i flere deler
2. Attributtet skal ikke repeteres
Det viktigste er at "de brukes atomisk" "fødselsnur er atomisk" selv om det kan deles opp i fødselsnr = fødselsdato + teller + kontroll. 

## 2NF - Partiell avhengighet 
Partiell avhengighet er når attributter kan avledes av deler av nøkkelen. Dvs at verdien på nøkkelen kan bestemmer verdien på attributter. 
Eksemepelvis i Eksamensresultat(__\*Studentnr__,__\*Emnekode__,**Semester**,Emnenavn,Resultat) så vil _Emnenavn_ være avhengig av Emnekoden og bryter med 2NF. Emnenavn burde ligge i den entiteten hvor Emnekode er primærnøkkel

## 3NF - Transitive avhengigheter
Brudd på 3NF er når en attributt kan avledes av et attributt som ikke er en nøkkel.  
Eksempel gitt: Student(**Studentnr**,Fornavn,Etternavn,Gateadresse,Telefon,Postnr,Poststed,Kull)
Med viten om hvordan postnummer er strukturert i Norge avledes poststed når man har informasjon om postnummeret. Selv om postnummeret ikke er en primær- eller fremmednøkkel. Og når iom at kombinasjonen postnr poststed ikke er unik, samt avledes vil man dobbeltlagre denne kombinasjonen av data ganske mange ganger.

## Hovedregelen for Normalisering - Boyce-Codd (BCNF)
En datamodell er godt normalisert ("godt tilrettelagt for en relasjonsdatabase") dersom:
1. Alle attributtene er atomære (1NF)
2. Enhver determinant er en **kandidatnøkkel**

**kandidatnøkkel** = mulig primærnøkkel

For de fleste tilfller til 3NF ogsi gå BCNF, men det kan forekomme tilfeller med fullverdig 3NF, men som inneholder omvendt avledelse altså at en del av primærnøkkelen kan avledes fra en attributt. I disse tilfeller blir løsningen å flytte primærnøkkelne over til en egen entitet, med determinerende attributt som primærnøkkel. Denne primærnøkkelen blir oppgradert til fremmednøkkel i den originale entiteten og innlemmes som en del av primærnøkkelen. 

## Skrive SQL Script for modellen.
- Vi starter med tabeller som ikke har fremmednøkler. 
