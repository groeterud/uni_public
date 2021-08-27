import javax.swing.*;

public class app {
    public static void main(String[] args) {
        int høyde = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn høyde: "));
        int bredde = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn bredde: "));

        Rektangel r1 = new Rektangel(høyde,bredde);
        System.out.println("Rektangelets areal er: "+r1.getAreal());

        double radius = Double.parseDouble(JOptionPane.showInputDialog("Skriv inn radius: "));

        Sirkel s1 = new Sirkel(radius);
        System.out.println("Sirkelens areal er: "+s1.getAreal());
    }
}
