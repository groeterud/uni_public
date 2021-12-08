public class Anbud implements Comparable<Anbud> {
    private String anbyder;
    private double belop;

    public Anbud(String anbyder, double belop) {
        this.anbyder = anbyder;
        this.belop = belop;
    }

    public String getAnbyder() {
        return anbyder;
    }

    public void setAnbyder(String anbyder) {
        this.anbyder = anbyder;
    }

    public double getBelop() {
        return belop;
    }

    public void setBelop(double belop) {
        this.belop = belop;
    }

    @Override
    public int compareTo(Anbud o) {
        if (this.belop > o.getBelop()) return -1;
        else if (this.belop == o.getBelop()) return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return "Anbud{" +
                "anbyder='" + anbyder + '\'' +
                ", belop=" + belop +
                '}';
    }
}
