#liste med scrollbar, to uavhengige komponenter som knyttes sammen. 
#i tillegg skal det vises ekstra informasjon når en velger i lista. 
from tkinter import *


#henter tilhørende epost til den ansatte som har blitt selektert
def hent_epost(event):
    #finner seleksjon
    valgt=listebox_ansatte.get(listebox_ansatte.curselection())

    funnet=False
    radnr=0
    #finner eposten
    while (funnet==False) and (radnr<=len(ansatte)-1):
        if valgt==ansatte[radnr][0]:
            #setter eposten
            epost_til.set(ansatte[radnr][2])
            funnet=True
        else:
            radnr+=1


#oppretter global liste som er tom
ansatte=[]
ansattfil=open('laerer.txt','r',encoding='utf-8')

liste_med_fornavn=ansattfil.readline()

while liste_med_fornavn!='':
    liste_med_fornavn=liste_med_fornavn.rstrip('\n')
    etternavn=ansattfil.readline().strip('\n')
    epost=ansattfil.readline().strip('\n')
    
    ansatte+=[[liste_med_fornavn,etternavn,epost]]
    
    liste_med_fornavn=ansattfil.readline()

ansattfil.close()

#lager fornavnlista fra tabellen
liste_med_fornavn=[]
for r in range(len(ansatte)):
    liste_med_fornavn+=[ansatte[r][0]]



#tkinter
window=Tk()
window.title('Ansatte')

y_scroll=Scrollbar(window,orient=VERTICAL)
y_scroll.grid(row=0,column=2,rowspan=5,padx=(0,100),pady=5,sticky=NS)

innhold_i_lst_ansatte=StringVar()
listebox_ansatte=Listbox(window,width=10,height=5,listvariable=innhold_i_lst_ansatte,yscrollcommand=y_scroll.set)
listebox_ansatte.grid(row=0,column=1,rowspan=5,padx=(100,0),pady=5,sticky=E)

innhold_i_lst_ansatte.set(tuple(liste_med_fornavn))

y_scroll["command"]=listebox_ansatte.yview

epost_til=StringVar()
ent_epost=Entry(window,width=30,state='readonly',textvariable=epost_til)
ent_epost.grid(row=0,column=3,sticky=E)
listebox_ansatte.bind("<<ListboxSelect>>",hent_epost)

window.mainloop()