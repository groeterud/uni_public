'''
Dersom det er 20 deltakere eller flere er tillegget pr deltaker 350 kr.
Lag et program som beregner og skriver ut total pris basert på antall deltakere som inndata.
'''

LEIE=2500
tillegg_pr_deltaker=420

antall_deltakere=int(input("Hvor mange deltakere? "))

if antall_deltakere>20:
    tillegg_pr_deltaker=350
else:
    if antall_deltakere>10:
        tillegg_pr_deltaker=380

sum=(antall_deltakere*tillegg_pr_deltaker)+LEIE

print(sum)