import javax.swing.*;
import java.util.Arrays;

public class Program2 {
    public static void main(String[] args) {
        int antall_linjer= Integer.parseInt(JOptionPane.showInputDialog("Hvor mange linjer?"));
        int bredde=1;
        //Finner Bredden
        for (int i = 1; i < antall_linjer; i++) {
            bredde+=2;
        }
        String[] stars = new String[bredde];

        //Lager tomt array
        for (int i = 0; i < bredde; i++) {
            stars[i]="";
        }

        //Finner senter
        int senter_index= (int) Math.floor(stars.length/2);

        //hovedalgo
        for (int i = 0; i < antall_linjer; i++) {
            int left=senter_index-i;
            int right=senter_index+i;
            stars[left]="*";
            stars[right]="*";
            System.out.println(Arrays.toString(stars));
            }
    }
}

