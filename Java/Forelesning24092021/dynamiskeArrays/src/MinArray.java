public class MinArray {
    private int lengde = 2;
    private Object[] tabell = new Object[lengde];
    private int antall = 0;

    public void settInn(Object o) {
        if (antall==lengde) utvidTabell();
        tabell[antall]=o;
        antall++;
    }

    private void utvidTabell() {
        lengde = lengde*2;
        Object[] temp = new Object[lengde];

        for (int i = 0; i < tabell.length; i++) {
            temp[i]=tabell[i];
        }

        tabell=temp;
    }
    public Object getObject(int indeks) {
        return tabell[indeks];
    }
    public Object[] getInnhold() {
        return tabell;
    }
    public int getAntall() {
        return antall;
    }

}
