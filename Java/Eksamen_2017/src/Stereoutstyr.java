import java.util.ArrayList;

public class Stereoutstyr implements Comparable<Stereoutstyr>{
    private int serienummer;
    private String produktnavn;
    private String EAN;
    private ArrayList<Stereoutstyr> passendeProdukter = new ArrayList<>();

    public Stereoutstyr(Integer serienummer, String produktnavn, String EAN, ArrayList<Stereoutstyr> passendeProdukter) {
        this.serienummer = serienummer;
        this.produktnavn = produktnavn;
        this.EAN = EAN;
        this.passendeProdukter = passendeProdukter;
    }

    public int getSerienummer() {
        return serienummer;
    }

    public String getEAN() {
        return EAN;
    }

    public ArrayList<Stereoutstyr> getPassendeProdukter() {
        return passendeProdukter;
    }

    @Override
    public String toString() {
        return "Stereoutstyr{" +
                "serienummer=" + serienummer +
                ", produktnavn='" + produktnavn + '\'' +
                ", EAN='" + EAN + '\'' +
                ", passendeProdukter=" + passendeProdukter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stereoutstyr that = (Stereoutstyr) o;
        return EAN.equals(that.EAN);
    }

    @Override
    public int compareTo(Stereoutstyr o) {
        return this.EAN.compareTo(o.getEAN());
    }
}