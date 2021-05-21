from os import dup
from tkinter import *
from tkinter import messagebox
from sqlHandler import SqlHandler

db=SqlHandler('localhost',3306,'Bilsjef','eksamen2020','Bildeling')
def lagre_seleksjon(e):
    seleksjon=lbox.get(lbox.curselection())
    global regnr
    regnr=seleksjon[0]

def sjekk_duplikat(mobilnr):
    duplikat=False
    resultat=db.qry(
        '''
        SELECT Mobilnr
        FROM UTleie 
        WHERE Innlevert is null
        '''
    )
    for row in resultat:
        if row[0]==mobilnr:
            duplikat=True
    return duplikat

def hent_km():
    qry_str='''
        SELECT MAX(kmInn)
        FROM Utleie
        WHERE Regnr=%s
        '''
    resultat=db.qry(qry_str,(regnr,))
    for row in resultat:
        kmUt=row[0]
    print(kmUt)
    return kmUt

def lagre():
    mobilnr=mobilnr_SV.get()
    duplikat=sjekk_duplikat(mobilnr)
    km_stand=hent_km()
    if duplikat==False:
        db.qry('''
        INSERT INTO Utleie VALUES 
        (%s,CURRENT_TIMESTAMP,%s,%s,NULL,NULL,NULL)
        ''',(regnr,km_stand,mobilnr))

        #bdDatabase.commit()
    else:
        messagebox.showerror('Feil','Mobilnummeret har allerede utestående utleie på seg.')
          
ledige_biler=[]

#Finner ledige biler
resultat=db.qry('''
SELECT Regnr, Merke, Modell
FROM Bil
WHERE Regnr NOT IN (
    SELECT Regnr
    FROM Utleie
    WHERE Innlevert IS NULL
)
''')

for row in resultat:
    ledige_biler+=[row]

## UI 
window=Tk()

#labelframes
lb_lf=LabelFrame(window,text='Ledige biler')
lb_lf.grid(row=0,column=0,padx=5,pady=5)

lb_input=LabelFrame(window,text='Brukerinfo')
lb_input.grid(row=0,column=1,padx=5,pady=5)

btn_avslutt=Button(window,text='Avslutt',width=10,command=window.destroy)
btn_avslutt.grid(row=1,column=1)

#listebox
y_scroll=Scrollbar(lb_lf,orient=VERTICAL)
y_scroll.grid(row=0,column=1,rowspan=5,padx=(0,20),pady=5,sticky=NS)

innhold_lbox=StringVar()
lbox=Listbox(lb_lf,width=50, height=5, listvariable=innhold_lbox,yscrollcommand=y_scroll.set)
lbox.grid(column=0,row=0,padx=5,pady=5)
innhold_lbox.set(ledige_biler)

y_scroll["command"]=lbox.yview
lbox.bind("<<ListboxSelect>>",lagre_seleksjon)

#input
mobilnr_label=Label(lb_input,text='Mobilnr:')
mobilnr_label.grid(column=0,row=0,padx=5,pady=5,sticky=W)

mobilnr_SV=StringVar()
mobilnr_ent=Entry(lb_input,width=11,textvariable=mobilnr_SV)
mobilnr_ent.grid(column=1,row=0,padx=5,pady=5,sticky=W)

btn_lagre=Button(lb_input,width=7,text='Lagre',command=lagre)
btn_lagre.grid(column=1,row=1,padx=5,pady=5,sticky=SE)

window.mainloop()