import java.util.Arrays;

public class Oppgaveversikt {
    /*
    DOCSTRING

     */
    private Student[] studenter = new Student[2];
    private int antallStud=0;

    public boolean nyStudent (Student o) {
        if (antallStud < studenter.length) {
            studenter[antallStud]=o;
            antallStud++;
            return true;
        }
        else return false;
    }
    public void sorter() {
        //Bruker Arrays
        Arrays.sort(studenter);
    }

    public int getAntallStud() {
        return antallStud;
    }
    public Student finnStudent(String søkenavn) {
        String navn;
        for (int i = 0; i < studenter.length; i++) {
            navn=studenter[i].getNavn();
            if (søkenavn.equals(navn)) return studenter[i];
        }
        return null;
    }

    public int getAntallStudentOppgaver (String søkenavn) {
        // finn studenten.
        Student student = finnStudent(søkenavn);
        if (student!=null) {
            return student.getAntallOppgaver();
        }
        else return -1;
    }

    // metode som setter antall oppgaver for en angitt person.
    public boolean setAntallStudOppgaver (String navn, int antall) {
        Student student = finnStudent(navn);
        if (student != null) {
            student.setAntallOppgaver(antall);
            return true;
        }
        return false;
    }

    public boolean økAntallStudOppgaver (String navn) {
        Student student = finnStudent(navn);
        if (student!= null) {
            int antall=student.getAntallOppgaver();
            antall++;
            student.setAntallOppgaver(antall);
            return true;
        }
        return false;
    }
    public String toSring() {
        String uttekst =""; // "tom" tekst
        for (int i = 0; i < antallStud; i++) {
            uttekst+=studenter[i].toString();
            uttekst+="\n";
        }
        return uttekst;
    }
}
