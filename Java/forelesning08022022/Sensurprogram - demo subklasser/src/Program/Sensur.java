package Program;

public abstract class Sensur {
    public final int FORBEREDELSE = 3;
    private String fag;
    private String eksamenstype;

    public Sensur(String fag, String eksamenstype) {
        this.fag = fag;
        this.eksamenstype = eksamenstype;
    }

    public String getFag() {
        return fag;
    }

    public void setFag(String fag) {
        this.fag = fag;
    }

    public String getEksamenstype() {
        return eksamenstype;
    }

    public void setEksamenstype(String eksamenstype) {
        this.eksamenstype = eksamenstype;
    }

    public int getFORBEREDELSE() {
        return FORBEREDELSE;
    }

    //En abstrakt medote for å beregne tidsforbruk
    public abstract double beregnTidsforbruk();

    @Override
    public String toString() {
        return "Sensur{" +
                "FORBEREDELSE=" + FORBEREDELSE +
                ", fag='" + fag + '\'' +
                ", eksamenstype='" + eksamenstype + '\'' +
                '}';
    }

    // toFile();
    public String toFile() {
        return fag+','+eksamenstype;
    }
}
