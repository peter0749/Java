public class Triangle extends TwoDimensionalShape {
    private double l1, l2, l3;
    Triangle(double a, double b, double c) { 
        if (a+b<=c) throw new IllegalArgumentException("error: arg1 + arg2 > arg3 must hold"); 
        this.l1 = a;
        this.l2 = b;
        this.l3 = c;
    }
    @Override
    public double getArea() {
        double s = (l1+l2+l3)/2.0;
        return Math.sqrt( s*(s-l1)*(s-l2)*(s-l3) );
    }
    
    @Override
    public String toString() {
        return String.format("(line1 , line2 , line3) : (%.2f , %.2f , %.2f)", this.l1, this.l2, this.l3);
    }
}
