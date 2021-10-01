public class TestKlient {
    /*
    En testklient skal teste ut alle de valgene
    vi skal kunne foreta i det fremtidige grensesnittet.
     */
    public static void main(String[] args) {
        Oppgaveversikt oversikt = new Oppgaveversikt();
        // lager to student-objekter og sender dem til oppgaveOversikten
        Student student = new Student("Ole",0);
        oversikt.nyStudent(student);
        student = new Student("Lise",2);
        oversikt.nyStudent(student);
        // Det funket?
        System.out.println(oversikt.toSring());

        // kan vi sortere?
        oversikt.sorter();
        System.out.println(oversikt.toSring());

        //kan vi søke?
        String navn = "Ole";
        Student st = oversikt.finnStudent(navn);
        if (st != null)   System.out.println(st.toString());
        // sjekker edgecase
        navn = "ole";
        st = oversikt.finnStudent(navn);
        if (st != null) System.out.println(st.toString()); // Skal ikke skrive ut noe pga liten O
        navn = "kari";
        st = oversikt.finnStudent(navn);
        if (st != null) System.out.println(st.toString()); // Skal ikke skrive ut noe pga kari ikke finnes.

        int antallStudentOppgaver = oversikt.getAntallStudentOppgaver("Ole");
        System.out.println(antallStudentOppgaver);
    }

}
