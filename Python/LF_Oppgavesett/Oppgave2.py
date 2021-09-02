'''Oppgave 2
Et bilutleiefirma tilbyr følgende alternativer for dagsleie av leiebil:
1. fastpris 750 kr
2. fastpris 300 kr og 2 kr pr kjørt km
3. fastpris 150 kr og 4 kr pr kjørt km

Kunden må velge et av alternativene ved inngåelse av leiekontrakten.
Lag et program som sammenligner de tre alternativene ut fra antall km som inndata, og avgjør hvilket alternativ som er best for kunden.'''

antall_km=int(input("Hvor mange km: "))

FASTPRIS=750
FASTPRIS_2=300+(2*antall_km)
FASTPRIS_3=150+(4*antall_km)

print("Prismodell 1:",FASTPRIS)
print("Prismodell 2:",FASTPRIS_2)
print("Prismodell 3:",FASTPRIS_3)