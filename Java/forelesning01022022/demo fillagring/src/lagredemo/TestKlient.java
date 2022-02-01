package lagredemo;

import java.util.ArrayList;

public class TestKlient {
    public static void main(String[] args) {
        //Definerer filnavn
        String filnavn = "personer.csv";

        //lager kontrollobjekt
        Kontroll kontroll = new Kontroll();

        //Legge er inn et par personer
        kontroll.nyPerson(new Person("Aksel","Hennie",1985));
        kontroll.nyPerson(new Person("Nasse","Nøff",1920));
        kontroll.nyPerson(new Person("Ole", "Brum", 1920));
        kontroll.nyPerson(new Person("Aleksander","Robin",1920));

        kontroll.skrivData(filnavn);
        kontroll.lesData(filnavn);

        ArrayList<Person> personer = kontroll.getPersoner();
        for (Person p : personer) {
            if (p != null) System.out.println(p);
        }
    }
}
