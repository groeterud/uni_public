class LaaneKalkulator:
    def __init__(self,egenkap,inntekt) -> None:
        self.__egenkap=egenkap
        self.__inntekt=inntekt
    
    def get_egenkap(self):
        return self.__egenkap
    def get_inntekt(self):
        return self.__inntekt
    def set_egenkap(self,egenkap):
        self.__egenkap=egenkap
    def set_inntekt(self,inntekt):
        self.__inntekt=inntekt
    
    def inntekt_limit(self) -> bool:
        if self.__inntekt<self.__inntekt*5:
            return False
        return True

    def eval(self) -> bool:
        if inntekt_limit():
            pass