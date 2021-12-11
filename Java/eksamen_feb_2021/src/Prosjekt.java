import java.util.ArrayList;
import java.util.Collections;

public class Prosjekt implements Comparable<Prosjekt>{
    private int prosjektNr;
    private String type;
    private double budsjett;
    private ArrayList<Anbud> anbud;
    private boolean tildelt;

    public Prosjekt(int prosjektNr, String type, Double budsjett, Boolean tildelt) {
        this.prosjektNr = prosjektNr;
        this.type = type;
        this.budsjett = budsjett;
        this.tildelt = tildelt;
    }

    public int getProsjektNr() {
        return prosjektNr;
    }

    public void setProsjektNr(int prosjektNr) {
        this.prosjektNr = prosjektNr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBudsjett() {
        return budsjett;
    }

    public void setBudsjett(double budsjett) {
        this.budsjett = budsjett;
    }

    public boolean isTildelt() {
        return tildelt;
    }

    public void setTildelt(boolean tildelt) {
        this.tildelt = tildelt;
    }

    public ArrayList<Anbud> getAnbud() {
        return anbud;
    }

    public boolean nyttAnbud(Anbud o) {
        if (o != null) {
            anbud.add(o);
            return true;
        }
        return false;
    }

    public Anbud storsteAnbud() {
        Collections.sort(anbud);
        return anbud.get(0);
    }

    @Override
    public String toString() {
        return "Prosjekt{" +
                "prosjektNr=" + prosjektNr +
                ", type='" + type + '\'' +
                ", budsjett=" + budsjett +
                ", tildelt=" + tildelt +
                '}';
    }


    @Override
    public int compareTo(Prosjekt o) {
        if (this.prosjektNr > o.getProsjektNr()) return 1;
        else if (this.prosjektNr < o.getProsjektNr()) return -1;
        else return 0;
    }
}
