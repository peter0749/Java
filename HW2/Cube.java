public class Cube extends ThreeDimensionalShape {
    private double length, width, height;
    Cube(double x, double y, double z) { 
        this.length = x;
        this.width  = y;
        this.height = z;
    }
    @Override
    public double getVolume() {
        return length*width*height;
    }
    @Override
    public double getArea() {
        double temp = length*width + length*height + width*height;
        return temp*2.0;
    }
    
    @Override
    public String toString() {
        return String.format("(%.2f , %.2f , %.2f)", this.length, this.width, this.height);
    }
}
