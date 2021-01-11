#i/o feil
#verdi-feil 

#legg inn filhandteringa lokalt i den funksjonen som skal gjøre arbeidsoppgaven 


#eksempel på kode som kan throwe errors tilknytta io/value 
studentFil=open('studentoblig99.txt','r')
#eksemplifisert kode 
alle_studenter=studentFil.read()
print(alle_studenter)
studentFil.close()

