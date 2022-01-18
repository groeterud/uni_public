package Potens;

public class PotensTest {
    public static void main(String[] args) {
        int grunntall = 2;
        int eksponen = 10;

        System.out.println(potens(2,10));

    }

    public static int potens (int grunntall, int eksponent) {
        if (eksponent == 1) return grunntall;
        else return potens(grunntall, eksponent-1)*grunntall;
    }
}
