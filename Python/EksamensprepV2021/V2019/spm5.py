from tkinter import *
from datetime import date



EIERFIL='kunde.txt'
HUNDEFIL='hund.txt'

def lagre():
    eier_mobil=eier_mobil_SV.get()
    eier_fornavn=eier_fornavn_SV.get()
    eier_etternavn=eier_etternavn_SV.get()
    eier_bankkort=eier_bankkort_SV.get()

    hund_navn=hund_navn_SV.get()
    hund_rase=hund_rase_SV.get()

    f=open(EIERFIL,'a')
    f.write(eier_mobil+'\n')
    f.write(eier_fornavn+'\n')
    f.write(eier_etternavn+'\n')
    f.write(eier_bankkort+'\n')

    f.close()

    f=open(HUNDEFIL,'r')
    hoyeste=0
    hundeID=f.readline()
    while hundeID!='':
        hoyeste=int(hundeID.rstrip('\n'))
        hnavn=f.readline()
        hrase=f.readline()
        heier=f.readline()
        hdato=f.readline()

        hundeID=f.readline()
    f.close()

    hundeID=str(hoyeste+1)
    today=date.today()
    today=today.strftime('%Y-%m-%d')

    f=open(HUNDEFIL,'a',encoding='utf-8')
    f.write(hundeID+'\n')
    f.write(hund_navn+'\n')
    f.write(hund_rase+'\n')
    f.write(eier_mobil+'\n')
    f.write(today+'\n')

    f.close()

    



##GUI
window=Tk()
window.title='Registrer ny kunde med hund'

lbl_eier_mobil=Label(window,text='Mobilnr')
lbl_eier_mobil.grid(column=0,row=0,padx=5,pady=5,sticky=W)

eier_mobil_SV=StringVar()
ent_eier_mobil=Entry(window,width=11,textvariable=eier_mobil_SV)
ent_eier_mobil.grid(column=1,row=0,padx=5,pady=5,sticky=W)

lbl_eier_fornavn=Label(window,text='Fornavn')
lbl_eier_fornavn.grid(column=0,row=1,padx=5,pady=5,sticky=W)

eier_fornavn_SV=StringVar()
ent_eier_fornavn=Entry(window,width=20,textvariable=eier_fornavn_SV)
ent_eier_fornavn.grid(column=1,row=1,padx=5,pady=5,sticky=W)

lbl_eier_etternavn=Label(window,text='Etternavn')
lbl_eier_etternavn.grid(column=0,row=2,padx=5,pady=5,sticky=W)

eier_etternavn_SV=StringVar()
ent_eier_etternavn=Entry(window,width=20, textvariable=eier_etternavn_SV)
ent_eier_etternavn.grid(column=1,row=2,padx=5,pady=5,sticky=W)

lbl_eier_bankkort=Label(window,text='Bankkort')
lbl_eier_bankkort.grid(column=0,row=3,padx=5,pady=5,sticky=W)

eier_bankkort_SV=StringVar()
ent_eier_bankkort=Entry(window,width=16,textvariable=eier_bankkort_SV)
ent_eier_bankkort.grid(column=1,row=3,padx=5,pady=5,sticky=W)

lbl_hund_navn=Label(window,text='Navn på hund')
lbl_hund_navn.grid(column=0,row=4,padx=5,pady=5,sticky=W)

hund_navn_SV=StringVar()
ent_hund_navn=Entry(window,width=20,textvariable=hund_navn_SV)
ent_hund_navn.grid(column=1,row=4,padx=5,pady=5,sticky=W)

lbl_hund_rase=Label(window,text='Rase')
lbl_hund_rase.grid(column=0,row=5,padx=5,pady=5,sticky=W)

hund_rase_SV=StringVar()
ent_hund_rase=Entry(window,width=30,textvariable=hund_rase_SV)
ent_hund_rase.grid(column=1,row=5,padx=5,pady=5,sticky=W)


btn_lagre=Button(window,text='Lagre',width=7,command=lagre)
btn_lagre.grid(column=0,row=6,padx=5,pady=5,sticky=SW)

btn_avslutt=Button(window,text='Avslutt',width=10,command=window.destroy)
btn_avslutt.grid(column=1,row=6,padx=5,pady=5,sticky=SE)

window.mainloop()