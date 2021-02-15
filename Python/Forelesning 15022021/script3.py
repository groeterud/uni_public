#liste med scrollbar, to uavhengige komponenter som knyttes sammen. 
#i tillegg skal det vises ekstra informasjon når en velger i lista. 
from tkinter import *


#henter tilhørende epost til den ansatte som har blitt selektert
def hent_epost(event):
    #finner seleksjon
    valgt=lst_ansatte.get(lst_ansatte.curselection())

    funnet=False
    radnr=0
    #finner eposten tilhørende seleksjon
    while (funnet==False) and (radnr<=len(ansatte)-1):
        if valgt==ansatte[radnr][0]:
            #setter eposten i text-feltet tilhørende seleksjon
            epost_til.set(ansatte[radnr][2])
            funnet=True
        else:
            radnr+=1


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



#tkinter
window=Tk()
window.title('Ansatte')

#legger til vertikal scrollbar
y_scroll=Scrollbar(window,orient=VERTICAL)
y_scroll.grid(row=0,column=2,rowspan=5,padx=(0,100),pady=5,sticky=NS)

#lager en listeboks.
innhold_i_lst_ansatte=StringVar()   
                                                                                #oppdaterer scrollbar om vi bruker scrollehjulet i vinduet
lst_ansatte=Listbox(window,width=10,height=5,listvariable=innhold_i_lst_ansatte,yscrollcommand=y_scroll.set)
lst_ansatte.grid(row=0,column=1,rowspan=5,padx=(100,0),pady=5,sticky=E)
#hiver fornavn lista inn i listeboksen
innhold_i_lst_ansatte.set(tuple(fornavn))

#knytter opp scrollbaren til listeboksen, oppdaterer vinduet om vi endrer på scrollbare
y_scroll["command"]=lst_ansatte.yview

#lager text-felt
epost_til=StringVar()
ent_epost=Entry(window,width=30,state='readonly',textvariable=epost_til)
ent_epost.grid(row=0,column=3,sticky=E)

#trigger hent_epost() når noe er selektert i listeboksen. 
lst_ansatte.bind("<<ListboxSelect>>",hent_epost)

#initierer GUI
window.mainloop()