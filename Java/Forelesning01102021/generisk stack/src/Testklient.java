public class Testklient {
    public static void main(String[] args) {
        // Lager et objekt av klassen GeneriskSTack: Vi lager den med String
        GeneriskStack<String> stakken = new GeneriskStack<>();
        // Setter inn noen bynavn.
        stakken.push("Kongsberg");
        stakken.push("Drammen");
        stakken.push("Hønefoss");

        //fjerner øverste objekt.
        System.out.println("Fjerner "+stakken.pop()+" fra stacken");

        System.out.println("Øverst i stacken: "+stakken.peek());
    }
}
