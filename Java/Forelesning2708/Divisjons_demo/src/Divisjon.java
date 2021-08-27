import javax.swing.JOptionPane;
import java.util.Formatter;

public class Divisjon {

    public static void main(String[] args) {
        // Innlesing
        String lestTall = JOptionPane.showInputDialog("Skriv et tall:");
        int tall1 = Integer.parseInt(lestTall);
        lestTall = JOptionPane.showInputDialog("Skriv ett tall til");
        int tall2 = Integer.parseInt(lestTall);
        // Heltallsdivisjon
        int svar = tall1/tall2;
        //Presenter svaret
        JOptionPane.showMessageDialog(null,"Svart på heltallsdviisjon er: "+svar);
        double svar2 = (double) tall1/tall2;
        JOptionPane.showMessageDialog(null,"Svaret på vanlig divisjon er: "+svar2);
        int restDiv = tall1%tall2;
        JOptionPane.showMessageDialog(null,"Resten er: "+restDiv);
        System.out.printf("%.2f",svar2);
        
        Formatter formatør = new Formatter();
        formatør.format("%.2f",svar2);
        JOptionPane.showMessageDialog(null,"Formattert divisjonstall er: "+formatør.toString());
    }
}
