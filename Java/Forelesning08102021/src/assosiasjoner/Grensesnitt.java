package assosiasjoner;

import javax.swing.*;
import java.util.ArrayList;

public class Grensesnitt {
    Kontroll kontroll = new Kontroll();
    private final String[] ALTERNATIV= {"Registrer nytt kjøretøy","Registrer ny postadresse","Skriv ut alle kjøretøy med data om eier"};

    public void meny() {
        // dummy data, se Testklient for info
        kontroll.nyPostadresse("3500","Hønefoss");
        kontroll.nyPostadresse("3000","Drammen");

        kontroll.nyPerson("Ole","Veien 3", "3500");
        kontroll.nyPerson("Lise","Lierveien 2","3000");

        kontroll.nyttKjøretøy(new Kjøretøy("SV1234","Volvo",kontroll.finnPerson("Ole")));
        kontroll.nyttKjøretøy(new Kjøretøy("KH20415","Volvo 240", kontroll.finnPerson("Lise")));
        kontroll.nyttKjøretøy(new Kjøretøy("AB1122","Aston Martin DBS", kontroll.finnPerson("Ole")));


        boolean fortsett=true;
        while (fortsett) {
            int valg=velgFunc();
            switch (valg) {
                case 0:
                    nyttKjøretøy();
                    break;
                case 1:
                    nyPostadresse();
                    break;
                case 2:
                    skrivKjøretøy();
                    break;
                default: fortsett=false;
            }
        }
    }
    public int velgFunc() {
        int valg = JOptionPane.showOptionDialog(
                null,
                "Gjør et valg",
                "DiktGenerator",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                ALTERNATIV,
                ALTERNATIV[0]
        );
        return valg;
    }
    public void nyttKjøretøy() {
        //henter inputs
        String regnr=JOptionPane.showInputDialog("Skriv inn bilens regnr");
        String modell=JOptionPane.showInputDialog("Skriv inn bilens modell");
        String eiersNavn=JOptionPane.showInputDialog("Skriv inn eiers navn");
        //finner eier basert på eiers navn
        Person eier= kontroll.finnPerson(eiersNavn);
        //instansierer kjøretøysobjektet
        Kjøretøy kjøretøy = new Kjøretøy(regnr,modell,eier);
        //legger det til
        kontroll.nyttKjøretøy(kjøretøy);
        //viser suksessdialog.
        JOptionPane.showMessageDialog(null,"Vellykket! vi la til: "+kjøretøy.toString());

    }
    public void nyPostadresse() {
        System.out.println(kontroll.getPostadresser().toString());
        String postnr = JOptionPane.showInputDialog("Skriv inn postnr");
        String poststed = JOptionPane.showInputDialog("Skriv inn poststed");
        boolean ok=kontroll.nyPostadresse(postnr,poststed);
        if (ok) JOptionPane.showMessageDialog(null,"Vellykket! ");
        else JOptionPane.showMessageDialog(null,"Mislykket, postnummeret finnes allerede");

    }
    public void skrivKjøretøy() {
        ArrayList<Kjøretøy> kjøretøy = kontroll.getKjøretøyer();
        String utskrift="";
        for (int i = 0; i < kjøretøy.size(); i++) {
            int nummer = i+1;
            Kjøretøy k = kjøretøy.get(i);
            Person p = k.getEier();
            utskrift+="Bil nr: "+nummer+"\n"+k.toString()+"\n"+p.toString()+"\n"+"\n";
            /*JOptionPane.showMessageDialog(null,"Bil nr: "+nummer+"\n" +
                    k.toString()+"\n"+
                    p.toString());

             */
        }
        JOptionPane.showMessageDialog(null,utskrift);

    }

}
