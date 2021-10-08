package assosiasjoner;

import java.util.ArrayList;

public class Person implements Comparable<Person>{
    private String navn;
    private String adresse;
    private Postadresse postadresse;
    private ArrayList<Kjøretøy> kjøretøy = new ArrayList<>();

    public Person(String navn, String adresse, Postadresse postadresse) {
        this.navn = navn;
        this.adresse = adresse;
        this.postadresse = postadresse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Postadresse getPostadresse() {
        return postadresse;
    }

    public void setPostadresse(Postadresse postadresse) {
        this.postadresse = postadresse;
    }

    public ArrayList<Kjøretøy> getKjøretøy() {
        return kjøretøy;
    }

    public boolean nyttKjøretøy(Kjøretøy k) {
        this.kjøretøy.add(k);
        return true;
    }

    @Override
    public int compareTo(Person o) {
        return this.navn.compareTo(o.getNavn());
    }

    @Override
    public String toString() {
        return "Person{" +
                "navn='" + navn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postadresse=" + postadresse +
                '}';
    }
}
