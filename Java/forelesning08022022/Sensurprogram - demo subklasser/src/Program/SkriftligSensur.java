package Program;

public class SkriftligSensur extends Sensur{
    public final int GRENSE = 10;
    public final double FAKTOR1 = 0.15;
    public final double FAKTOR2 = 0.1;

    private double lengde; //lengde på eksamen
    private int antallBesvarelser;

    public SkriftligSensur(String fag, String eksamenstype, double lengde, int antallBesvarelser) {
        super(fag, eksamenstype);
        this.lengde = lengde;
        this.antallBesvarelser = antallBesvarelser;
    }

    @Override
    public double beregnTidsforbruk() {
        //Oppretter en variabel som skal returneres
        double antallTimer = FORBEREDELSE;
        if (antallBesvarelser<=GRENSE) {
            antallTimer+=antallBesvarelser*lengde*FAKTOR1;
        }
        else {
            antallTimer+=FAKTOR1*lengde*GRENSE + (antallBesvarelser-GRENSE)*lengde*FAKTOR2;
        }

        return antallTimer;
    }

    @Override
    public String toFile() {
        return "S,"+super.toFile()+","+lengde+","+antallBesvarelser;
    }
}
