from os import truncate


try:
    tallFil=open('tullballiversen.txt','r')
    sum=0
    tall=tallFil.readline()
    feil=False
    while tall!='' and feil==False:
        try:
            tall=tall.rstrip('\n')
            tall=int(tall)
            sum=sum+tall
        except ValueError:
            print('Støtet feil tilknyttet verditype på datasettet. Sannsynligvis bokstav når programmet forventet tall')
            print('Avslutter summering. Summen så langt er:',sum)
            feil=True
        tall=tallFil.readline()
    if feil==False:
        print('Summen er:',sum)

except IOError:
    print('Du jeg fant ikke fila jeg')

