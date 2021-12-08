import java.util.ArrayList;
import java.util.Collections;

public class Kontroll {
    private ArrayList<Prosjekt> prosjekter;

    public boolean regByggProsjekt(int prosjektnr, String type, double budsjett, boolean tildelt, String adresse) {
        ByggeProsjekt b = new ByggeProsjekt(prosjektnr,type,budsjett,tildelt,adresse);
        prosjekter.add(b);
        return true;
    }

    public Prosjekt finnProsjekt(int prosjektnr) {
        for (Prosjekt p:prosjekter) {
            if (p.getProsjektNr()==prosjektnr) return p;
        }
        return null;
    }

    public Prosjekt finnProsjektBIN(int prosjektnr) {
        Prosjekt dummy = new Prosjekt(prosjektnr,null,null,null);
        Collections.binarySearch(prosjekter,dummy); // Krever at vi implementerer compareTo i Prosjekt.
        return null;
    }

    public void nyttAnbud(int prosjektnr, String anbyder, double belop) {
        Prosjekt p = finnProsjekt(prosjektnr);
        Anbud a = new Anbud(anbyder,belop);
        p.nyttAnbud(a);
    }
    public Anbud finnLaveste(int prosjetknr) {
        Prosjekt p = finnProsjekt(prosjetknr);
        ArrayList<Anbud> anbud = p.getAnbud();
        Collections.sort(anbud);
        int i = anbud.size()-1;
        return anbud.get(i);
    }

    public ArrayList<Prosjekt> getProsjekter() {
        return prosjekter;
    }
}
