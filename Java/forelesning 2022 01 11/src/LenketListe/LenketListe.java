package LenketListe;

public class LenketListe<Type> {
    //Deklarerer starten på en liste som består av noder
    private Node<Type> hode;

    //Metode for å sette inn i listen
    public void settInnFørst(Type objekt) {
        //Alltid sjekke om det er noe i listen
        if (hode==null) hode=new Node(objekt);
        else {
            Node<Type> ny = new Node(objekt);
            ny.setNeste(hode); // lagrer referanse til nåværende hode det nye hodet
            hode=ny; // overskriver referansen til hodet
        }
    }

    //Metode for å slette første node
    public void slettFørste() {
        if(hode != null) hode = hode.getNeste();
    }

    // lager en toString() for den lenkede listen


    @Override
    public String toString() {
        String tekst ="";
        Node peker = hode;
        while (peker!=null) {
            tekst+= peker.getInnhold().toString()+"\n";
            peker=peker.getNeste();
        }
        return tekst;
    }
}
