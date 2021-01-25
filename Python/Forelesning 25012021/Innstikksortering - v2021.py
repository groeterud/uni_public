#Innstikksortering - v2021
#Program for å innstikksortere en usortert liste

#Pseudokode på algoritmen fra https://en.wikipedia.org/wiki/Insertion_sort

#for i ← 1 to length(A)
#    j ← i
#    while j > 0 and A[j-1] > A[j]
#        swap A[j] and A[j-1]
#        j ← j - 1
#    end while
#end for



usortert=[5,3,1,2,4]

tabellengde=len(usortert)
print(usortert)

#Denne algoritmen selekterer ett kort og sammenligner det kortet med tall til venstre i tallrekkefølgen. 
#Dersom tallet til venstre er mindre så bytter de plass og tallet vårt sammenlignes på ny med det tallet som er til venstre etter byttingen. 


#for alle verdier av "i" i spennet 1 til lengden av usortert 
for i in range(1,tabellengde,1):
    #j sin startverdi blir verdien vår av i, dvs at verdien for j øker med 1 for hver gjennomkjøring av algoritmen.
    #det hindrer av vi sorterer 'kort' vi allerede har sortert. 
    j=i

    #så lenge j er større enn 0
    #og usortert av j-1 er STØRRE enn usortert av j, dvs: så lenge kortet til venstre er større enn det valgte kortet
    while j>0 and usortert[j-1]>usortert[j]:
        #plasserer kortet vårt i midlertidig variable
        x=usortert[j]
        #flytter det 'større' kortet en plass til høyre
        usortert[j]=usortert[j-1]
        #flytter kortet vårt en plass til venstre fra sin originale posisjon
        usortert[j-1]=x

        #gjør j 1 mindre for at den skal nå 0. Dette er fordi kortet vårt har flyttet seg en posisjon til venstre.
        #Slik garanterer vi at alle kort blir sammenlignet med den minste verdien fra tidligere sorteringer. 
        j=j-1

print(usortert)
