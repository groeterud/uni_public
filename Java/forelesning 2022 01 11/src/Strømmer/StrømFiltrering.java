package Strømmer;

import java.util.ArrayList;
import java.util.Collection;

public class StrømFiltrering {
    public static void main(String[] args) {
        Collection<Integer> samling = new ArrayList<>();
        samling.add(5);
        samling.add(8);
        samling.add(7);
        samling.add(4);
        System.out.println("Skriver ut sortert med sorted();");
        samling.stream().sorted().forEach(x->System.out.println(x));
        System.out.println("Filtrerer på partall:");
        samling.stream().filter(x->x%2==0).forEach(x->System.out.println(x));
        System.out.println("\n Filtrerer på Oddetall:");
        samling.stream().filter(x->x%2!=0).forEach(x->System.out.println(x));
    }
}
