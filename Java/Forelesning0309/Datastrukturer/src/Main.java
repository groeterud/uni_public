import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] talliste= {5,8,2,7,1,3};
        System.out.println("Antall elementer: "+talliste.length);
        for (int i = 0; i < talliste.length; i++) {
            if (i==2){
                talliste[i]=4;
            }
        }
        Arrays.sort(talliste);
        System.out.println(Arrays.toString(talliste));
        for (int i = 0; i < talliste.length; i++) {
            System.out.println(talliste[i]);
        }
        int indeks = Arrays.binarySearch(talliste,4);
        if (indeks>=0) {
            System.out.println("Tallet er i posisjon "+indeks);
        }
        else {
            System.out.println("Tallet finnes ikke");
        }

    }
}
