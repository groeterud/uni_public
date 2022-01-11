package LenketListe;

public class TestKlient {
    public static void main(String[] args) {
        LenketListe<String> lenke = new LenketListe<String>();
        lenke.settInnFørst("Arne");
        lenke.settInnFørst("Går mot døra");
        lenke.settInnFørst("Tenker tanker han");
        lenke.settInnFørst("Har tenkt tusen ganger");
        lenke.settInnFørst("Fra føraaa");

        System.out.println(lenke.toString());
    }
}
