import java.util.ArrayList;

public class Forsterker extends Stereoutstyr{
    private int antallWatt;

    public Forsterker(int serienummer, String produktnavn, String EAN, int antallWatt) {
        super(serienummer, produktnavn, EAN);
        this.antallWatt = antallWatt;
    }

    public int getAntallWatt() {
        return antallWatt;
    }

    public void setAntallWatt(int antallWatt) {
        this.antallWatt = antallWatt;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Forsterker{" +
                "antallWatt=" + antallWatt +
                '}';
    }
}
