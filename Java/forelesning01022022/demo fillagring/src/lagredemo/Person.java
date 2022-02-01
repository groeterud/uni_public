package lagredemo;

public class Person {
    private String fornavn;
    private String etternavn;
    private int fødselsår;

    public Person(String fornavn, String etternavn, int fødselsår) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fødselsår = fødselsår;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public int getFødselsår() {
        return fødselsår;
    }

    public void setFødselsår(int fødselsår) {
        this.fødselsår = fødselsår;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", fødselsår=" + fødselsår +
                '}';
    }

    public String toFile() {
        return fornavn+","+etternavn+","+fødselsår;
    }
}
