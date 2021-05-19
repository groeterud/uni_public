import mysql.connector
from tkinter import *
from BilDeling import Utleie,Kunde

def finn_eier(evt):
    valgt=lbox.get(lbox.curselection())

    for x in range(len(kunder)):
        if valgt[1]==kunder[x].get_mobilnr():
            lbl_fornavn['text']=kunder[x].get_fornavn()
            lbl_etternavn['text']=kunder[x].get_etternavn()

bdDatabase=mysql.connector.connect(host='localhost', port=3306, user='Bilsjef', passwd='eksamen2020', db='Bildeling')

#gjør det så baklengs som mulig her nå i starten.
utleiemarkor=bdDatabase.cursor()
utleiemarkor.execute('SELECT * FROM Utleie')

utleier=[]
for row in utleiemarkor:
    enkelt_utleie=Utleie(row[0],row[1],row[2],row[3],row[4],row[5],row[6])
    utleier+=[enkelt_utleie]
utleiemarkor.close()

kundemarkor=bdDatabase.cursor()
kundemarkor.execute('SELECT * FROM Kunde')

kunder=[]
for row in kundemarkor:
    enkelt_kunde=Kunde(row[0],row[1],row[2],row[3])
    kunder+=[enkelt_kunde]
kundemarkor.close()

#åpne utleier
open_utleie=[]
for enkelt_utleie in utleier:
    if enkelt_utleie.get_innlevert()==None:
        open_utleie+=[[enkelt_utleie.get_regnr(),enkelt_utleie.get_mobilnr()]]

## GUI 
window=Tk()
window.title='Utleie informasjon'

## Grunnstruktur
tb=LabelFrame(window,text='Tabell')
tb.grid(row=0,column=0,padx=5,pady=5)

lf_eier=LabelFrame(window,text='Eierinformasjon')
lf_eier.grid(row=0,column=1,padx=5,pady=5)

btn_avslutt=Button(window,text='Avslutt',width=10,command=window.destroy)
btn_avslutt.grid(row=1,column=1,padx=5,pady=(20,5),sticky=SE)

## tb info
y_scroll=Scrollbar(tb,orient=VERTICAL)
y_scroll.grid(row=0,column=1,rowspan=5,padx=(0,20),pady=5,sticky=NS)

innhold_lbox=StringVar()
lbox=Listbox(tb,width=50, height=5, listvariable=innhold_lbox,yscrollcommand=y_scroll.set)
lbox.grid(column=0,row=0,padx=5,pady=5)
innhold_lbox.set(open_utleie)

y_scroll["command"]=lbox.yview
lbox.bind("<<ListboxSelect>>",finn_eier)


##labels

lbl_fornavn=Label(lf_eier,text='Fornavn')
lbl_etternavn=Label(lf_eier,text='Etternavn')

lbl_fornavn.grid(row=0,column=0,sticky=W)
lbl_etternavn.grid(row=1,column=0,sticky=W)

window.mainloop()
