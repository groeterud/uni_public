from typing import List
import mysql.connector
from tkinter import *

db=mysql.connector.connect(host='localhost',port=3306,user='Bildesjef',passwd='eksamen2020',db='Bildedeling')

def finn_eier(evt):
    valgt=lbox.get(lbox.curselection())

    eier_markor=db.cursor()

    eier_markor.execute('''
        SELECT Fornavn,Etternavn
        FROM Bruker
        WHERE BrukerID IN (
            SELECT Fotograf
            FROM Bilde
            WHERE BildeID=%s
        )
    ''',(valgt[0],)
    )
    for row in eier_markor:
        fornavn_lbl['text']=row[0]
        etternavn_lbl['text']=row[1]
    
    eier_markor.close()

bilde_markor=db.cursor()

bilde_markor.execute('''
SELECT *
FROM Bilde
''')

bilder=[]

for row in bilde_markor:
    bilder+=[[row[0],row[1]]]

bilde_markor.close()


window=Tk()
window.title('Fotgrafinfo')

lf_lbox=LabelFrame(window)
lf_lbox.grid(row=0,column=0,padx=5,pady=5)

lf_fotograf=LabelFrame(window,text='Fotograf')
lf_fotograf.grid(row=0,column=1,padx=5,pady=5)

btn_avslutt=Button(window,text='Avslutt',width=10,command=window.destroy)
btn_avslutt.grid(row=1,column=1,padx=5,pady=(20,5),sticky=SE)

y_scroll=Scrollbar(lf_lbox,orient=VERTICAL)
y_scroll.grid(row=0,column=1,rowspan=5,padx=(0,20),pady=5,sticky=NS)

innhold_lbox=StringVar()
lbox=Listbox(lf_lbox,width=50,height=5,listvariable=innhold_lbox,yscrollcommand=y_scroll.set)
lbox.grid(column=0,row=0,padx=5,pady=5)
innhold_lbox.set(bilder)
y_scroll['command']=lbox.yview
lbox.bind('<<ListboxSelect>>',finn_eier)

fornavn_lbl=Label(lf_fotograf,text='Fornavn')
fornavn_lbl.grid(row=0,column=0,padx=5,pady=5,sticky=W)

etternavn_lbl=Label(lf_fotograf,text='Etternavn')
etternavn_lbl.grid(row=1,column=0,padx=5,pady=5,sticky=W)

window.mainloop()