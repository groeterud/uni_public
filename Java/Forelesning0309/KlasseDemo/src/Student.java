public class Student extends Person{
    String bachelorprogram;

    public Student(String navn, String adresse, int alder, String bachelorprogram) {
        super(navn, adresse, alder);
        this.bachelorprogram = bachelorprogram;
    }

    public String getBachelorprogram() {
        return bachelorprogram;
    }

    public void setBachelorprogram(String bachelorprogram) {
        this.bachelorprogram = bachelorprogram;
    }

    @Override
    public String toString() {
        return super.toString()+"Student{" +
                "bachelorprogram='" + bachelorprogram + '\'' +
                '}';
    }
}
