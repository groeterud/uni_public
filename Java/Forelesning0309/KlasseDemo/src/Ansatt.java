public class Ansatt extends Person{
    int lønnstrinn;

    public Ansatt(String navn, String adresse, int alder, int lønnstrinn) {
        super(navn, adresse, alder);
        this.lønnstrinn = lønnstrinn;
    }

    public int getLønnstrinn() {
        return lønnstrinn;
    }

    public void setLønnstrinn(int lønnstrinn) {
        this.lønnstrinn = lønnstrinn;
    }

    @Override
    public String toString() {
        return super.toString()+"Ansatt{" +
                "lønnstrinn=" + lønnstrinn +
                '}';
    }
}
