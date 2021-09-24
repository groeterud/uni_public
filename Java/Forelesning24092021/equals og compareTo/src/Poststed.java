public class Poststed implements Comparable<Poststed> {
    private int postnr;
    private String stedsnavn;

    public Poststed(int postnr, String stedsnavn) {
        this.postnr = postnr;
        this.stedsnavn = stedsnavn;
    }

    public int getPostnr() {
        return postnr;
    }

    public void setPostnr(int postnr) {
        this.postnr = postnr;
    }

    public String getStedsnavn() {
        return stedsnavn;
    }

    public void setStedsnavn(String stedsnavn) {
        this.stedsnavn = stedsnavn;
    }


    public String toString() {
        return "Poststed{" +
                "postnr=" + postnr +
                ", stedsnavn='" + stedsnavn + '\'' +
                '}';
    }

    public boolean equals(Poststed denAndre) {
        return postnr == denAndre.getPostnr();
    }


    public int compareTo(Poststed o) {
        if (this.postnr == o.getPostnr()) return 0;
        else if (this.postnr < o.getPostnr()) return -1;
        else return 1;
    }
}
