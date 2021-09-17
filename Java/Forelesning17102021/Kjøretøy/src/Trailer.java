public class Trailer extends Kjøretøy{
    private int lasterom;

    public Trailer(String regnr, String fabrikant, int lasterom) {
        super(regnr, fabrikant);
        this.lasterom = lasterom;
    }

    public int getLasterom() {
        return lasterom;
    }

    public void setLasterom(int lasterom) {
        this.lasterom = lasterom;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Trailer{" +
                "lasterom=" + lasterom +
                '}';
    }
}

