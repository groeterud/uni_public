public class Buss extends Kjøretøy{
    private int antallPlasser;

    public Buss(String regnr, String fabrikant, int antallPlasser) {
        super(regnr, fabrikant);
        this.antallPlasser = antallPlasser;
    }

    public int getAntallPlasser() {
        return antallPlasser;
    }

    public void setAntallPlasser(int antallPlasser) {
        this.antallPlasser = antallPlasser;
    }

    //Overstyre (override) superklassens toString()

    @Override
    public String toString() {
        return super.toString()+
                "Buss{" +
                "antallPlasser=" + antallPlasser +

                '}';
    }
}
