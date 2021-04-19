class Student:
    def __init__(self,studentnr,fornavn,etternavn,epost,studium):
        self.__studentnr=studentnr
        self.__fornavn=fornavn
        self.__etternavn=etternavn
        self.__epost=epost
        self.__studium=studium
    
    def get_studentnr(self):
        return self.__studentnr
    def get_fornavn(self):
        return self.__fornavn
    def get_etternavn(self):
        return self.__etternavn
    def get_epost(self):
        return self.__epost
    def get_studium(self):
        return self.__studium
    
    def set_studentnr(self,studentnr):
        self.__studentnr=studentnr
    def set_fornavn(self,fornavn):
        self.__fornavn=fornavn
    def set_etternavn(self,etternavn):
        self.__etternavn=etternavn
    def set_epost(self,epost):
        self.__epost=epost
    def set_studium(self,studium):
        self.__studium=studium

    def __str__(self) -> str:
        return "\nStudentnr: "+self.__studentnr + "\nNavn: " + self.__fornavn +' '+ self.__etternavn + "\nE-post: " + self.__epost + "\nStudium: " + self.__studium +"\n"