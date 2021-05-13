from tkinter import *
import mysql.connector
from datetime import date

dogStore=mysql.connector.connect(host='localhost', port=3306, user='Hundesjef', passwd='eksamen2019', db='Dogstore')

def ny_hund():
    def lagre():
        lagreMarkor=dogStore.cursor()
        qry='''
            INSERT INTO HUND (Hundenavn,Rase,Eier,Startdato) VALUES
            (%s,%s,%s,%s)
            '''
        today=date.today()
        today=today.strftime('%Y-%m-%d')
        data=(hund_rase_SV.get(),hund_rase_SV.get(),kunde_mobilnr_SV.get(),today)

        lagreMarkor.execute(qry,data)
        lagreMarkor.close()

    #GUI STUFF
    tl=Toplevel()
    tl.title('Informasjon om hund')
    lbl_hund_navn=Label(tl,text='Navn på hund')
    lbl_hund_navn.grid(column=0,row=0,padx=5,pady=5,sticky=W)

    hund_navn_SV=StringVar()
    ent_hund_navn=Entry(tl,width=20,textvariable=hund_navn_SV)
    ent_hund_navn.grid(column=1,row=0,padx=5,pady=5,sticky=W)

    lbl_hund_rase=Label(tl,text='Rase')
    lbl_hund_rase.grid(column=0,row=1,padx=5,pady=5,sticky=W)

    hund_rase_SV=StringVar()
    ent_hund_rase=Entry(tl,width=30,textvariable=hund_rase_SV)
    ent_hund_rase.grid(column=1,row=1,padx=5,pady=5, sticky=W)

    btn_avslutt=Button(tl,text='Avslutt',width=10,command=tl.destroy)
    btn_avslutt.grid(column=1,row=2,padx=5,pady=5,sticky=SE)

    btn_lagre=Button(tl,text='Lagre',width=7,command=lagre)
    btn_lagre.grid(column=0,row=2,padx=5,pady=5,sticky=SW)

#baseGUI

window=Tk()
window.title('Legg til ny hund')

lbl_kunde_mobilnr=Label(window,text='Mobilnr på kunde')
lbl_kunde_mobilnr.grid(column=0,row=0,padx=5,pady=5,sticky=W)

kunde_mobilnr_SV=StringVar()
ent_kunde_mobilnr=Entry(window,width=11,textvariable=kunde_mobilnr_SV)
ent_kunde_mobilnr.grid(column=1,row=0,padx=5,pady=5,sticky=W)

btn_sok=Button(window,width=5,text='Søk',command=ny_hund)
btn_sok.grid(column=0,row=1,padx=5,pady=5,sticky=SW)

btn_avslutt=Button(window,width=10,text='Avslutt',command=window.destroy)
btn_avslutt.grid(column=1,row=1,padx=5,pady=5,sticky=SE)

window.mainloop()