import java.util.Objects;

public class Student {
    private int studnr;
    private String navn;
    private Poststed poststed;

    public Student(int studnr, String navn, Poststed poststed) {
        super();
        this.studnr = studnr;
        this.navn = navn;
        this.poststed = poststed;
    }

    public int getStudnr() {
        return studnr;
    }

    public void setStudnr(int studnr) {
        this.studnr = studnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Poststed getPoststed() {
        return poststed;
    }

    public void setPoststed(Poststed poststed) {
        this.poststed = poststed;
    }

    public boolean equals(Poststed denAndre) {
        return poststed.getStedsnavn() == denAndre.getStedsnavn();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studnr=" + studnr +
                ", navn='" + navn + '\'' +
                ", poststed=" + poststed.toString() +
                '}';
    }
}
