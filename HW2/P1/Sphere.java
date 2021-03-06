public class Sphere extends ThreeDimensionalShape {
    private double radius;
    Sphere(double r) {
        if (r<=0.0) throw new IllegalArgumentException("radius must > 0");
        this.radius=r; 
    }
    @Override
    public double getArea() {
        return 4.0*Math.PI*radius*radius;
    }

    @Override
    public double getVolume() {
        return getArea() * radius / 3.0;
    }
    
    @Override
    public String toString() {
        return String.format("radius: %.2f", this.radius);
    }
}
