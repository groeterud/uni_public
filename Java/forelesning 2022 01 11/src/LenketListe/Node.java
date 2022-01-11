package LenketListe;

public class Node<Type> {
    //Objektet som vi skal sette inn i den lenkede listen
    private Type objekt;
    //referanse til neste node
    private Node<Type> neste;

    // konstruktør
    public Node(Type objekt) {
        this.objekt = objekt;
        neste = null;
    }
    // Metode som returnerer innholdet
    public Type getInnhold() {
        return objekt;
    }

    //Metode som henter referansen til neste node
    public Node<Type> getNeste() {
        return neste;
    }

    //Metode som endrer referansen til neste node
    public void setNeste(Node<Type> neste) {
        this.neste = neste;
    }
}
