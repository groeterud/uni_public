public class Student implements Comparable<Student>{
    private String navn;
    private int antallOppgaver;

    public Student(String navn, int antallOppgaver) {
        this.navn = navn;
        this.antallOppgaver = antallOppgaver;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAntallOppgaver() {
        return antallOppgaver;
    }

    public void setAntallOppgaver(int antallOppgaver) {
        this.antallOppgaver = antallOppgaver;
    }

    @Override
    public String toString() {
        return "Student{" +
                "navn='" + navn + '\'' +
                ", antallOppgaver=" + antallOppgaver +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.navn.compareTo(o.getNavn());
    }

    public boolean equals (Student o) {
        return this.navn.equals(o.getNavn());
    }
}
