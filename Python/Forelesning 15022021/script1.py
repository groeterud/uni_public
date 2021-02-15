#eksempel på bruk av command-attributtet
from tkinter import *

def bytt_farge():
    if btn_byttFarge['fg']=='blue':
        btn_byttFarge['fg']='red'
    else:
        btn_byttFarge['fg']='blue'


vindu=Tk()
vindu.title('Knapp for fargevalg')

btn_byttFarge=Button(vindu,text='Bytt farge',fg='blue',command=bytt_farge)
btn_byttFarge.grid(padx=75,pady=15)

vindu.mainloop()

