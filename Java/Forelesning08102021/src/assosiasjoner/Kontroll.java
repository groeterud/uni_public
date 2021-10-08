package assosiasjoner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Kontroll {
    //Klassen inneholder 3 datastrukturer
    private ArrayList<Postadresse> postliste = new ArrayList<>();
    private ArrayList<Person> personliste = new ArrayList<>();
    private ArrayList<Kjøretøy> kjøretøyliste = new ArrayList<>();

    //metoder for å legge til en postadresse.
    public boolean nyPostadresse(String postnr, String poststed) {
        Postadresse p=finnPA(postnr);
        if (Objects.isNull(p)) {
            p = new Postadresse(postnr, poststed);
            postliste.add(p);
            return true;
        }
        System.out.println(p.toString());
        return false;
    }
    // finne en postadresse
    public Postadresse finnPA(String postnr) {
        for (int i = 0; i < postliste.size(); i++) {
            if (postliste.get(i).getPostnr().equals(postnr)) return postliste.get(i);
        }
        return null;
    }
    // legge til ny person
    public void nyPerson(String navn,String adresse, String postnr) {
        Postadresse pa = finnPA(postnr);
        personliste.add(new Person(navn,adresse,pa));
    }
    public Person finnPerson(String navn) {
        //sorter lista
        Collections.sort(personliste);
        //binærsøk på navn - vi må søke etter objekt med samme mønster, så vi lager nytt objekt med nullmerker på alt annet enn navn
        int index = Collections.binarySearch(personliste,new Person(navn,null,null));
        if (index>=0) return personliste.get(index);
        return null; // returner null om vi ikke finner det vi søker på
        /* gammel (lineær) søkefunksjon
        for (int i = 0; i < personliste.size(); i++) {
            Person p = personliste.get(i);
            if (p.getNavn()==navn) return p;
        }
        */
    }

    //skal ikke få et kjøretøy, skal få et objekt.
    public void nyttKjøretøy(Kjøretøy k) {
        kjøretøyliste.add(k);
        Person eier = k.getEier();
        eier.nyttKjøretøy(k);
    }

    public ArrayList<Person> getPersoner() {
        return personliste;
    }

    public ArrayList<Postadresse> getPostadresser() {
        return postliste;
    }

    public ArrayList<Kjøretøy> getKjøretøyer() {
        return kjøretøyliste;
    }
}
