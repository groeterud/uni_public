public class Kvadrat implements Figur{
    private double side;

    public Kvadrat(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double beregnAreal() {
        return side*side;
    }
}
