import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class StereoApplikasjon {
    private ArrayList<Kunde> kunder = new ArrayList<>();
    private ArrayList<Stereoutstyr> stereoutstyr = new ArrayList<>();

    public static void main(String[] args) {
        Forsterker forsterker = new Forsterker(123,"Yamaha XL814", "1120340",200);
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
        Stereoutstyr dummy = new Stereoutstyr(serienummer,null,null);
        int indeks = Collections.binarySearch(stereoutstyr,dummy);
        if (indeks >=0) return stereoutstyr.get(indeks);
        return null;
    }
    public void søkEtterEnhet() {
        int serienummer = Integer.parseInt(JOptionPane.showInputDialog("Serienummeret å søke på: "));
        Stereoutstyr s = finnEnhetBIN(serienummer);
        if (s != null) System.out.println(s.toString());
        else System.out.println("Fant ingen enhet med det serienummeret");
    }

    public ArrayList<Stereoutstyr> finnPassende(int serienummer) {
        Stereoutstyr s = finnEnhetBIN(serienummer);
        ArrayList<Stereoutstyr> passendeUtstyr = s.getPassendeProdukter();
        return passendeUtstyr;
    }

    public void visPassende() {
        int serienummer = Integer.parseInt(JOptionPane.showInputDialog("Serienummeret å søke på: "));

        ArrayList<Stereoutstyr> passendeUtstyr = finnPassende(serienummer);

        for (Stereoutstyr stereoutstyr : passendeUtstyr) {
            System.out.println(stereoutstyr.toString());
        }

    }
}
