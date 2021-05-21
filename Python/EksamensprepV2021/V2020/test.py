from sqlHandler import SqlHandler

db=SqlHandler('localhost',3306,'Bilsjef','eksamen2020','Bildeling')

sporring=db.qry(
        '''
        SELECT *
        FROM UTleie 
        '''
    )

print(sporring)

