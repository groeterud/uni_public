---------- TOLKE OPPGAVEN
#1 En skal oppgi mobilnr
## en entry 
## hente entry i variabel 
mobilnr=mobilnr_stringvar.get()

#2 Så skal fornavn og etternavn på kunden vises 
## SQL spørring
## legg i liste
## gå gjennom liste og hent fornavn + etternavn
## sett readonly entryer (eller labels) til fornavn + etternavn 

#3 Så skal man registrere ny hund på kunden
## Få info om hund fra entrys 
## get det 
## SQL spørring INSERT 
## PRINT DONE 

--------- Strukturere programmet
### GUI STRUKTUR 
## window=Tk()
# --> Mobilnr entry
# søkeknapp
# avslutt 

## ny_hund=Toplevel()
# visning fornavn+etternavn
# inndata hund
# lagre
# avslutt 


### PROGRAM/Logikk STRUKTUR
## imports og drit
# lager databaseconnection

## Def søk (første vindu, finn mobilnr)
# hente inndata 
# lage markør
# lage spørring
# utføre spørring
# opprette fornavn og etternavn
# gå gjennom spørring og tilordne fornavn + etternavn
# sett readonly-entry til fornavn + etternavn

# - HER MÅ GUI TIL TOPLEVEL VÆRE 

### Def lagre (innenfor søk)
# henter info fra entry på hundedata
# Lag sql spørring
# utfør sql 
# messagebox om at det gikk bra! 


