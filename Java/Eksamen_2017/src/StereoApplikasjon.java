import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class StereoApplikasjon {
    private ArrayList<Kunde> kunder = new ArrayList<>();
    private ArrayList<Stereoutstyr> stereoutstyr = new ArrayList<>();

    public static void main(String[] args) {
        Forsterker forsterker = new Forsterker(123,"Yamaha XL814", "1120340",null,200);
        System.out.println(forsterker.toString());

    }

    public void nyKunde() {
        int personnummer = Integer.parseInt(JOptionPane.showInputDialog("skriv personnnummer: "));
        String navn = JOptionPane.showInputDialog("Skriv navn: ");
        String tlf = JOptionPane.showInputDialog("Skriv telefonnummer: ");

        Kunde kunde = new Kunde(personnummer,navn,tlf);
        kunder.add(kunde);
    }

    public Stereoutstyr finnEnhet(int serienummer) {
        for (Stereoutstyr s :
                stereoutstyr) {
            if (s.getSerienummer()==serienummer) return s;
        }
        return null;
    }
    public Stereoutstyr finnEnhetBIN(int serienummer) {
        Collections.sort(stereoutstyr);
        Stereoutstyr dummy = new Stereoutstyr(serienummer,null,null,null);
        int indeks = Collections.binarySearch(stereoutstyr,dummy);
        if (indeks >=0) return stereoutstyr.get(indeks);
        return null;
    }
    public Stereoutstyr søkEtterEnhet() {
        int serienummer = Integer.parseInt(JOptionPane.showInputDialog("Serienummeret å søke på: "));
        return finnEnhetBIN(serienummer);
    }

    public void visPassende() {
        int serienummer = Integer.parseInt(JOptionPane.showInputDialog("Serienummeret å søke på: "));
        Stereoutstyr s = finnEnhetBIN(serienummer);
        ArrayList<Stereoutstyr> passendeUtstyr = s.getPassendeProdukter();

        System.out.println("Viser passende produkter for"+s.toString()+"\n");
        for (Stereoutstyr passende :
                passendeUtstyr) {
            System.out.println(passende.toString());
        }
    }
}
