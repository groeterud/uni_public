class Ajourhold:
    #__init__ metoden tar imot et argument for saldo 
    # det blir tilordnet saldo-attributtet 
    def __init__(self,saldo):
        self.__saldo=saldo
    
    #innskudd, setter et innskudd inn på konto
    def innskudd(self,belop):
        self.__saldo=self.__saldo+belop
    
    # uttak metoden, foretar et uttak på konto hvis nok penger
    def uttak(self,belop):
        if self.__saldo>=belop:
            self.__saldo=self.__saldo-belop
        else:
            print('Manglende dekningsgrunnlag på konto, vennligst prøv senere')
    
    #hent_saldo metoden returnerer saldoen på kontoen. 
    def hent_saldo(self):
        return self.__saldo