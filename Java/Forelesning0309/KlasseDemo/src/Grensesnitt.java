import javax.swing.*;

public class Grensesnitt {
    Kontroll kontroll = new Kontroll();
    final String[] ALTERNATIVER = {"Ny ansatt", "Ny student","Søk","Avslutt"};

    public void meny() {
        boolean fortsett = true;
        while (fortsett) {
            int valg = JOptionPane.showOptionDialog(
                    null, //foreldrevindu
                    "Gjør et valg:",// ledetekst over knappene
                    "Personmeny", //navn på vinduet
                    JOptionPane.DEFAULT_OPTION, // Ikke bry deg
                    JOptionPane.PLAIN_MESSAGE, //oss om hva disse to betyr
                    null,
                    ALTERNATIVER, // Arrayen med alternativer
                    ALTERNATIVER[0] // Default alternativ
            );
            System.out.println(valg);
            switch (valg) {
                case 0:
                    

            }
        }
    }
}
