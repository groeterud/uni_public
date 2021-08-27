import javax.swing.*;

public class heltall {
    public static void main(String[] args) {
        int tall1 = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn tall 1: "));
        int tall2 = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn tall 2: "));

        System.out.println("Summen er: "+summer(tall1,tall2));
    }
    public static int summer (int tall1, int tall2) {
        int sum = tall1+tall2;
        return sum;
    }
}
