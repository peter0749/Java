public class Square extends TwoDimensionalShape {
    private double length;
    Square(double x) { 
        if (x<=0.0) throw new IllegalArgumentException("length must > 0");
        this.length = x;
    }
    @Override
    public double getArea() {
        return length*length;
    }
    
    @Override
    public String toString() {
        return String.format("(length) : (%.2f)", this.length);
    }
}
