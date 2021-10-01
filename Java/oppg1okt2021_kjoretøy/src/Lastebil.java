public class Lastebil extends Kjøretøy{
    private int lastekapasitet;

    public Lastebil(String regnr, String produsent, String modell, int regÅr, int lastekapasitet) {
        super(regnr, produsent, modell, regÅr);
        this.lastekapasitet = lastekapasitet;
    }

    public int getLastekapasitet() {
        return lastekapasitet;
    }

    public void setLastekapasitet(int lastekapasitet) {
        this.lastekapasitet = lastekapasitet;
    }
}
