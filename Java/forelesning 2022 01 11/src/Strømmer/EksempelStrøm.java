package Strømmer;

import java.util.ArrayList;
import java.util.Collection;

public class EksempelStrøm {
    public static void main(String[] args) {
        Collection<Integer> samling = new ArrayList<>();
        samling.add(5);
        samling.add(7);
        samling.add(4);
        samling.stream().sorted().forEach(x -> System.out.println(x));
    }
}
