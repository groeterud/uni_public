'''
En utleier av paintball (bane og utstyr) beregner sine priser på følgende måte:
Leie av bane: 2.500 kr
Tillegg pr deltaker: 420 kr

Lag et program som beregner og skriver ut total pris basert på antall deltakere som inndata.
'''

LEIE=2500
TILLEGG_PR_DELTAKER=420

antall_deltakere=int(input("Hvor mange deltakere? "))

sum=(antall_deltakere*TILLEGG_PR_DELTAKER)+LEIE

print(sum)
