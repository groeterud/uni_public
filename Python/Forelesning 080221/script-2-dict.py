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
navn=input('Oppgi navn på kontakten ')
if navn in kontakter:
    print(navn,'har telefonnr',kontakter[navn])
else:
    print('Kontakten',navn,'finnes ikke')
