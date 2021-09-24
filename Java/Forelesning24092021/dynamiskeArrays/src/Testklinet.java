public class Testklinet {
    public static void main(String[] args) {
        MinArray minarray = new MinArray();

        minarray.settInn("kake");
        minarray.settInn("kaffe");
        minarray.settInn("teip");

        for (int i = 0; i < minarray.getAntall(); i++) {
            System.out.println(minarray.getObject(i));
        }
    }
}
