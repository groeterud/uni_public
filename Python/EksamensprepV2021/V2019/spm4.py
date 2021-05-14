from tkinter import *

hundefil=open('hund.txt','r',encoding='utf-8')

hundeID=hundefil.readline()

hunder=[]

hunder_id=[]

while hundeID!='':
    hundeID=hundeID.rstrip('\n')
    navn_hund=hundefil.readline().rstrip('\n')
    navn_hund.replace('{','').replace('}','')
    rase_hund=hundefil.readline().rstrip('\n')
    eier=hundefil.readline().rstrip('\n')
    startDato=hundefil.readline().rstrip('\n')

    hunder+=[[hundeID,navn_hund]]
    hunder_id+=[hundeID,eier]

    hundeID=hundefil.readline()

hundefil.close()

#sorter
for i in range(len(hunder)):
    for x in range(len(hunder)-i-1):
        if hunder[x][1] > hunder[x+1][1]:
            hunder[x],hunder[x+1]=hunder[x+1],hunder[x]


def finn_eier(e):
    eierfil=open('kunde.txt','r',encoding='utf-8')

    mobilnr=eierfil.readline()

    eierliste=[]

    while mobilnr!='':
        mobilnr=mobilnr.rstrip('\n')
        fornavn=eierfil.readline().rstrip('\n')
        etternavn=eierfil.readline().rstrip('\n')
        bankKortNr=eierfil.readline().rstrip('\n')
    
        eierliste+=[[mobilnr,fornavn,etternavn]]

        mobilnr=eierfil.readline()

    eierfil.close()

    valgt=lbox_hunder.get(lbox_hunder.curselection())

    for x in range(len(hunder_id)):
        if valgt[0]==hunder_id[x]:
            for i in range(len(eierliste)):
                if hunder_id[x+1]==eierliste[i][0]:
                    lbl_eier_fornavn['text']=eierliste[i][1]
                    lbl_eier_etternavn['text']=eierliste[i][2]

## GUI 
window=Tk()
window.title='Hundeliste'

lf_hunder=LabelFrame(window,text='Hunder')
lf_hunder.grid(column=0,row=0,padx=5,pady=5)

y_scroll=Scrollbar(lf_hunder,orient=VERTICAL)
y_scroll.grid(row=0,column=1,rowspan=5,padx=(0,20),pady=5,sticky=NS)

innhold_lbox_hunder=StringVar()
lbox_hunder=Listbox(lf_hunder,width=50, height=5, listvariable=innhold_lbox_hunder,yscrollcommand=y_scroll.set)
lbox_hunder.grid(column=0,row=0,padx=5,pady=5)
innhold_lbox_hunder.set(hunder)

y_scroll["command"]=lbox_hunder.yview
lbox_hunder.bind("<<ListboxSelect>>",finn_eier)

lf_eier=LabelFrame(window,text='Eier')
lf_eier.grid(column=1,row=0,padx=5,pady=5, sticky=N)

lbl_eier_fornavn=Label(lf_eier,text='Fornavn')
lbl_eier_etternavn=Label(lf_eier,text='Etternavn')

lbl_eier_fornavn.grid(column=0,row=0,padx=5,pady=5,sticky=W)
lbl_eier_etternavn.grid(column=0,row=1,padx=5,pady=5,sticky=W)


btn_exit=Button(window,width=10,text='Avslutt',command=window.destroy)
btn_exit.grid(column=1,row=1,padx=5,pady=5)

window.mainloop()