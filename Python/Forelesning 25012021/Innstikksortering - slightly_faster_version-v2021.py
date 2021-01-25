#Innstikksortering - slightly_faster_version-v2021
#Program for å innstikksortere en usortert liste

#fra https://en.wikipedia.org/wiki/Insertion_sort:
#kommentaren tar utgangspunkt i "Innstikksortering - v2021"
#After expanding the "swap" operation in-place as
#t ← A[j]; A[j] ← A[j-1]; A[j-1] ← t
#(where t is a temporary variable),
#a slightly faster version can be produced that moves A[i] to its position in one go
#and only performs one assignment in the inner loop body

#Pseudokoden blir da:
#for i = 1 to length(A)
#    x = A[i]
#    j = i - 1
#    while j >= 0 and A[j] > x
#        A[j+1] = A[j]
#        j = j - 1
#    end while
#    A[j+1] = x
# end for



usortert=[5,3,1,2,4]

tabellengde=len(usortert)
print(usortert)

#Denne algoritmen tar en gradvis økende seleksjon for alle verdier i en tabell og sammenligner de med verdiene relativt til venstre for seg. 
#Den vil dernest flytte tallene med større verdi enn sammenligningsgrunnlaget til høyre. 
#Denne prosessen gjentas for alle tallverdiene utenom den aller første fra venstre slik at vi påser at alle tall blir sammenlignet. 
#Forskjellen mellom denne og Innstikksortering - v2021 er at Innstikksortering - v2021 bytter verdiene, mens denne bare skriver ny posisjon 
#for tallet vårt når den har funnet endelig posisjon. Dette begrenser antall operasjoner noe. 

#for alle verdier av i in spennet 1 til lengden av tabellen
for i in range(1,tabellengde,1):
    #x får verdien til tabellen i posisjonen usortert av i, heretter omtalt som 'kortet vårt' 
    x=usortert[i]
    #j får verdien en mindre enn i
    j=i-1
    
    #så lenge j er større enn 0, og usortert av j er mindre enn usortert av i.
    #dvs: Vi sjekker om kortet til venstre er større enn kortet vårt, og at det faktisk finnes et kort til venstre. 
    while j>=0 and usortert[j]>x:
        #Hvis det er tilfelle flyttes det større kortet en posisjon til høyre.  
        usortert[j+1]=usortert[j]
        #vi gjør j en mindre slik at vi kan sammenligne kortet vårt mot kortet til venstre for det. 
        j=j-1
    #Når vi ikke lenger finner ett kort som er større så 'låser' vi verdien på kortet vårt i rett posisjon.     
    usortert[j+1]=x
       
print(usortert)    

#The new inner loop shifts elements to the right to clear a spot for x = A[i]
