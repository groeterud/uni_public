from tkinter import *
from tkinter import messagebox
import mysql.connector

dogStore=mysql.connector.connect(host='localhost', port=3306, user='Hundesjef', passwd='eksamen2019', db='Dogstore')

def sok():
    # VI TRENGER: Hundenavn, Rase, Eier(mobilnr), Dagens dato (database, currentdate)
    def lagre():
        hundenavn=hundenavn_SV.get()
        hunderase=hunderase_SV.get()

        lagremarkor=dogStore.cursor()
        
        #forutsetter at hundeID er auto_increment 
        lagremarkor.execute('''
        INSERT INTO HUND (Hundenavn, Rase, Eier, Startdato) VALUES
        (%s,%s,%s,CURRENT_DATE)
        ''',(hundenavn,hunderase,mobilnr))

        lagremarkor.close()
        dogStore.commit()

        messagebox.showinfo('Vellykket!','Lagret informasjon om hunden')        

    ## KODE FOR Å FINNE INFJORMASJON OM EIER SOM VI KAN PRESENTERE
    mobilnr=mobilnr_SV.get()

    eiermarkor=dogStore.cursor()

    eiermarkor.execute('''
    SELECT Fornavn, Etternavn
    FROM Kunde
    WHERE Mobilnr=%s
    ''',(mobilnr,))

    for row in eiermarkor:
        fornavn=row[0]
        etternavn=row[1]
    
    eiermarkor.close()
    
    ## TOPLEVEL GUI
    tl=Toplevel()
    tl.title('Lagre hund på eier')

    eierinfo_lbl=Label(tl,text='Informasjon om eier')
    eierinfo_lbl.grid(row=0,column=0,columnspan=2,padx=5,pady=5)

    fornavn_sv=StringVar()
    fornavn_sv.set(fornavn)
    fornavn_ent=Entry(tl,width=20,textvariable=fornavn_sv,state='readonly')
    fornavn_ent.grid(row=1,column=0,padx=5,pady=5,sticky=W)

    etternavn_sv=StringVar()
    etternavn_sv.set(etternavn)
    etternavn_ent=Entry(tl,width=20,textvariable=etternavn_sv,stat='readonly')
    etternavn_ent.grid(row=1,column=1,padx=5,pady=5,sticky=W)
    
    hundenavn_lbl=Label(tl,text='Hundenavn:')
    hundenavn_lbl.grid(row=2,column=0,padx=5,pady=5,sticky=W)
    
    hundenavn_SV=StringVar()
    Hundenavn_ent=Entry(tl,width=20,textvariable=hundenavn_SV)
    Hundenavn_ent.grid(row=2,column=1,padx=5,pady=5,sticky=W)

    hunderase_lbl=Label(tl,text='Rase:')
    hunderase_lbl.grid(row=3,column=0,padx=5,pady=5,sticky=W)

    hunderase_SV=StringVar()
    hunderase_ent=Entry(tl,width=20,textvariable=hunderase_SV)
    hunderase_ent.grid(row=3,column=1,padx=5,pady=5,sticky=W)

    btn_avslutt=Button(tl,text='Avslutt',width=10,command=tl.destroy)
    btn_avslutt.grid(row=4,column=1,padx=5,pady=5,sticky=SE)

    btn_lagre=Button(tl,text='Lagre',width=7,command=lagre)
    btn_lagre.grid(row=4,column=0,padx=5,pady=5,sticky=SW)
    

## MAIN GUI
window=Tk()
window.title('Legg til ny hund')

mobilnr_lbl=Label(window,text='Mobilnr')
mobilnr_lbl.grid(row=0,column=0,padx=5,pady=5,sticky=W)

mobilnr_SV=StringVar()
mobilnr_ent=Entry(window,width=12,textvariable=mobilnr_SV)
mobilnr_ent.grid(row=0,column=1,padx=5,pady=5,sticky=W)

btn_sok=Button(window,text='Søk',width=5,command=sok)
btn_sok.grid(row=1,column=0,padx=5,pady=5,sticky=SW)

btn_avslutt=Button(window,text='Avslutt',width=10,command=window.destroy)
btn_avslutt.grid(row=1,column=1,padx=5,pady=5,sticky=SE)

window.mainloop()