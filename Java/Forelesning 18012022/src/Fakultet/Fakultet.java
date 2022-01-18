package Fakultet;

public class Fakultet {
    public static void main(String[] args) {
        System.out.println(fakultet(5));
    }
    public static int fakultet(int tall) {
        if (tall == 1) return 1; // stop-case
        return fakultet(tall-1)*tall;
    }
}
