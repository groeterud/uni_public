public class TegnKontroll {
    public String lagVerdier(char start,char slutt) {
        int startverdi = (int) start;
        int sluttverdi = (int) slutt;

        String s = "";

        for (int i = startverdi; i < sluttverdi; i++) {
            char currTall=(char)i;
            s+="Tegnet "+currTall+" har tallverdien "+i+"\n";
        }
        return s;
    }
}
