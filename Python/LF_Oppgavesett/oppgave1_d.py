'''Firmaet vurderer å gå over til en ny prisstrategi
3.500 kr i baneleie og 350 kr pr deltaker for inntil 9 deltakere
2.000 kr i baneleie og 400 kr pr deltaker fra 10 inntil 19 deltakere
1.000 kr i baneleie og 450 kr pr deltaker fra 20 deltaker
Maks kapasitet på en leieavtale er 30 deltakere.
Lag et program som på bakgrunn av antall deltakere sammenligner og skriver ut pris etter 
gammel prisstrategi (a)-c)) og ny prisstrategi (d)) og skriver ut hvilken prisstrategi som er best for 
firmaet for det oppgitte deltakerantallet.'''


leie=2500
tillegg_pr_deltaker=420

antall_deltakere=int(input("Hvor mange deltakere? "))

if antall_deltakere>30: 
    print("for mange")
else: 
    if antall_deltakere>20:
        tillegg_pr_deltaker=350
    else:
        if antall_deltakere>10:
            tillegg_pr_deltaker=380

    sum_gammel=(antall_deltakere*tillegg_pr_deltaker)+leie

    print("Pris for gammel modell er:",sum_gammel)

    if antall_deltakere>20:
        leie=1000
        tillegg_pr_deltaker=450
    else:
        if antall_deltakere>10:
            leie=2000
            tillegg_pr_deltaker=400
        else:
            leie=3500
            tillegg_pr_deltaker=350

    sum_ny=(antall_deltakere*tillegg_pr_deltaker)+leie

    print("Pris for ny modell er:",sum_ny)

