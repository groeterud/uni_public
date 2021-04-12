#Objektorientert tilnærming

#Program for brukerbestemt antall myntkast og opptelling av antall Krone og antall Mynt

#Skjulte/Private attributter 
#Vi bør sikre oss at det bare er metodene til objektet som kan endre /aksessere attributtene/instansevariablene
#Slik det er nå kan kode i main endre verdier på attributer til objektet / dvs "jukse i spillet".

#For å sikre oss at annen kode ikke kan endre/korruptere verdier på objektets data-attributter 
#Gjør vi attributtene private, dvs det er bare objektets metoder som har direkte tilgang til attributtene. 
#I python gjøres det ved å starte attributt-navnet med 2 __ / underscore 


#Hvor metoder håndterer egenskaper ved mynten
# og programlogikken/apillet ligger i main()

# 1. Skriver inn import random
# 2. Lager main, og så def main()
# 3. Oppretter myntobjekt
# 4. Lager klassene
# 5. referere til objektet
# 6. Lager ny def, som punkt 5 skal bruke
# 7. Lager en ny input
# 8. lager for-løkke
# 9. Lager ny def, kast-metoden (samme som i program 120421-1)
# 10. Bruker sideopp og kastmetoden til å gi ut et svar
# 11. Teller opp mynt kastes / opptelling gjennomføres, skriver til slutt en print fro å gi ut antallet av hver

#1. 
import random

#4.
# Mynt-klassen simulerer en mynt og hva vi kan gjøre med den... KLASSER SKAL HA STOR FORBOKSTAV!!!
class Mynt:
    #__init__ metoden initierer objektet/forekomsten/instansen
    #og tilordner sideopp-attributtet fra input
    # det vil si: setter en startverdi som ikke skal telles med
    def __init__(self):
        #oppgi "myntside opp" før første kast.
        self.__sideopp=input('Hvilken side på mynten er opp før første kast? ')

    #9
    #Kast-metoden simulerer et kast med mynten
    #Og gir sideopp attributtet ny verdi
    def kast(self):
        # finnes bare 2 alternativer:   Kron/Mynt  altså  0/1
        if random.randint(0,1)==0:
            self.__sideopp='Krone'
        else:
            self.__sideopp='Mynt'

    # 6.
    #hent_sideopp metoden returnerer til enhver tid
    #Verdien/("siste verdi") på mynten, dvs verdien i sideopp-attributtet
    def hent_sideopp(self):
        return self.__sideopp

# 2.
def main():
    antall_kron=0
    antall_mynt=0

    #3. Oppretter et mynt-objekt, en forekomst/instanse
    min_mynt=Mynt()

    # 5.
    print('Før første kast er denne siden opp:',min_mynt.hent_sideopp())

    # 7. 
    antall_kast=int(input('Hvor mange ganger skal mynten kastes? '))

    #8.
    for antall_ganger in range(1,antall_kast+1,1):
        #Mynten kastes
        min_mynt.kast()

        #10.
        print('Resultat av kast nr ',antall_ganger, 'ble', min_mynt.hent_sideopp())

        #11.
        if min_mynt.hent_sideopp() == 'Krone':
            antall_kron=antall_kron + 1
        else:
            antall_mynt=antall_mynt + 1
    print('Resultat av forsøksrekka ble', antall_kron, 'Krone og', antall_mynt, 'Mynt')

# 2.
main()