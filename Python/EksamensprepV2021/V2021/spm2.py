## ta alt fra bruker.txt inn i 2d liste og print fornavn + etternavn 

f=open('Bilder.txt','r',encoding='utf-8')

bildeID=f.readline()

bilder={}

while bildeID!='':
    bildeID=bildeID.rstrip('\n')
    beskrivelse=f.readline().rstrip('\n')
    opplastdato=f.readline().rstrip('\n')
    fotograf=f.readline().rstrip('\n')

    bilder[bildeID]={
        'beskrivelse':beskrivelse,
        'opplastdato':opplastdato,
        'fotograf':fotograf
    }

    bildeID=f.readline()
f.close()

for bildeID in bilder:
    print()
    print('Beskrivelse:\t',bilder[bildeID]['beskrivelse'])
    print('Fotograf:\t',bilder[bildeID]['fotograf'])