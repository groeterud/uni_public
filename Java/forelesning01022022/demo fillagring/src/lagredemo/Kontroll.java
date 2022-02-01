package lagredemo;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static hjelpeklasser.Filbehandling.*;

public class Kontroll {
    private ArrayList<Person> personer = new ArrayList<>();

    public void nyPerson(Person p) {
        if (p!=null) personer.add(p);
    }

    //Tømmer arraylisten:
    public void tøm() {
        personer.clear();
    }


    //Metode for å lagre objekter
    public void skrivData (String filnavn) {
        try {
            //lager forbindelse til disken           finnes ikke filen fra før så lages den
            PrintWriter utfil = lagSkriveForbindelse(filnavn);
            //går gjennom arraylisten
            for (Person p: personer) {
                utfil.println(p.toFile()); // skriver til fil
            }
            utfil.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metode for å lese objekter
    public void lesData(String filnavn) {
        tøm();
        try {
            //lager leseforbindelse
            BufferedReader innfil = lagLeseForbindelse(filnavn);
            String linje = innfil.readLine(); //leser første linje
            while (linje != null) {
                StringTokenizer innhold = new StringTokenizer(linje,",");
                String fnavn = innhold.nextToken();
                String enavn = innhold.nextToken();
                int får = Integer.parseInt(innhold.nextToken());
                personer.add(new Person(fnavn,enavn,får));
                linje= innfil.readLine();
            }
            innfil.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Returnerer referanse til array
    public ArrayList<Person> getPersoner() {
        return personer;
    }

}
