#eksempel med bruk av bind
from tkinter import *

#entry har ikke command-argument, her må vi bruke bind-metoten, og en parater
#i funksjonen, kaller parameterern for event, knyttet til en handling. 

def bytt_farge(event):
    if ent_navn['fg']=='blue':
        ent_navn['fg']='red'
    else:
        ent_navn['fg']='blue'

vindu=Tk()
vindu.title('Inndatafelt og fargevalg')

ent_navn=Entry(vindu,fg='blue')
ent_navn.grid(padx=100,pady=15)
ent_navn.bind('<Button-3>',bytt_farge)


vindu.mainloop()