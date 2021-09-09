import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn nedre grense!");
        int tegn1 = input.next().charAt(0);
        System.out.println("Skriv inn øvre gense!");
        int tegn2 = input.next().charAt(0);

        for (int i = tegn1 ; i < tegn2+1; i++) {
            System.out.println(i);
        }
    }
}
