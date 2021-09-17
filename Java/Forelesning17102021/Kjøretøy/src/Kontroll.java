public class Kontroll {
    private Kjøretøy[] kjøretøy = new Kjøretøy[10];
    private int antall = 0;

    public void settInn(Kjøretøy etKjøretøy) {
        kjøretøy[antall]=etKjøretøy;
        antall++;
    }

    public Kjøretøy[] getKjøretøy() {
        return kjøretøy;
    }
}
