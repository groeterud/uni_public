public class App {
    public static void main(String[] args) {
        //LåneBS
        int laanesum = 3400000;
        int sluttsum = 2233916;
        int målestokk = laanesum-sluttsum;
        System.out.println("Lånet er etter 10 år betalt ned med:"+målestokk);

        //Fond stuff
        double rente = 1.00941; //0.21% månedlig avkastning
        double innsats = 8890.58;
        Fond f1 = new Fond(rente,innsats);
        Fond f2 = new Fond(1.035,10000);

        for (int i = 1; i < 121; i++) {
            f1.nyMåned();
            f2.nyMåned();
            if (i%12==0) {
                int fortjeneste = (int) f1.getVerdi() - (int)f1.getLast_year();
                System.out.println("Dette er år "+i/12+", du betaler kr: "+(int)f1.nyttÅr()+" i skatt");
                System.out.println("Verdien på fondet er nå: "+(int)f1.getVerdi());
                System.out.println("Fortjenesten i år var: "+fortjeneste+"\n");
                f2.nyttÅr();
            }
        }
        f1.selg();
        f2.selg();
        System.out.println(f1.toString());
        System.out.println(f2.toString());

        if (målestokk>f1.getVerdi()) {
            System.out.println("Det lønner seg å betale ned på lånet baby");
            int delta = målestokk - (int)f1.getVerdi();
            System.out.println("Deltaen er:"+delta);
        }
        else {
            System.out.println("Wolf of wall street baby");
            int delta = (int)f1.getVerdi() - målestokk;
            System.out.println("Deltaen er:"+delta);
        }
    }
}
