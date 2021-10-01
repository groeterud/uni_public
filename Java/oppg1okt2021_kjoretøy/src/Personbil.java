public class Personbil extends Kjøretøy{
    private int antallPlasser;

    public Personbil(String regnr, String produsent, String modell, int regÅr, int antallPlasser) {
        super(regnr, produsent, modell, regÅr);
        this.antallPlasser = antallPlasser;
    }

    public int getAntallPlasser() {
        return antallPlasser;
    }

    public void setAntallPlasser(int antallPlasser) {
        this.antallPlasser = antallPlasser;
    }
}
