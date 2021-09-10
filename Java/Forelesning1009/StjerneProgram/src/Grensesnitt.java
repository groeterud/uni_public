import javax.swing.*;

public class Grensesnitt {
    // Instansierer objektet av klassen TegnKontroll
    TegnKontroll kontroll = new TegnKontroll();
    // Menyvalgene våre
    private final String[] ALTERNATIV = {"teg trekant", "tegn pyramide","Avslutt"};

    public void meny() {
        // Bruker en løkke med boolsk variable.
        boolean fortsett = true;

        while (fortsett) {
            //skriver ut meny og leser menyvalg
            int valg = lesValg();
            switch (valg) {
                case 0: lagTrekant();
                    break;
                case 1: lagPyramide();
                    break;
                default: fortsett = false;
            }
        }
    }
    public int lesValg() {
        int valg = JOptionPane.showOptionDialog(
                null,
                "Gjør et valg",
                "Tegneprogram",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                ALTERNATIV,
                ALTERNATIV[0]
        );
        return valg;
    }
    public void lagTrekant() {
        int linjer = Integer.parseInt(JOptionPane.showInputDialog("Hvor mange linjer?"));
        String tegning=kontroll.tegnTrekant(linjer);
        JOptionPane.showMessageDialog(null,tegning);
    }
    public void lagPyramide() {
        int linjer = Integer.parseInt(JOptionPane.showInputDialog("Hvor mange linjer?"));
        String tegning = kontroll.tegnPyramide(linjer);
        JOptionPane.showMessageDialog(null,tegning);
    }
}
