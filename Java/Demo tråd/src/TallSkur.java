public class TallSkur {
    public static void main(String[] args) {
        //Oppretter 5 objekter av TallSkriver, med hver sin verdi av tall:
        TallSkriver skriver1 = new TallSkriver(1);
        TallSkriver skriver2 = new TallSkriver(2);
        TallSkriver skriver3 = new TallSkriver(3);
        TallSkriver skriver4 = new TallSkriver(4);
        TallSkriver skriver5 = new TallSkriver(5);

        skriver1.start();
        skriver2.start();
        skriver3.start();
        skriver4.start();
        skriver5.start();
    }
}
