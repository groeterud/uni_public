import javax.swing.*;

public class Oppgave_gangetabell {
    public static void main(String[] args) {
        int start = Integer.parseInt(JOptionPane.showInputDialog("Skriv startverdi:"));
        int slutt = Integer.parseInt(JOptionPane.showInputDialog("Skriv sluttverdi:"));

        //Løkke som skriver ut del av gangetabellen
        for (int i = start; i < slutt; i++) {
            System.out.println("\n"+i+" gangen:");
            for (int j = 1; j <= 10; j++) {
                int resultat=i*j;
                System.out.println(i+" x "+j+" = "+resultat);
            }
        }
    }
}
