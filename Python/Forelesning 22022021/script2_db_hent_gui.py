import mysql.connector
from tkinter import *

def hent_pris_lager(event):
    valgt=lst_varer.get(lst_varer.curselection())
    
    pris_lager_markor=mindatabase.cursor()

    pris_lager_markor.execute('SELECT Betegnelse,Pris,Antall FROM Vare')

    funnet=False
    radnr=0
    #Finne riktig pris og varebeholdning
    #prøv selv; While løkke
    
    for row in pris_lager_markor:
        if valgt==row[0]:
            pris.set(row[1])
            lager.set(row[2])
        
    pris_lager_markor.close()


#koble opp til db
mindatabase=mysql.connector.connect(host='localhost',
                                    port=3306,
                                    user='Lagersjefen2021',
                                    passwd='lagerpw',
                                    db='heltnydatabase')

#2. Opprette cursor/markør
vare_markor=mindatabase.cursor()

#3. Bruke databasen
vare_markor.execute('SELECT * FROM Vare')

#4. Bruke resultatet.
varer=[]
for row in vare_markor:
    varer+=[row[1]]

#GUI
window=Tk()
window.title('Varer')

y_scroll=Scrollbar(window,orient=VERTICAL)
y_scroll.grid(row=0,column=2,rowspan=10,padx=(0,100),pady=5,sticky=NS)

innhold_i_lst_varer=StringVar()
lst_varer=Listbox(window,width=50,height=10,listvariable=innhold_i_lst_varer,yscrollcommand=y_scroll.set)
lst_varer.grid(row=0,column=1,rowspan=10,padx=(100,0),pady=5,sticky=E)

innhold_i_lst_varer.set(tuple(varer))

y_scroll['command']=lst_varer.yview

lbl_pris=Label(window,text='Prisen er:')
lbl_pris.grid(row=0,column=3,padx=5,pady=5,sticky=E)

lbl_lager=Label(window,text='Lagerbeholdning:')
lbl_lager.grid(row=1,column=3,padx=5,pady=5,sticky=E)

pris=StringVar()
ent_pris=Entry(window,width=8,state='readonly',textvariable=pris)
ent_pris.grid(row=0,column=4,padx=5,pady=5,sticky=W)

lager=StringVar()
ent_lager=Entry(window,width=6,state='readonly',textvariable=lager)
ent_lager.grid(row=1,column=4,padx=5,pady=5,sticky=W)

lst_varer.bind('<<ListboxSelect>>',hent_pris_lager)

window.mainloop()

vare_markor.close()
mindatabase.close()