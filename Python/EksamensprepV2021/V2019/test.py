def pluss(tall1,tall2):
    resultat=tall1+tall2
    
    return resultat



resultatliste=[]

for x in range(0,10):
    resultat=pluss(x,10)
    resultatliste+=[resultat]

print (resultatliste)

