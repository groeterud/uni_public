import javax.swing.*;

public class Tverrsum {
    public static void main(String[] args) {
        int helTall = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn heltall: "));
        int sum = summerTverr(helTall);
        System.out.println("Summen av tallet er: "+sum);
    }
    public static int summerTverr (int tall) {
        int sum=0;
        int nummer=0;
        while (tall>0) {
            nummer=tall % 10;
            System.out.println("NUMMER ER: "+nummer);
            sum = sum + nummer;
            tall=tall/10;
        }
        return sum;
    }
}
