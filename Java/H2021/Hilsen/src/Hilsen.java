import java.util.Scanner;

public class Hilsen {
        public static void main (String[] args) {
            Scanner kbd = new Scanner(System.in);
            System.out.println("Hva heter Du? ");
            String navn = kbd.next();
            System.out.println("Hei "+navn);
        }
}
