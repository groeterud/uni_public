// abstract = kan ikke instansiere denne klassen, bare subklasser.
public abstract class Kjøretøy {
    private String regnr;
    private String fabrikant;
    public Kjøretøy (String regnr, String fabrikant) {
        this.regnr = regnr;
        this.fabrikant=fabrikant;
    }

    public String getRegnr() {
        return regnr;
    }

    public String getFabrikant() {
        return fabrikant;
    }

    @Override
    public String toString() {
        return "Kjøretøy{" +
                "regnr='" + regnr + '\'' +
                ", fabrikant='" + fabrikant + '\'' +
                '}';
    }
}
