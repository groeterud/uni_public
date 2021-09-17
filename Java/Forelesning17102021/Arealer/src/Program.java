public class Program {
    public static void main(String[] args) {
        Sirkel s1 = new Sirkel(10);
        Trekant t1 = new Trekant(5,3);
        System.out.println(s1.beregnAreal());
        System.out.println(t1.beregnAreal());
        System.out.println(new Kvadrat(5).beregnAreal());
    }
}
