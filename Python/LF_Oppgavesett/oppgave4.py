tall1=int(input("Skriv inn tall nummer en:"))
tall2=int(input("Skriv inn tall nummer to:"))
tall3=int(input("Skriv inn tall nummer tre:"))
tall4=int(input("Skriv inn tall nummer fire:"))
tall5=int(input("Skriv inn tall nummer fem:"))

#sikrer at minste_tall er predefinert som en variabel som garantert er større enn det minste tallet uansett størelsesorden
minste_tall=tall1*tall2*tall3*tall4*tall5

#kjedelig
if tall1<tall2:
    minste_tall=tall1
    tall_sekvens=1

if tall3<minste_tall:
    minste_tall=tall3
    tall_sekvens=3

if tall4<minste_tall:
    minste_tall=tall4
    tall_sekvens=4

if tall5<minste_tall:
    minste_tall=tall5
    tall_sekvens=5

if tall2<minste_tall:
    minste_tall=tall2
    tall_sekvens=2

print("Det minste tallet er:",minste_tall)
print("Og det er tall nummer:",tall_sekvens,"i rekken")