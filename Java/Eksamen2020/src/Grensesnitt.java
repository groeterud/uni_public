import javax.swing.*;
import java.util.ArrayList;

public class Grensesnitt {
    Kontroll kontroll = new Kontroll();

    //2-a
    public void nyFirmaReise() {
        String avreise = JOptionPane.showInputDialog("Avreisedato:");
        String hjemkomst = JOptionPane.showInputDialog("Hjemkomstdato");
        int destinasjonsnummer = Integer.parseInt(JOptionPane.showInputDialog("Destinasjonsnummer"));
        String firma = JOptionPane.showInputDialog("Firma");
        String kontaktperson = JOptionPane.showInputDialog("Kontaktperson");
        kontroll.nyFirmaReise(avreise,hjemkomst,destinasjonsnummer,firma,kontaktperson);
    }

    //2-b
    public void nyDeltager() {
        int reisenr = Integer.parseInt(JOptionPane.showInputDialog("Skriv reisenummeret"));
        int deltagernr = Integer.parseInt(JOptionPane.showInputDialog("Skriv deltagernr"));
        String navn = JOptionPane.showInputDialog("Deltagerens navn");
        String adresse = JOptionPane.showInputDialog("Deltagerens adresse");
        String telefon = JOptionPane.showInputDialog("Deltagerens telefon");
        kontroll.nyDeltager(deltagernr,navn,adresse,telefon,reisenr);
    }

    //2-c
    public void visReise() {
        int reisenr = Integer.parseInt(JOptionPane.showInputDialog("Skriv reisenummeret"));
        Reise reise = kontroll.getReise(reisenr);
        if (reise!=null) JOptionPane.showMessageDialog(null, reise.toString());
        else JOptionPane.showMessageDialog(null, "Fant ikke reisen");
    }

    //2-d
    public void alleReiser() {
        ArrayList<Reise> reiser = kontroll.getReiser();
        String print = "";
        for (int i = 0; i < reiser.size(); i++) {
            Reise reise = reiser.get(i);
            print+=reise.toString();
        }
        JOptionPane.showMessageDialog(null,print);
    }
}
