import java.util.ArrayList;

public class Reise implements Comparable<Reise>{
    private int reisenummer;
    private String avreise;
    private String hjemkomst;
    private ArrayList<Deltager> deltagere = new ArrayList<Deltager>();
    private Destinasjon destinasjon;

    public Reise(int reisenummer, String avreise, String hjemkomst, Destinasjon destinasjon) {
        this.reisenummer = reisenummer;
        this.avreise = avreise;
        this.hjemkomst = hjemkomst;
        this.destinasjon = destinasjon;
    }

    public int getReisenummer() {
        return reisenummer;
    }

    public void setReisenummer(int reisenummer) {
        this.reisenummer = reisenummer;
    }

    public void nyDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }
    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    @Override
    public int compareTo(Reise o) {
        if (this.reisenummer==o.getReisenummer()) return 0;
        else if (this.reisenummer<o.getReisenummer()) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "Reise{" +
                "reisenummer=" + reisenummer +
                ", avreise='" + avreise + '\'' +
                ", hjemkomst='" + hjemkomst + '\'' +
                ", destinasjon=" + destinasjon +
                '}';
    }
}



