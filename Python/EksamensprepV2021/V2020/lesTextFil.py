class LesTextFil:
    def __init__(self,filename,numrows):
        self.__filename=filename
        self.__numrows=numrows
    
    def set_filename(self,filename):
        self.__filename=filename
    
    def get_filename(self):
        return self.__filename
    
    def set_numrows(self,numrows):
        self.__numrows=numrows
    
    def get_numrows(self):
        return self.__numrows
    
    def file_to_2d_list(self):
        f=open(self.__filename,'r')

        fList=[]
        templist=[]
        line=f.readline()

        while line!='':
            line=line.rstrip('\n')
            templist+=[line]
            for x in range(1,self.__numrows):
                line=f.readline().rstrip('\n')
                templist+=[line]
            fList+=[templist]
            templist=[]
            line=f.readline()
        
        f.close()
        return fList


                

    