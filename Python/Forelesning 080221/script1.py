vare=[]
print(vare)

varefil=open('Varer.txt','r',encoding='utf-8')


vnr=varefil.readline()

while vnr!='':
    vnr=vnr.rstrip('\n')
    betegnelse=varefil.readline().rstrip('\n)')
    kategori=varefil.readline().rstrip('\n)')
    hylle=varefil.readline().rstrip('\n)')
    vare+=[[vnr,betegnelse,kategori,hylle]]
    vnr=varefil.readline()

varefil.close()

antall_poster=len(vare)

print('antall poster:',antall_poster)

for x in range(antall_poster):
    print(vare[x][1],'Hylle:',vare[x][3])
print()


#fjerner varer som ikke har hyller, og gir bare første tegnet
#[0:1] slicing fungerer på samme måte som range; fra og med -> til. IKKE TIL OG MED.
for x in range(antall_poster):
    if vare[x][3] != 'NULL':
        print(vare[x][1],'Hylleseksjon:',vare[x][3][0:1])
print()

#skriver ut alle varer og hylleseksjon, tar ikke med varer som ikke er hylleplassert.
#slicingen gjøres på en variable for bedre oversikt
print('Varer og hylleseksjon')

for r in range(antall_poster):
    if vare[r][3] != 'NULL':
        hylle=vare[r][3]
        print(vare[r][1],'hører til hyllseksjon',hylle[0:1])

print()

#test på innhold i streng
#varer i kat for blomser
c=2
for r in range(antall_poster):
    if "BLOMST" in vare[r][c]:
        print(vare[r][c-1],'i kategorien',vare[r][c])
print()


#case-sensitivitet
c=2
for r in range(antall_poster):
    if "blomst" in vare[r][c]:
        print(vare[r][c-1],'i kategorien',vare[r][c])
print()


#generalisert, søkekriteriet som inndata
sokekrit=input('Oppgi vertype det skal søkes på: ')
c=2
for r in range(antall_poster):
    if sokekrit.upper() in vare[r][c-1].upper():
        print(vare[r][c-1],'i kategorien',vare[r][c])
print()