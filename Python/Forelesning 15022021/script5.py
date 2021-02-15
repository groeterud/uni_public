#grunnstruktur
#lager med komponentene ledetekst, inndatafelt, utdatafelt

from tkinter import *


def beregn_lan():
    if int(egenkap.get())/int(kjopesum.get())>=0.35:
        tilsagn.set('Lån kan innvilges')
    else:
        tilsagn.set('Lån kan ikke innvilges')

#lag nytt vindu
window=Tk()

#gir vinduet et navn
window.title('Lånekalkulator billån')

#ledetekster/labels
kjopesum=StringVar()
lbl_kjopesum=Label(window,text='Kjøpesum:')
lbl_kjopesum.grid(row=0,column=0, padx=10, pady=5, sticky=E)

ent_kjopesum=Entry(window,width=9,textvariable=kjopesum)
ent_kjopesum.grid(row=0,column=1,padx=10,pady=5, sticky=W)

egenkap=StringVar()
lbl_egenkap=Label(window,text='Egenkapital:')
lbl_egenkap.grid(row=1,column=0, padx=10, pady=5, sticky=E)

ent_egenkap=Entry(window,width=9,textvariable=egenkap)
ent_egenkap.grid(row=1,column=1,padx=10,pady=5, sticky=W)

btn_beregn=Button(window,text='Beregn',width=15,command=beregn_lan)
btn_beregn.grid(row=2,column=1,pady=5,padx=10,sticky=W)

lbl_tilsagn=Label(window,text='Tilsagn på lån:')
lbl_tilsagn.grid(row=3,column=0, padx=10, pady=5, sticky=E)

tilsagn=StringVar()
tilsagn_output=Entry(window,width=20,state='readonly',textvariable=tilsagn)
tilsagn_output.grid(row=3,column=1,padx=10,pady=5,sticky=W)

btn_avslutt=Button(window, text='Avslutt', width=10,command=window.destroy)
btn_avslutt.grid(row=4,column=1,pady=(25,5),padx=5,sticky=SE)


#kjør metoden, mainloop som starter vindu
window.mainloop()