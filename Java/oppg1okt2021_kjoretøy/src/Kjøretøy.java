public class Kjøretøy {
    String regnr;
    String produsent;
    String modell;
    int regÅr;

    public Kjøretøy(String regnr, String produsent, String modell, int regÅr) {
        this.regnr = regnr;
        this.produsent = produsent;
        this.modell = modell;
        this.regÅr = regÅr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kjøretøy kjøretøy = (Kjøretøy) o;
        return regnr.equals(kjøretøy.regnr);
    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getRegÅr() {
        return regÅr;
    }

    public void setRegÅr(int regÅr) {
        this.regÅr = regÅr;
    }

    public int compareTo(Kjøretøy o) {
        return this.regnr.compareTo(o.getRegnr());
    }

    @Override
    public String toString() {
        return "Kjøretøy{" +
                "regnr='" + regnr + '\'' +
                ", produsent='" + produsent + '\'' +
                ", modell='" + modell + '\'' +
                ", regÅr=" + regÅr +
                '}';
    }
}
