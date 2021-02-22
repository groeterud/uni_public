# Prinsipper for å håndtere database

import mysql.connector

#1. Koble mot databasen

mindatabase=mysql.connector.connect(host='localhost',
                                    port=3306,
                                    user='Lagersjefen2021',
                                    passwd='lagerpw',
                                    db='heltnydatabase')

#2. Opprette cursor/markør
markor=mindatabase.cursor()

#3. Bruke databasen
markor.execute("SELECT * FROM Vare")


#4 bruke resultatet
for row in markor:
    print(row)

#5 koble ned databasen, cursoren stenges etter bruk, koblingen stenges ved programslutt.
markor.close()
mindatabase.close()
