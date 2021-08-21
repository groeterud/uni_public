package forelesning2008;

public class Person_First_Last {
    String navn;
    String etternavn;

    // Konstruktør med parametere:
    public Person_First_Last(String navn, String etternavn) {
        this.navn=navn;
        this.etternavn=etternavn;
    }// end constructor

    // Setter for navn, dersom du har annerledes navn på parameteret så behover man ikke this
    public void set_navn (String navn) {
        this.navn=navn;
    }
    //Setter for alder
    public void set_etternavn(String ny_etternavn) {
        etternavn=ny_etternavn;
    }
    //Getter for navn
    public String get_navn() {
        return navn;
    }
    public String get_etternavn() {
        return etternavn;
    }
    //toString er en standard metode i OOP
    public String toString() {
        return "*************\nNavn: " + navn +" "+etternavn+"\n*************";
    }
}
