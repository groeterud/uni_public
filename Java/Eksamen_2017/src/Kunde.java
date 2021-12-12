import java.util.ArrayList;

public class Kunde {
    private int personnummer;
    private String navn;
    private ArrayList<Stereoutstyr> produkterKjøpt = new ArrayList<>();
    private String telefonnummer;

    public Kunde(int personnummer, String navn, String telefonnummer) {
        this.personnummer = personnummer;
        this.navn = navn;
        this.telefonnummer = telefonnummer;
    }

    public int getPersonnummer() {
        return personnummer;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Stereoutstyr> getProdukterKjøpt() {
        return produkterKjøpt;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }
    public boolean nyttKjop(Stereoutstyr s) {
        if (s != null) {
            produkterKjøpt.add(s);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "personnummer=" + personnummer +
                ", navn='" + navn + '\'' +
                ", produkterKjøpt=" + produkterKjøpt +
                ", telefonnummer='" + telefonnummer + '\'' +
                '}';
    }
}
