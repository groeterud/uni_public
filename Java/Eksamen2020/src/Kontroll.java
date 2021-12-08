import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.Collections;

public class Kontroll {
    ArrayList<Reise> reiser;
    ArrayList<Destination> destinasjoner;

    public void nyFirmaReise(String avreise, String hjemkomst, int destinasjonsnummer, String firma, String kontaktperson) {
        int reisenr = reiser.size()+1;
        Destination destinasjon = getDestinasjon(destinasjonsnummer);
        Firmareise fr = new Firmareise(reisenr,avreise,hjemkomst,destinasjon,kontaktperson,firma);
    }
    public void nyDeltager(int reisenr, int deltagernr, String navn, String adresse, String telefon) {
        Reise reise = getReise(reisenr);
        Deltager deltager = new Deltager (deltagernr,navn,adresse,telefon);
        reise.nyDeltager(deltager);
    }
    public Reise getReise(int reisenr) {
        for (Reise reise :
                reiser) {
            if (reise.getReisenummer()==reisenr) return reise;
        }
        return null;
    }
    public Reise getReiseBIN(int reisenr) {
        Collections.sort(reiser);
        Reise dummy = new Reise (reisenr,null,null,null);
        int indeks = Collections.binarySearch(reiser,dummy);
        if (indeks >= 0) return reiser.get(indeks);
        return null;
    }

    public ArrayList<Reise> getReiser() {
        return reiser;
    }
}
