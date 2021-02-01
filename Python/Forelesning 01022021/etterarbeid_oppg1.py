def liste_fra_fil(filnavn):
    fil=open(filnavn,encoding='utf-8')

    fornavn=fil.readline()
    liste=[]

    while fornavn!='':
        liste+=[fornavn.rstrip('\n')]
        fornavn=fil.readline()

    fil.close()
    return(liste)



def bubble_sort_list(liste):
    i=0
    while i !=len(liste):
        for n in range(0,(len(liste)-1)-i):   #kudos til @terje for den -i'en der asså! 
            if liste[n]>=liste[n+1]:
                storste_tall=liste[n]
                liste[n]=liste[n+1]
                liste[n+1]=storste_tall
        i+=1
    
    return(liste)
    
navneliste=liste_fra_fil('fornavn.txt')

print('Usortert navneliste',navneliste)

navneliste=bubble_sort_list(navneliste)

print('Sortert navneliste',navneliste)