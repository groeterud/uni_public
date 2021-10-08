import java.util.ArrayList;

public class TestKlient {
    public static void main(String[] args) {
        Kontroll kontroll = new Kontroll();

        Kjøretøy k = new Kjøretøy("SV1234","Volvo","V70",1991);
        Personbil p = new Personbil("SV54321","Hyundai","Sonata",2005,5);
        Lastebil l = new Lastebil("HY2234","VOLVO","XY13",2017,5000);

        kontroll.nyttKjøretøy(k);
        kontroll.nyttKjøretøy(p);
        kontroll.nyttKjøretøy(l);
        kontroll.sorter();

        System.out.println(kontroll.finnKjøretøy("SV1234"));


        ArrayList kjøretøy = kontroll.getList();

        for (int i = 0; i < kjøretøy.size(); i++) {
            String k_denne=kjøretøy.get(i).toString();
            System.out.println(k_denne);
        }
    }
}
