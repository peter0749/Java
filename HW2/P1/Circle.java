public class Circle extends TwoDimensionalShape {
    private double radius;
    Circle(double r) { 
        if (r<=0.0) throw new IllegalArgumentException("radius must > 0");
        this.radius=r;
    }
    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
    
    @Override
    public String toString() {
        return String.format("radius: %.2f", this.radius);
    }
}
