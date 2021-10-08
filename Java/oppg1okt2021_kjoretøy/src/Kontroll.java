import java.util.ArrayList;
import java.util.Collections;

public class Kontroll {
    private ArrayList<Kjøretøy> kjøretøy = new ArrayList<>();

/*
 Klassen skal ha metoder for å sette inn et nytt objekt, finne objekter,
 skrive ut alle objektene (dvs det er klienten som skal gjøre dette. Kontroll skal bare returnere arraylisten til klienten)
  samt sortere objektene.
 */
    // settte inn objekt
    public boolean nyttKjøretøy(Kjøretøy o) {
        kjøretøy.add(o);
        return true;
    }

    // finne objekter
    public Kjøretøy finnKjøretøy(String regnr) {
        for (int i = 0; i < kjøretøy.size(); i++) {
            String k_regnr=kjøretøy.get(i).getRegnr();
            if(k_regnr.equals(regnr)) return kjøretøy.get(i);
        }
        return null;
    }
    public ArrayList<Kjøretøy> getList() {
        return kjøretøy;
    }

    public void sorter() {
        Collections.sort(kjøretøy);
        //kjøretøy.sort(null);
    }
}
