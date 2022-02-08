package Program;

import java.util.ArrayList;

public class TestKlient {
    public static void main(String[] args) {
        Filkontroll filkontroll = new Filkontroll();

        //legger inn noen sensurer
        filkontroll.nyMuntlig("OBJ2000","Muntlig",15.5);
        filkontroll.nySkriftlig("OAD1000","Skriftlig",4.0,15);
        filkontroll.nyProsjekt("BID3000","Prosjekt",8);


        ArrayList<Sensur> gammel = filkontroll.getSensurering();
        System.out.println("Sensurer:"+gammel+"\n");

        System.out.println("Etter lesing fra fil");
        filkontroll.lagre();
        filkontroll.lese();

        ArrayList<Sensur> ny = filkontroll.getSensurering();
        System.out.println("Sensurer:"+ny+"\n");

        if (gammel.equals(ny)) System.out.println("De er like, ingen data ble tapt!");

        System.out.println("\n" +"Vi beregner timer\n");

        for (Sensur sensur: ny) {
            System.out.println(sensur);
            System.out.println("Timer:"+sensur.beregnTidsforbruk()+"\n");
        }

    }
}
