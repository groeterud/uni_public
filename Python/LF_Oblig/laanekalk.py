class LaaneKalkulator:
    def __init__(self,egenkap,inntekt,kjopesum) -> None:
        self.__egenkap=egenkap
        self.__inntekt=inntekt
        self.__kjopesum=kjopesum
        self.__laanesum=kjopesum-self.__egenkap
    
    def get_egenkap(self):
        return self.__egenkap
    def get_inntekt(self):
        return self.__inntekt
    def get_kjopesum(self):
        return self.__kjopesum
    def set_kjopesum(self,kjopesum):
        self.__kjopesum=kjopesum
        self.__laanesum=self.__kjopesum-self.__egenkap
        
    def set_egenkap(self,egenkap):
        self.__egenkap=egenkap
    def set_inntekt(self,inntekt):
        self.__inntekt=inntekt

    def get_laanesum(self):
        return self.__laanesum
    
    def inntekt_limit(self) -> bool:
        if self.__laanesum<self.__inntekt*5:
            return True
        return False

    def check_egenkap(self):
        if self.__egenkap>=self.__laanesum*0.15:
            return True
        return False


    def eval(self) -> bool:
        if self.inntekt_limit():
            if self.check_egenkap():
                return True
        return False

    def __str__(self) -> str:
        return f"""
        Lånesum: {self.__laanesum}\n
        Egenkapital: {self.__egenkap}\n
        Inntekt: {self.__inntekt}\n
        Kjøpesum: {self.__kjopesum}
        """