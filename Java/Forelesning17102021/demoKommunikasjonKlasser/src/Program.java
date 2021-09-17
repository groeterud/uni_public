public class Program {
    public static void main(String[] args) {
        int tall_en=1;
        int tall_to=5;
        Summerer s = new Summerer(tall_en,tall_to);
        Summerer s2 = new Summerer(10,15);

        s.setTall_en(4);

        System.out.println(s.getTall_en());



    }

}
