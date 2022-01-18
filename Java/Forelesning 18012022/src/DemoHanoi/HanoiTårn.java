package DemoHanoi;

import javax.swing.*;

public class HanoiTårn {
    public static void main(String[] args) {
        //spørr etter antall skiver
        int antall = Integer.parseInt(JOptionPane.showInputDialog("Hvor mange skiver?"));
        flytt(antall, 'A', 'B', 'C');
    }

    //recursive function, n = antall skiver
    public static void flytt(int n, char fraTårn, char tilTårn, char ekstraTårn) {
        if (n == 1) System.out.println("Flytt skive " + n + " fra " + fraTårn + " til " + tilTårn);
        else {
            flytt(n-1,fraTårn,ekstraTårn,tilTårn);
            System.out.println("Flytt skive " + n + " fra " + fraTårn +" til " + tilTårn);
            flytt(n-1,ekstraTårn,tilTårn,fraTårn);
        }
    }
}
