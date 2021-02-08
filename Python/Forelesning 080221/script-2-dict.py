#oppretter dicten
kontakter={
    'Kari':12345678,
    'Ola':87654321,
    'Knut':41123321,
    'Lise':12334567,
}

#for å hente ut en verdi fra dict'en oppgir du nøkkelen
#NB! case-sensitiv

print(kontakter['Ola'])
print()


#dersom nøkkel ikke finnes, termineres programmet
#print(kontakter['Tullballiversen'])
#det kan vi løse med å teste om kontakten finnes via in-operatoren. 

if 'Tullballiversen' in kontakter:
    print(kontakter['Tullballiversen'])
else:
    print('Kontakten "Tullballiversen" finnes ikke')

#alt 2
''' 
try:
    print(kontakter['Tullballiversen'])

except KeyError:
    print('Nøkkelen finnes ikke my dude')
'''
#søkekriteriet som inndata
'''
navn=input('Oppgi navn på kontakten ')
if navn in kontakter:
    print(navn,'har telefonnr',kontakter[navn])
else:
    print('Kontakten',navn,'finnes ikke')
'''

#print av alle nøkler med verdier i en for-løkke
for key in kontakter:
    print(key,kontakter[key])
print()


#
#legge til kontakt
'''
navn=input('Oppgi navn: ')
tlfnr=int(input('Oppgi telefonnummer: '))

kontakter[navn]=tlfnr

print('kvittering')
print(navn,'sitt tlf nr er',kontakter[navn])
print()
print('Hele lista:')
print(kontakter)
print()
#dersom key-value finnes fra før vil dete bli en overskriving/nytt tlfnr
'''

#slette kontakt
'''
navn=input('Oppgi navn på kontakten som skal slette: ')
if navn in kontakter:
    print('funnet')
    del kontakter[navn]
    print(kontakter)
else:
    print('ikke funnet')
'''


