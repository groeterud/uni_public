import mysql.connector
from tkinter import *
from tkinter import messagebox
import traceback

def hent_pris_lager(event):
    try:
        valgt=lst_varer.get(lst_varer.curselection())
        
        pris_lager_markor=mindatabase.cursor()

        pris_lager_markor.execute('SELECT Betegnelse,Pris,Antall FROM Vare')

        funnet=False
        iterator=0
        rader=pris_lager_markor.fetchall()

        while (funnet==False) and (iterator<=len(rader)):
            if valgt==rader[iterator][0]:
                pris.set(rader[iterator][1])
                lager.set(rader[iterator][2])
                funnet=True
            iterator+=1

        pris_lager_markor.close()
    except:
        listbox_suger=True

def update_listbox():
    try:
        updt_markor=mindatabase.cursor(buffered=True)
        updt_markor.execute('SELECT * FROM Vare')
        ny_varer=updt_markor.fetchall()
        i=len(ny_varer)
        lst_varer.delete(0,END)
        for x in range(0,i):
            lst_varer.insert(END,ny_varer[x][1])
        updt_markor.close()

    except:
        print(traceback.format_exc())
        print(ny_varer)

def slett_valgt_vare():
    valgt=lst_varer.get(lst_varer.curselection())
    valgt=str(valgt)
    ans=messagebox.askyesno(title="Bekreft",
                            message='Er du helt sikker på at du vil slette \n'+valgt)

    del_markor=mindatabase.cursor()

    if ans:
        del_markor.execute("DELETE FROM Vare WHERE Betegnelse=%s",(valgt,))
        mindatabase.commit()
        update_listbox()

    del_markor.close()


    
def alt_gikk_bra(data):
    messagebox.showinfo('Vellykket','Følgende data ble lagret!:'+str(data))
    update_listbox()

def noe_gikk_galt(data):
    messagebox.showerror('Feil','Kunne ikke lagre følgende data:'+str(data))

def legg_til_vindu():
    def lagre():
        #oppretter cursoren / markøren
        settinn_markor=mindatabase.cursor()
        
        #bruke databasen
        varenrn=vnr_sv.get()
        varenavn=betegnelse_sv.get()
        pris=float(pris_sv.get())
        katNr=int(katnr_sv.get())
        antall=int(antall_sv.get())
        hylle=hylle_sv.get()

        sett_inn_vare=("INSERT INTO VARE"
            "(Vnr,Betegnelse,Pris,Katnr,Antall,Hylle)"
            "VALUES(%s,%s,%s,%s,%s,%s)"
            )
        data_ny_vare = (varenrn,varenavn,pris,katNr,antall,hylle)

        try:
            settinn_markor.execute(sett_inn_vare,data_ny_vare)
            mindatabase.commit()
            alt_gikk_bra(data_ny_vare)
            legg_til_window.destroy()
        except:
            noe_gikk_galt(data_ny_vare)
            legg_til_window.destroy()

        settinn_markor.close()    


    legg_til_window=Toplevel()
    legg_til_window.title('Legg til ny vare')


    lbl_vnr_top=Label(legg_til_window,text='Varenr:')
    lbl_vnr_top.grid(row=0,column=0,padx=5,pady=5,sticky=E)

    vnr_sv=StringVar()
    ent_vnr_top=Entry(legg_til_window,width=5,textvariable=vnr_sv)
    ent_vnr_top.grid(row=0,column=1,padx=5,pady=5,sticky=W)


    lbl_bet_top=Label(legg_til_window,text='Betegnelse:')
    lbl_bet_top.grid(row=1,column=0,padx=5,pady=5,sticky=E)

    betegnelse_sv=StringVar()
    ent_bet_top=Entry(legg_til_window,width=30,textvariable=betegnelse_sv)
    ent_bet_top.grid(row=1,column=1,padx=5,pady=5,sticky=W)


    lbl_pris_top=Label(legg_til_window,text='Pris:')
    lbl_pris_top.grid(row=2,column=0,padx=5,pady=5,sticky=E)

    pris_sv=StringVar()
    ent_pris_top=Entry(legg_til_window,width=11,textvariable=pris_sv)
    ent_pris_top.grid(row=2,column=1,padx=5,pady=5,sticky=W)


    lbl_katnr_top=Label(legg_til_window,text='Kategori #')
    lbl_katnr_top.grid(row=3,column=0,padx=5,pady=5,sticky=E)

    katnr_sv=StringVar()
    ent_katnr_top=Entry(legg_til_window,width=2,textvariable=katnr_sv)
    ent_katnr_top.grid(row=3,column=1,padx=5,pady=5,sticky=W)


    lbl_antall_top=Label(legg_til_window,text='Antall:')
    lbl_antall_top.grid(row=4,column=0,padx=5,pady=5,sticky=E)

    antall_sv=StringVar()
    ent_antall_top=Entry(legg_til_window,width=5,textvariable=antall_sv)
    ent_antall_top.grid(row=4,column=1,padx=5,pady=5,sticky=W)


    lbl_hylle=Label(legg_til_window,text='Hylleplassering:')
    lbl_hylle.grid(row=5,column=0,padx=5,pady=5,sticky=E)

    hylle_sv=StringVar()
    ent_hylle=Entry(legg_til_window,width=3,textvariable=hylle_sv)
    ent_hylle.grid(row=5,column=1,padx=5,pady=5,sticky=W)

    btn_lagre=Button(legg_til_window,text='Lagre',width=20,command=lagre)
    btn_lagre.grid(row=6,column=0,columnspan=2,padx=5,pady=(15,5),sticky=E)


def oppdater_vare():
    valgt=lst_varer.get(lst_varer.curselection())
    valgt=str(valgt)
    def oppdater():
        #oppretter cursoren / markøren
        settinn_markor=mindatabase.cursor()
        
        #bruke databasen
        varenrn=vnr_updt_sv.get()
        varenavn=betegnelse_updt_sv.get()
        pris=float(pris_updt_sv.get())
        katNr=int(katnr_updt_sv.get())
        antall=int(antall_updt_sv.get())
        hylle=hylle_updt_sv.get()

        oppdater_vare=("UPDATE VARE SET VNr=%s,Betegnelse=%s,Pris=%s,KatNr=%s,Antall=%s,Hylle=%s WHERE Betegnelse=%s")
        data_ny_vare = (varenrn,varenavn,pris,katNr,antall,hylle,valgt)

        try:
            settinn_markor.execute(oppdater_vare,data_ny_vare)
            mindatabase.commit()
            messagebox.showinfo('Vellykket','Dette gikk strålende')
            oppdater_window.destroy()
            update_listbox()
        except:
            messagebox.showerror('Feil','Kunne ikke lagre dataene, prøv igjen')
            oppdater_window.destroy()

        settinn_markor.close()   

    def hent_eksisterende():
        for x in range(0,len(varer)):
            if varer[x]==valgt:
                vnr_updt_sv.set(tabell[x][0])
                betegnelse_updt_sv.set(tabell[x][1])
                pris_updt_sv.set(tabell[x][2])
                katnr_updt_sv.set(tabell[x][3])
                antall_updt_sv.set(tabell[x][4])
                hylle_updt_sv.set(tabell[x][5])
    


    oppdater_window=Toplevel()
    oppdater_window.title('Oppdater vare')


    lbl_vnr_updt=Label(oppdater_window,text='Varenr:')
    lbl_vnr_updt.grid(row=0,column=0,padx=5,pady=5,sticky=E)

    vnr_updt_sv=StringVar()
    ent_vnr_updt=Entry(oppdater_window,width=5,textvariable=vnr_updt_sv)
    ent_vnr_updt.grid(row=0,column=1,padx=5,pady=5,sticky=W)


    lbl_bet_updt=Label(oppdater_window,text='Betegnelse:')
    lbl_bet_updt.grid(row=1,column=0,padx=5,pady=5,sticky=E)

    betegnelse_updt_sv=StringVar()
    ent_bet_updt=Entry(oppdater_window,width=30,textvariable=betegnelse_updt_sv)
    ent_bet_updt.grid(row=1,column=1,padx=5,pady=5,sticky=W)


    lbl_pris_updt=Label(oppdater_window,text='Pris:')
    lbl_pris_updt.grid(row=2,column=0,padx=5,pady=5,sticky=E)

    pris_updt_sv=StringVar()
    ent_pris_updt=Entry(oppdater_window,width=11,textvariable=pris_updt_sv)
    ent_pris_updt.grid(row=2,column=1,padx=5,pady=5,sticky=W)


    lbl_katnr_updt=Label(oppdater_window,text='Kategori #')
    lbl_katnr_updt.grid(row=3,column=0,padx=5,pady=5,sticky=E)

    katnr_updt_sv=StringVar()
    ent_katnr_updt=Entry(oppdater_window,width=2,textvariable=katnr_updt_sv)
    ent_katnr_updt.grid(row=3,column=1,padx=5,pady=5,sticky=W)


    lbl_antall_updt=Label(oppdater_window,text='Antall:')
    lbl_antall_updt.grid(row=4,column=0,padx=5,pady=5,sticky=E)

    antall_updt_sv=StringVar()
    ent_antall_updt=Entry(oppdater_window,width=5,textvariable=antall_updt_sv)
    ent_antall_updt.grid(row=4,column=1,padx=5,pady=5,sticky=W)


    lbl_hylle=Label(oppdater_window,text='Hylleplassering:')
    lbl_hylle.grid(row=5,column=0,padx=5,pady=5,sticky=E)

    hylle_updt_sv=StringVar()
    ent_hylle=Entry(oppdater_window,width=3,textvariable=hylle_updt_sv)
    ent_hylle.grid(row=5,column=1,padx=5,pady=5,sticky=W)

    #btn_hent=Button(oppdater_window,text='Hent verdier',width=20,command=hent_eksisterende)
    #btn_hent.grid(row=6,column=0,columnspan=2,padx=5,pady=(15,5),sticky=E)

    btn_lagre=Button(oppdater_window,text='Lagre',width=20,command=oppdater)
    btn_lagre.grid(row=7,column=0,columnspan=2,padx=5,pady=(15,5),sticky=E)

    hent_eksisterende()

    

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
tabell=vare_markor.fetchall()
#4. Bruke resultatet.
varer=[]
for row in tabell:
    varer+=[row[1]]

#GUI
window=Tk()
window.title('LagerMaster v0.5')

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

btn_slett=Button(window,text='Slett valgt vare',width=20,command=slett_valgt_vare)
btn_slett.grid(row=2,column=3,columnspan=2,padx=5,pady=5,sticky=E)

#TBA
btn_oppdater=Button(window,text='Oppdater valgt vare',width=20,command=oppdater_vare)
btn_oppdater.grid(row=3,column=3,columnspan=2,padx=5,pady=5,sticky=E)

btn_lagre=Button(window,text='Legg til ny vare',width=20,command=legg_til_vindu)
btn_lagre.grid(row=8,column=3,columnspan=2,padx=5,pady=(15,5),sticky=E)


window.mainloop()

vare_markor.close()
mindatabase.close()