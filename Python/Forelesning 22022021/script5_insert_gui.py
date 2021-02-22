#innsetting av data i database fra Python
#innsetting ved verdiene 'rett i cursoren'

import mysql.connector
from tkinter import *

#koble mot db
mindatabase=mysql.connector.connect(host='localhost',
                                    port=3306,
                                    user='Lagersjefen2021',
                                    passwd='lagerpw',
                                    db='heltnydatabase')

#oppretter cursoren / markøren
settinn_markor=mindatabase.cursor()
markor=mindatabase.cursor()

#bruke databasen
varenrn=input('Oppgi varenr: ')
varenavn=input('Betegnelse: ')
pris=float(input('Hvor mye koster varen?: '))
katNr=int(input('Oppgi kategorinummer: '))
antall=int(input('Oppgi antall: '))
hylle=input('Oppgi hylleplassering: ')

sett_inn_vare=("INSERT INTO VARE"
    "(Vnr,Betegnelse,Pris,Katnr,Antall,Hylle)"
    "VALUES(%s,%s,%s,%s,%s,%s)"
    )
data_ny_vare = (varenrn,varenavn,pris,katNr,antall,hylle)

settinn_markor.execute(sett_inn_vare,data_ny_vare)

mindatabase.commit()

markor.close()
settinn_markor.close()
mindatabase.close()


window=Tk()
window.title('Oppdater database')


lbl_vnr=Label(window,text='Varenr:')
lbl_vnr.grid(row=0,column=0,padx=5,pady=5,sticky=E)

vnr_sv=StringVar()
ent_vnr=Entry(window,width=5,textvariable=vnr_sv)
ent_vnr.grid(row=0,column=1,padx=5,pady=5,sticky=W)


lbl_bet=Label(window,text='Betegnelse:')
lbl_bet.grid(row=1,column=0,padx=5,pady=5,sticky=E)

betegnelse_sv=StringVar()
ent_bet=Entry(window,width=30,textvariable=betegnelse_sv)
ent_bet.grid(row=1,column=1,padx=5,pady=5,sticky=W)


lbl_pris=Label(window,text='Pris:')
lbl_pris.grid(row=2,column=0,padx=5,pady=5,sticky=E)

pris_sv=StringVar()
ent_pris=Entry(window,width=11,textvariable=pris_sv)
ent_pris.grid(row=2,column=1,padx=5,pady=5,sticky=W)


lbl_katnr=Label(window,text='Kategori #')
lbl_katnr.grid(row=3,column=0,padx=5,pady=5,sticky=E)

katnr_sv=StringVar()
ent_katnr=Entry(window,width=2,textvariable=katnr_sv)
ent_katnr.grid(row=3,column=1,padx=5,pady=5,sticky=W)


lbl_antall=Label(window,text='Antall')
lbl_antall.grid(row=4,column=0,padx=5,pady=5,sticky=E)

