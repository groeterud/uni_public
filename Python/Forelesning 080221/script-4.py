#oppretter en tom dict
ansatte={}
ansattfil=open('laerer.txt','r',encoding='utf-8')

fornavn=ansattfil.readline()

while fornavn!='':
    fornavn=fornavn.rstrip('\n')
    etternavn=ansattfil.readline().strip('\n')
    epost=ansattfil.readline().strip('\n')
    #legger inn i dict
    #fornavn som key på øverste nivå
    #og etternavn og e-post i ny dic, med egne key'er 
    
    ansatte[fornavn]={'etternavn':etternavn,'e-post':epost}
    
    fornavn=ansattfil.readline()

ansattfil.close()

#print(ansatte)

#skriv ut all info om gunnar
print(ansatte['Gunnar'])
print()

#skrive ut bare e-post
print(ansatte['Gunnar']['e-post'])
print()

#skrive ut alle eposter
for key in ansatte:
    print(ansatte[key]['e-post'])