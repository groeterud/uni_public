package binærtre;

public class Node{
    //lager en ikke-generisk node:
    private int verdi;
    private Node venstre;
    private Node høyre;
    private Node foreldre;

    public Node(int verdi) {
        this.verdi = verdi;
    }
    //konstruktør 2
    public Node(int verdi, Node foreldre) {
        this.verdi = verdi;
        this.foreldre = foreldre;
    }


    //rekursive metode
    public void settInn(int nyverdi) {
        //sjekker om verdien i noden er større enn ny verdi. I så all skal nyverdi settes inn til venstre.
        if (verdi >= nyverdi) {
            //om det ikke er noe til venstre, opprett ny node ned til venstre.
            if (venstre == null) venstre = new Node(nyverdi,this);
            // ellers, kall venstre sinn settInn-metode.
            else venstre.settInn(nyverdi);
        }
        else {
            if (høyre != null) {
                høyre.settInn(nyverdi);
            }
            else {
                høyre = new Node(nyverdi,this);
            }
        }
    }
    public boolean søkVerdi (int søkeverdi) {
        if (verdi==søkeverdi) return true;
        if ( verdi >= søkeverdi) {
            //søk til venstre:
            if (venstre!=null) return venstre.søkVerdi(søkeverdi);
            else return false;
        }
        else {
            if (høyre!=null) {
                return høyre.søkVerdi(søkeverdi);
            }
            else return false;
        }
    }
    public String toString() {
        //lager en tom streng
        String returstreng="";
        returstreng+=verdi+"\t";
        if (venstre!=null) {
            returstreng+=venstre.toString();
        }
        if (høyre!=null){
            returstreng+= høyre.toString();
        }
        return returstreng;
    }
}
