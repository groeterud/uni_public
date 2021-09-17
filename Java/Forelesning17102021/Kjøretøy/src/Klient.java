public class Klient {
    public static void main(String[] args) {
        Kontroll kontroll = new Kontroll();
        Trailer t = new Trailer("AC123456","MAN",25);
        kontroll.settInn(t);

        // mer kompakt metode.
        kontroll.settInn(new Buss("SV12345","VOLVO",50));

        Kjøretøy[] kjøretøy = kontroll.getKjøretøy();

        // utvidet for løkke for å gå gjennom og kaller objektenes toString()
        for (Kjøretøy k : kjøretøy) {
            if (k!=null) {
                System.out.println(k.toString());
            }
        }
    }
}
