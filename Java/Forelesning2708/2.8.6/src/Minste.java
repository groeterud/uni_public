import javax.swing.*;

public class Minste {
    public static void main(String[] args) {
        int tall=hentTall();
        int minste=finnMinste(tall);
        print(minste);
    }
    public static int hentTall() {
        int tallrekke = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn heltall: "));
        return tallrekke;
    }
    public static int finnMinste(int tall) {
        int minste=10;
        int nummer;
        while (tall>0) {
            //finner tallet
            nummer=tall % 10;

            if (minste!=10) {
                minste=Math.min(minste,nummer);
            }
            else {
                minste=nummer;
            }
            // ned ett nivå
            tall=tall/10;
        }
        return minste;
    }
    public static void print(Object s) {
        System.out.println(s);
    }
}
