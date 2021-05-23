## ta alt fra bruker.txt inn i 2d liste og print fornavn + etternavn 

f=open('Bruker.txt','r')

brukerId=f.readline()

brukere=[]

while brukerId!='':
    brukerId=brukerId.rstrip('\n')
    fornavn=f.readline().rstrip('\n')
    etternavn=f.readline().rstrip('\n')
    epost=f.readline().rstrip('\n')

    brukere+=[[brukerId,fornavn,etternavn,epost]]

    brukerId=f.readline()
f.close()

for x in range(len(brukere)):
    print()
    print('Fornavn:\t',brukere[x][1])
    print('Etternavn:\t',brukere[x][2])