#innsetting av data i database fra Python
#innsetting ved verdiene 'rett i cursoren'

import mysql.connector

#koble mot db
mindatabase=mysql.connector.connect(host='localhost',
                                    port=3306,
                                    user='Lagersjefen2021',
                                    passwd='lagerpw',
                                    db='heltnydatabase')

#oppretter cursoren / markøren
settinn_markor=mindatabase.cursor()
markor=mindatabase.cursor()

#bruke databasen
settinn_markor.execute("INSERT INTO VARE"
    "(Vnr,Betegnelse,Pris,Katnr,Antall,Hylle)"
    "VALUES('9999','Testvare',99.99,999,99,'T99')"
    )

mindatabase.commit()

settinn_markor.execute("INSERT INTO VARE"
    "(Vnr,Betegnelse,Pris,Katnr,Antall,Hylle)"
    "VALUES('8888','Endaentestvare',88.88,888,88,'T88')"
    )

mindatabase.commit()

markor.execute('SELECT * FROM Vare')

for row in markor:
    print(row)



markor.close()
settinn_markor.close()
mindatabase.close()