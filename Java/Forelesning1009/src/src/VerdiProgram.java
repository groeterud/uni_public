import javax.swing.*;

public class VerdiProgram {
    public static void main(String[] args) {
        TegnKontroll kontroll = new TegnKontroll();
        char start = JOptionPane.showInputDialog("Skriv inn første tegnet: ").charAt(0);
        char slutt = JOptionPane.showInputDialog("Skriv inn andre tegnet: ").charAt(0);

        String s = kontroll.lagVerdier(start,slutt);
        // Presenter resultatet
        JOptionPane.showMessageDialog(null,s);
    }
}
