import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        int tall=Integer.parseInt(JOptionPane.showInputDialog("Hvilket tall skal vi gange til 10? "));
        for (int i = 1; i < 11; i++) {
            int sum = tall * i;
            System.out.println(tall+" x "+i+" = "+sum);
        }
    }
}
