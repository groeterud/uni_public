''' 
kjapp oppsummering av oppgaven tildelt 11012021
anse dette som foreleser sin gjennomgang, og min notering av dette.
'''

def beregn_gjsnitt():
    summen=0
    antall=0

    tall_fil=open('Tall.txt','r')

    tallnr=tall_fil.readline()

    while tallnr != '':
        
        tall=int(tall_fil.readline())
        summen+=tall
        antall+=1

        tallnr=tall_fil.readline()
    
    tall_fil.close()
    
    print()
    print('Summen er:',summen)
    print('Dte er ',antall,'tall')
    gjennomsnitt=format((summen/antall),'.2f')
    print('Gjennomsnittet av tallene er:',gjennomsnitt)

beregn_gjsnitt()