package Filtrering;

import java.util.ArrayList;

public class Kontroll implements Filtrering{
    private ArrayList<Integer> talliste = new ArrayList<>();

    private void fyllListe(int makstall) {
        talliste.clear();
        for (int i = 1; i <= makstall; i++) {
            talliste.add(i);
        }
    }
    public void lambda(int makstall, int deletall) {
        fyllListe(makstall);
        System.out.println("Med lambda");
        talliste.stream().filter(x -> x % deletall == 0).forEach(x -> System.out.println(x));
    }
    public void løkke(int makstall, int deletall) {
        fyllListe(makstall);
        String utstring ="";
        for (int i = 0; i < makstall; i++) {
            int tall = (int)talliste.get(i);
            if (filtrer(tall,deletall)) {
                utstring+=tall;
                utstring+="\n";
            }
        }
        System.out.println("Med løkke");
        System.out.println(utstring);
    }

    @Override
    public boolean filtrer(int tall, int deletall) {
        if (tall % deletall == 0) return true;
        return false;
    }
}
