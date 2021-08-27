import javax.swing.*;

public class kontroller {
    public static void main(String[] args) {
        int årstall = Integer.parseInt(JOptionPane.showInputDialog("Skriv et årstall: "));
        boolean erSkuddår = sjekkår(årstall);
        if(erSkuddår) JOptionPane.showMessageDialog(null,"Året " + årstall + " er et skuddår");
        else JOptionPane.showMessageDialog(null,"Året "+årstall + " er ikke et skuddår");
    }
    public static boolean sjekkår (int år) {
        boolean ok = false;
        ok = (år % 4 == 0 && år % 100 !=0) || (år % 400 == 0);
        return ok;
    }
}
