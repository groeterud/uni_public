##pseudo
#1 finn ledige biler
#2 gui
#3 Listebox selection
#4 Legg inn mobilnr
#5 Se om mobilnr = bad
#6 snurr film 

#1: 
'''
SELECT Regnr
FROM Bil
WHERE Regnr NOT IN (
    SELECT Regnr
    FROM Utleie
    WHERE Innlevert IS NULL) AS derp
)
'''

#5 
'''
SELECT Mobilnr
FROM Utleie
WHERE Innlevert is null
'''
bad=False

for row in markor:
    if row[0]==mobilnr_inn:
        bad=True


if bad:
    raise Exception
else:
    print('INSERT INTO')