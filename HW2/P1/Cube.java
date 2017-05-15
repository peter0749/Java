public class Cube extends ThreeDimensionalShape {
    private double length;
    Cube(double x) { 
        if (x<=0.0) throw new IllegalArgumentException("length must > 0");
        this.length = x;
    }
    @Override
    public double getVolume() {
        return length*length*length;
    }
    @Override
    public double getArea() {
        return length*length*6.0;
    }
    
    @Override
    public String toString() {
        return String.format("(length) : (%.2f)", this.length);
    }
}
