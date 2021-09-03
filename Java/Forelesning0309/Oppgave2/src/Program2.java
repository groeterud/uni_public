import javax.swing.*;

public class Program2 {
    public static void main(String[] args) {
        int antall_linjer= Integer.parseInt(JOptionPane.showInputDialog("Hvor mange linjer?"));
        int bredde=1;
        for (int i = 1; i < antall_linjer; i++) {
            bredde+=2;
        }
        String[] stars = new String[bredde];
        System.out.println(bredde);
        bredde=1;
        int senter_index= (int) Math.floor(stars.length/2);
        System.out.println(senter_index);

        for (int i = 0; i < antall_linjer; i++) {
            //konstruerer linjen vår
            for (int j = 0; j < stars.length; j++) {
                stars[j]="";
                stars[senter_index]="*";
            }
        }
    }
}
