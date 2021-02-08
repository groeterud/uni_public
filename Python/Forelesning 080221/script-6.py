#Listebokskomponenten
#lese data fra fil til tabell og legger deler av tabellen i en ny liste som vises i en listeboks.
#Det er flere elementer i lista enn det som vises.
#Mulig å scrolle i lista, men ingen indikasjon på det. 

from tkinter import *

#oppretter global liste som er tom
ansatte=[]
ansattfil=open('laerer.txt','r',encoding='utf-8')

fornavn=ansattfil.readline()

while fornavn!='':
    fornavn=fornavn.rstrip('\n')
    etternavn=ansattfil.readline().strip('\n')
    epost=ansattfil.readline().strip('\n')
    
    ansatte+=[[fornavn,etternavn,epost]]
    
    fornavn=ansattfil.readline()

ansattfil.close()


#lager fornavnlista fra tabellen
fornavn=[]
for r in range(len(ansatte)):
    fornavn+=[ansatte[r][0]]

#lager etternavnlista fra tabellen
etternavn=[]
for r in range(len(ansatte)):
    etternavn+=[ansatte[r][1]]

epost=[]
for r in range(len(ansatte)):
    epost+=[ansatte[r][2]]


window=Tk()
window.title('Ansatte')

innhold_i_lst_ansatte=StringVar()
lst_ansatte=Listbox(window,width=10,height=5,listvariable=innhold_i_lst_ansatte)
lst_ansatte.grid(padx=100,pady=5)

innhold_i_lst_ansatte.set(tuple(fornavn))

window.mainloop()