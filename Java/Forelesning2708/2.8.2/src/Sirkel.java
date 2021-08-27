public class Sirkel {
    double radius;
    public Sirkel (double radius) {
        this.radius=radius;
    }
    public void setRadius(int radius) {
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }
    public double getAreal() {
        double areal = Math.PI * Math.pow(radius,2);
        return areal;
    }
}
