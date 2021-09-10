public class TegnKontroll {
    // lagTrekant(int linjer)
    public String tegnTrekant (int linjer) {
        String s ="";
        int antall_sterner=1;
        for (int i = 0; i < linjer; i++) {
            for (int j = 0; j < antall_sterner; j++) {
                s+="*";
            }
            antall_sterner++;
            s+="\n";
        }
        return s;
    }
    public String tegnPyramide (int linjer) {
        // do the thing
        String pyramide ="";
        for (int i = 1; i < linjer*2; i+=2) {
            //Indre løkker skriver mellomrom til der stjernene skal start
            for (int j = 0; j < (linjer-i/2); j++) {
                pyramide+=" ";
            }
            //indre løkke for å skrive stjernene
            for (int k = 0; k < i; k++) {
                pyramide+="*";
            }
            pyramide+="\n";
        }
        return pyramide;
    }
}
