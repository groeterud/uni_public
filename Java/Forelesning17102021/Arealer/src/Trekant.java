public class Trekant extends Figur{
    private double lengde;
    private double høyde;

    public Trekant(double lengde, double høyde) {
        this.lengde = lengde;
        this.høyde = høyde;
    }

    public double getLengde() {
        return lengde;
    }

    public void setLengde(double lengde) {
        this.lengde = lengde;
    }

    public double getHøyde() {
        return høyde;
    }

    public void setHøyde(double høyde) {
        this.høyde = høyde;
    }

    @Override
    public double beregnAreal() {
        return (lengde*høyde)/2;
    }
}
