package hashdemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class TestKlient {
    public static void main(String[] args) {
        //Oppretter en hashmap, definerer key for hashet og objekt-type.
        HashMap<String, Person> hashtabell = new HashMap<>();

        String navn = "Ola Dunk";
        Person ola = new Person(navn,"latesomveien 13");

        //putter personen inn i hash tabellen.
        hashtabell.put(navn,ola);

        //lager en pers til
        navn = "Lise";
        hashtabell.put(navn, new Person(navn, "Vei 3"));

        //lister ut innholdet
        Collection<Person> verdier = hashtabell.values();
        Iterator<Person> oppramser = verdier.iterator();
        //Går gjennom iteratoren
        while (oppramser.hasNext()) {
            System.out.println(oppramser.next().toString());
        }
    }
}
