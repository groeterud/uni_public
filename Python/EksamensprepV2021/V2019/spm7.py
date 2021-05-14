class Hund:
    def __init__(self,hundeID='',hundenavn='',rase='',eier='',startdato=''):
        self.__hundeID=hundeID
        self.__hundenavn=hundenavn
        self.__rase=rase
        self.__eier=eier
        self.__startdato=startdato
    def set_hundeID(self,hundeID):
        self.__hundeID=hundeID
    def set_hundenavn(self,hundenavn):
        self.__hundenavn=hundenavn
    def set_rase(self,rase):
        self.__rase=rase
    def set_eier(self,eier):
        self.__eier=eier
    def set_startdato(self,startdato):
        self.__startdato=startdato
    def get_hundeID(self):
        return self.__hundeID
    def get_hundenavn(self):
        return self.__hundenavn
    def get_rase(self):
        return self.__rase
    def get_eier(self):
        return self.__eier
    def get_startdato(self):
        return self.__startdato
    def __str__(self) -> str:
        return '\n ID:'+self.__hundeID+'\tNavn:'+self.__hundenavn+'\tRase:'+self.__rase+'\tEier:'+self.__eier+'\tstartdato:'+self.__startdato

