package Program;

public class ProsjektSensur extends Sensur{
    private final double PROSJEKTSENSUR = 8;
    private int antallBesvarelser;

    public ProsjektSensur(String fag, String eksamenstype, int antallBesvarelser) {
        super(fag, eksamenstype);
        this.antallBesvarelser = antallBesvarelser;
    }

    @Override
    public double beregnTidsforbruk() {
        return PROSJEKTSENSUR*antallBesvarelser;
    }

    @Override
    public String toString() {
        return super.toString()+"ProsjektSensur{" +
                "PROSJEKTSENSUR=" + PROSJEKTSENSUR +
                ", antallBesvarelser=" + antallBesvarelser +
                '}';
    }

    @Override
    public String toFile() {
        return "P"+","+super.toFile()+","+antallBesvarelser;
    }
}
