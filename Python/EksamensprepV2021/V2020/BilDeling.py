class Bil:
    def __init__(self,regnr,merke,modell,startdato,posisjon):
        self.__regnr=regnr
        self.__merke=merke
        self.__modell=modell
        self.__startdato=startdato
        self.__posisjon=posisjon
    def set_regnr(self,regnr):
        self.__regnr=regnr
    def set_merke(self,merke):
        self.__merke=merke
    def set_modell(self,modell):
        self.__modell=modell
    def set_startdato(self,startdato):
        self.__startdato=startdato
    def set_posisjon(self,posisjon):
        self.__posisjon=posisjon
    def get_regnr(self):
        return self.__regnr
    def get_merke(self):
        return self.__merke
    def get_modell(self):
        return self.__modell
    def get_startdato(self):
        return self.__startdato
    def get_posisjon(self):
        return self.__posisjon

class Kunde:
    def __init__(self,mobilnr,fornavn,etternavn,betalingskortnr):
        self.__mobilnr=mobilnr
        self.__fornavn=fornavn
        self.__etternavn=etternavn
        self.__betalingskortnr=betalingskortnr
    def set_mobilnr(self,mobilnr):
        self.__mobilnr=mobilnr
    def set_fornavn(self,fornavn):
        self.__fornavn=fornavn
    def set_etternavn(self,etternavn):
        self.__etternavn=etternavn
    def set_betalingskortnr(self,betalingskortnr):
        self.__betalingskortnr=betalingskortnr
    def get_mobilnr(self):
        return self.__mobilnr
    def get_fornavn(self):
        return self.__fornavn
    def get_etternavn(self):
        return self.__etternavn
    def get_betalingskortnr(self):
        return self.__betalingskortnr
    
class Utleie:
    def __init__(self,regnr,utlevert,kmUt,mobilnr,innlevert,kmInn,belop):
        self.__regnr=regnr
        self.__utlevert=utlevert
        self.__kmUt=kmUt
        self.__mobilnr=mobilnr
        self.__innlevert=innlevert
        self.__kmInn=kmInn
        self.__belop=belop
    def set_regnr(self,regnr):
        self.__regnr=regnr
    def set_utlevert(self,utlevert):
        self.__utlevert=utlevert
    def set_kmUt(self,kmUt):
        self.__kmUt=kmUt
    def set_mobilnr(self,mobilnr):
        self.__mobilnr=mobilnr
    def set_innlevert(self,innlevert):
        self.__innlevert=innlevert
    def set_kmInn(self,kmInn):
        self.__kmInn=kmInn
    def set_belop(self,belop):
        self.__belop=belop
    def get_regnr(self):
        return self.__regnr
    def get_utlevert(self):
        return self.__utlevert
    def get_kmUt(self):
        return self.__kmUt
    def get_mobilnr(self):
        return self.__mobilnr
    def get_innlevert(self):
        return self.__innlevert
    def get_kmInn(self):
        return self.__kmInn
    def get_belop(self):
        return self.__belop

