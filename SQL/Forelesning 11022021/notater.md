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

Vi kan fint ha mange til mange relasjon i den konseptuelle modellen, mens i den logiske modellen er det nødvendig å konkretisere ned til slik at vi bare kan ha "en til en", eller "en til mange" relasjon.
For å hindre mange til mange relasjon må vi introdusere en ny entitet med spesifike attributter som tillater oss å ha mange til en relasjon. Denne prosessen kaller vi for entitetisering. 


