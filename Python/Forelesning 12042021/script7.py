#Bankkonto 

#Flere objekter/instanser av samme klasse, her: "kontoene til flere personer"

#BankKonto-klassen simulerer en bankkonto 

class BankKonto:
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
        
def main():
    #oppgi startsaldo på konto for kari
    saldo=1_273_000.69

    #Opprett et bankkonto objekt for Kari 
    karis_konto=BankKonto(saldo)

    #startsaldo på konto for knut
    saldo=2_750_321.31

    #knut's konto
    knuts_konto=BankKonto(saldo)

    print('Kari sin saldo:\t',karis_konto.hent_saldo())

    print('Knut sin saldo:\t',knuts_konto.hent_saldo())

    #utjevn balansen. 
    delta=knuts_konto.hent_saldo()-karis_konto.hent_saldo()
    karis_konto.innskudd(delta)
    
    print('Kari sin saldo:\t',karis_konto.hent_saldo())

    print('Knut sin saldo:\t',knuts_konto.hent_saldo())





main()