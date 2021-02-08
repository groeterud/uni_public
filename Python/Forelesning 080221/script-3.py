#oppretter en tom dict
ansatte={}
print(ansatte)

ansattfil=open('laerer.txt','r',encoding='utf-8')

fornavn=ansattfil.readline()

while fornavn!='':
    fornavn=fornavn.rstrip('\n')
    etternavn=ansattfil.readline().strip('\n')
    epost=ansattfil.readline().strip('\n')
    #legger inn i dict, alt #1
    #ansatte[fornavn+' '+etternavn]=epost
    #legger values inn i dict som liste:
    #ansatte[epost]=[fornavn,etternavn]
    #legger inn slik foreleser vil
    ansatte[fornavn]=[etternavn,epost]
    fornavn=ansattfil.readline()

ansattfil.close()

#print(ansatte)

#skriv ut alle nøkler og deler av opplysningene, nøkkel og e-post.
for key in ansatte:
    print(key,ansatte[key][1])
    