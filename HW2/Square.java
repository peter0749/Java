public class Square extends TwoDimensionalShape {
    private double width, height;
    Square(double x, double y) { 
        this.width = x;
        this.height = y;
    }
    @Override
    public double getArea() {
        return width*height;
    }
    
    @Override
    public String toString() {
        return String.format("(%.2f , %.2f)", this.width, this.height);
    }
}
