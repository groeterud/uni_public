kunder={}
source_file=open('kunde.txt','r',encoding='utf-8')

mobilnr=source_file.readline()

while mobilnr!='':
    mobilnr=mobilnr.rstrip('\n')
    fornavn=source_file.readline().strip('\n')
    etternavn=source_file.readline().strip('\n')
    BankKortNr=source_file.readline().strip('\n')
            
    kunder[mobilnr]={
        'Fornavn':fornavn,
        'Etternavn':etternavn,
        'BankKortNr':BankKortNr,
    }
    
    mobilnr=source_file.readline()
source_file.close()

again=True

while again:
    mobilnr=input('Vennligst skriv inn mobilnr på kunde: ')
    if mobilnr in kunder:
        print ('\nFornavn:\t',kunder[mobilnr]['Fornavn'])
        print ('Etternavn:\t',kunder[mobilnr]['Etternavn'],'\n')
    else:
        print('Fant ikke oppføringen')

    go_again=input('Søke opp flere kunder? (y/n): ')
    if go_again=='n':
        again=False