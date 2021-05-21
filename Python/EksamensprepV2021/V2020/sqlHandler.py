from typing import List
import mysql.connector

class SqlHandler:
    def __init__(self,host,port,user,passwd,db):
        self.__host=host
        self.__port=port
        self.__user=user
        self.__passwd=passwd
        self.__db=db
        self.__database=mysql.connector.connect(host=self.__host,port=self.__port,user=self.__user,passwd=self.__passwd,db=self.__db)

    def qry(self,qry:str,opt=None) -> List:
        self.__markor=self.__database.cursor()
        if opt==None:
            self.__markor.execute(qry)
        else:
            self.__markor.execute(qry,opt)

        results=[]
        templist=[]
        for row in self.__markor:
            for x in range(len(row)):
                value=row[x]
                templist+=[value]    
            results+=[templist]
            templist=[]
        return results
