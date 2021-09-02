import java.util.Formatter;

public class Fond {
    double rente;
    double verdi;
    double innsats;
    double last_year;
    double sum_skatt;
    double total_innsats;
    boolean aksje;
    public Fond (double rente,double innsats, boolean aksje) {
        this.rente=rente;
        this.innsats=innsats;
        this.verdi=innsats;
        this.last_year=0.00;
        this.aksje=aksje;
    }
    public double getRente() {
        return rente;
    }
    public double getLast_year() {return last_year;}
    public double getVerdi() {
        return verdi;
    }
    public void setRente(double rente) {
        this.rente = rente;
    }
    public void setVerdi(double verdi) {
        this.verdi = verdi;
    }
    public double getSumSkatt() {
        return sum_skatt;
    }

    public void nyMåned() {
        verdi = verdi * rente;
        verdi = verdi + innsats;
        total_innsats+=innsats;
    }
    public double nyttÅr() {
        double profitt = verdi - last_year;
        if (aksje==true) {
            double skatt = profitt * 0.22;//Du skal skatte 22% av årlig fortjeneste, selv om du ikke selger!
            sum_skatt += skatt;
            verdi = verdi - skatt;
            last_year = verdi;
            System.out.println("Betalte kr: "+(int)skatt+" i skatt");
        }
        return profitt;
    }
    public void selg() {
        double sluttSkatt=0.3681; // når du selger skal du skatte av 36.81% av fortjeneste!
        double total_fortjeneste=verdi-total_innsats;
        double sluttSkattSum=total_fortjeneste*sluttSkatt;
        sum_skatt=+sluttSkattSum;
        verdi=verdi-sluttSkattSum;
    }

    @Override
    public String toString() {
        Formatter fmt_verdi = new Formatter();
        Formatter fmt_sum_skatt = new Formatter();

        fmt_verdi.format("%.2f",verdi);
        fmt_sum_skatt.format("%.2f",sum_skatt);

        return "Fond{" +
                "rente=" + rente +
                ", verdi=" + fmt_verdi.toString() +
                ", innsats=" + innsats +
                ", sum_skatt=" + fmt_sum_skatt.toString() +
                '}';
    }
}
