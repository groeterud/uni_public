public class Firmareise extends Reise{
    private String firmanavn;
    private String kontaktperson;

    public Firmareise(int reisenummer, String avreise, String hjemkomst, Destinasjon destinasjon, String firmanavn, String kontaktperson) {
        super(reisenummer, avreise, hjemkomst, destinasjon);
        this.firmanavn = firmanavn;
        this.kontaktperson = kontaktperson;
    }

    @Override
    public String toString() {
        return super.toString()+"Firmareise{" +
                "firmanavn='" + firmanavn + '\'' +
                ", kontaktperson='" + kontaktperson + '\'' +
                '}';
    }
}
