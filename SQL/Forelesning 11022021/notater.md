# Notater forelesning 1102

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
