
import javax.swing.*;
import java.util.Arrays;

public class Program1 {
    public static void main(String[] args) {
        int antall_linjer= Integer.parseInt(JOptionPane.showInputDialog("Hvor mange linjer?"));

        for (int i = 0; i <= antall_linjer; i++) {
            String stars=new String();
            for (int j = 0; j < i; j++) {
                stars+="*";
            }
            System.out.println(stars);
        }
    }
}
