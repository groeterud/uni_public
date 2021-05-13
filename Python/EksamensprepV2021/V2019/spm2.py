hundefil=open('hund.txt','r',encoding='utf-8')

hundeID=hundefil.readline()

hunder=[]

while hundeID!='':
    hundeID.rstrip('\n')
    navn_hund=hundefil.readline().rstrip('\n')
    rase_hund=hundefil.readline().rstrip('\n')
    eier=hundefil.readline().rstrip('\n')
    startDato=hundefil.readline().rstrip('\n')

    hunder+=[[navn_hund,rase_hund]]

    hundeID=hundefil.readline()

hundefil.close()

for x in range(0,len(hunder)):
    print ('\nNavn:\t',hunder[x][0])
    print ('Rase:\t',hunder[x][1])
    





