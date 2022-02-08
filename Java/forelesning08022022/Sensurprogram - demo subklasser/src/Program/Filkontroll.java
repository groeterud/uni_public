package Program;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static hjelpeklasser.Filbehandling.*;

public class Filkontroll {
    private ArrayList<Sensur> sensurering = new ArrayList<>();

    private final String FILNAVN = "sensurering.csv";

    public void nyMuntlig(String fag, String eksamenstype,double lengde) {
        sensurering.add(new MuntligSensur(fag,eksamenstype,lengde));
    }
    public void nySkriftlig(String fag, String eksamenstype,double lengde, int antallBesvarelser) {
        sensurering.add(new SkriftligSensur(fag,eksamenstype,lengde,antallBesvarelser));
    }
    public void nyProsjekt(String fag, String eksamenstype, int antallBesvarelser) {
        sensurering.add(new ProsjektSensur(fag, eksamenstype,antallBesvarelser));
    }
    public void nySensur(Sensur sensur) {
        sensurering.add(sensur);
    }

    public ArrayList<Sensur> getSensurering() {
        return sensurering;
    }
    //lagre på fil
    public void lagre() {
        try {
            //allokerer fil for skriving
            PrintWriter utfil = lagSkriveForbindelse(FILNAVN);
            //Utvidet for-løkke
            for (Sensur s: sensurering) {
                if (s!=null) { //  enkel forløkke kan hende kjører med tomme objekt
                    utfil.println(s.toFile());
                }
            }
            utfil.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //lese fra fil
    public void lese() {
        sensurering.clear(); //tømmer arraylisten
        try {
            BufferedReader innfil = lagLeseForbindelse(FILNAVN);
            String linje = innfil.readLine(); //leser første linje
            while (linje != null) {
                StringTokenizer innhold = new StringTokenizer(linje,",");
                String sensurtype = innhold.nextToken();
                //switch case for å se på sensurtypen
                switch (sensurtype) {
                    case "S":
                        lesSkriftlig(innhold);
                        break;
                    case "M":
                        lesMuntlig(innhold);
                        break;
                    case "P":
                        lesProsjekt(innhold);
                        break;
                    default:
                        throw new Exception("Fant ikke sensurtypen i fila, kontroller filen!");
                }
                linje= innfil.readLine();
            }
            innfil.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lesSkriftlig(StringTokenizer innhold) {
        SkriftligSensur s = new SkriftligSensur(innhold.nextToken(), innhold.nextToken(), Double.parseDouble(innhold.nextToken()),Integer.parseInt(innhold.nextToken()));
        sensurering.add(s);
    }
    public void lesMuntlig(StringTokenizer innhold) {
        MuntligSensur s = new MuntligSensur(innhold.nextToken(), innhold.nextToken(), Double.parseDouble(innhold.nextToken()));
        sensurering.add(s);
    }
    public void lesProsjekt(StringTokenizer innhold) {
        ProsjektSensur s = new ProsjektSensur(innhold.nextToken(), innhold.nextToken(), Integer.parseInt(innhold.nextToken()));
        sensurering.add(s);
    }
}
