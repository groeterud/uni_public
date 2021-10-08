package assosiasjoner;

import java.util.ArrayList;

public class Kontroll {
    //Klassen inneholder 3 datastrukturer
    private ArrayList<Postadresse> postliste = new ArrayList<>();
    private ArrayList<Person> personliste = new ArrayList<>();
    private ArrayList<Kjøretøy> kjøretøyliste = new ArrayList<>();

    //metoder for å legge til en postadresse.
    public void nyPostadresse(String postnr, String poststed) {
        postliste.add(new Postadresse(postnr,poststed));
    }
    // finne en postadresse
    public Postadresse finnPA(String postnr) {
        for (int i = 0; i < postliste.size(); i++) {
            if (postliste.get(i).getPostnr()==postnr) return postliste.get(i);
        }
        return null;
    }
    // legge til ny person
    public void nyPerson(String navn,String adresse, String postnr) {
        Postadresse pa = finnPA(postnr);
        personliste.add(new Person(navn,adresse,pa));
    }
    public Person finnPerson(String navn) {
        for (int i = 0; i < personliste.size(); i++) {
            Person p = personliste.get(i);
            if (p.getNavn()==navn) return p;
        }
        return null;
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
