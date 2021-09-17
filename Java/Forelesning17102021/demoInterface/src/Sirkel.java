public class Sirkel implements Figur{
    private double radius;

    public Sirkel(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double beregnAreal() {
        return Math.PI*Math.pow(radius,2);
    }
}
