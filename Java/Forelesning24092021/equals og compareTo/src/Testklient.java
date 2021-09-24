public class Testklient {
    public static void main(String[] args) {
        Poststed p1 = new Poststed(3502, "Hønefoss");
        Poststed p2 = new Poststed(3511, "Hønefoss");
        Poststed p3 = new Poststed(3502, "Aardalsaasen");

        if (p1.equals(p2)) System.out.println("p1 og p2 har begge postnr "+p1.getPostnr());
        else System.out.println("p1 og p2 har ikke samme postnr");

        if (p1.equals(p3)) System.out.println("p1 og p3 har begge postnr "+p1.getPostnr());
        else System.out.println("p1 og p3 har ikke samme postnr");

        if (p2.equals(p3)) System.out.println("p2 og p3 har begge postnr "+p2.getPostnr());
        else System.out.println("p2 og p3 har ikke samme postnr");

        Student s1 = new Student(240214, "Sime Veiavågen", p1);
        if (s1.equals(p1)) System.out.println("Suksess");

        System.out.println(p1.compareTo(p2));
        System.out.println(p1.compareTo(p3));
    }
}
