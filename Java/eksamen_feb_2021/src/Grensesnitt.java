import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grensesnitt {
    private final String[] ALTERNATIV = {"veiprosjekt","byggeprosjekt"};
    Kontroll kontroll = new Kontroll();

    public void nyttProsjekt() {
        int valg = prosjektValg();
        switch (valg) {
            case 0:
                nyttVeiProsjekt();
                break;
            case 1:
                nyttByggeProsjekt();
                break;
        }
    }

    public int prosjektValg() {
        int valg = JOptionPane.showOptionDialog(
                null,
                "Type prosjekt",
                "Prosjektvalg",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                ALTERNATIV,
                ALTERNATIV[0]
        );
        return valg;
    }
    public void nyttVeiProsjekt() {

    }

    public void nyttByggeProsjekt() {
        Scanner input = new Scanner(System.in);
        System.out.println("Prosjektnr");
        int prosjektnr = Integer.parseInt(input.next());
        System.out.println("Hvordan type byggeprosjekt?");
        String type = input.next();
        System.out.println("Hva er prosjektets budsjettramme?");
        double budsjett = Double.parseDouble(input.next());
        System.out.println("Hva er bygningens adresse?");
        String adresse = input.next();
        if (kontroll.regByggProsjekt(prosjektnr,type,budsjett,false,adresse)) JOptionPane.showMessageDialog(null,"Prosjektet er registrert");
        else System.out.println("Noe gikk galt");
    }

    public void nyttAnbud() {
        int prosjektnr = Integer.parseInt(JOptionPane.showInputDialog("Prosjektnr?"));
        String anbyder = JOptionPane.showInputDialog("Anbyders navn?");
        double belop = Double.parseDouble(JOptionPane.showInputDialog("Hva er anbudet?"));

        kontroll.nyttAnbud(prosjektnr,anbyder,belop);
    }
    public void finnLavest() {
        int prosjektnr = Integer.parseInt(JOptionPane.showInputDialog("Prosjektnr?"));
        Anbud a = kontroll.finnLaveste(prosjektnr);
        JOptionPane.showMessageDialog(null,"Laveste anbudet er på kr: "+a.getBelop());
    }

    public void alleProsjekt() {
        ArrayList<Prosjekt> prosjekt = kontroll.getProsjekter();
        for (Prosjekt p : prosjekt) {
            ArrayList<Anbud> anbud = p.getAnbud();
            System.out.println(p.toString());

            for (Anbud a : anbud) {
                System.out.println(a.toString());
            }
        }
    }
}
