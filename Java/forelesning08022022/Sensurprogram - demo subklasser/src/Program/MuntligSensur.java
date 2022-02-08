package Program;

public class MuntligSensur extends Sensur {
    private double lengde;

    public MuntligSensur(String fag, String eksamenstype, double lengde) {
        super(fag, eksamenstype);
        this.lengde = lengde;
    }

    @Override
    public double beregnTidsforbruk() {
        return lengde + FORBEREDELSE;
    }

    @Override
    public String toString() {
        return super.toString()+"MuntligSensur{" +
                "lengde=" + lengde +
                '}';
    }
    public String toFile() {
        return "M"+","+super.toFile()+','+lengde;
    }
}
