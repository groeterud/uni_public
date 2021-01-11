def studenter():
    try:
        studentFil=open('studentoblig99.txt','r')

        #skrive ut alle studenter eksemplifisert med enkel innlesing og utskrift av innholdet på studentfila. 
        alle_studenter=studentFil.read()
        print(alle_studenter)
        studentFil.close()
    except IOError:
        print('Vennligst påse at filnavnet eksisterer')
    except:
        print('Noe gikk galt')

studenter()