package LambdaDemo;

public class LambdaDemo {
    public static void main(String[] args) {
        //Lager en kalkulator for addisjon:
        Kalkulator addisjon = (a, b) -> a + b;

        //lager en kalkulator for substraksjon
        Kalkulator subtraksjon = (a,b) -> a-b;

        //lager en kalkulator for multiplikasjon
        Kalkulator multiplikasjon = (a,b) -> a*b;

        //lager en kalkulator for divisjon
        Kalkulator divisjon = (a,b) -> a/b;

        //Bruker kalulatorerne
        System.out.println("Addisjon: " + addisjon.operasjon(7,2)+"\n");
        System.out.println("Subtraksjon: " + subtraksjon.operasjon(7,2)+"\n");
        System.out.println("Multiplikasjon "+ multiplikasjon.operasjon(7,2)+"\n");
        System.out.println("Divisjon: " + divisjon.operasjon(7,2)+"\n");
    }
}
