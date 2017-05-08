public class Tetrahedron extends ThreeDimensionalShape {
    private double x1, y1, z1;
    private double x2, y2, z2;
    private double x3, y3, z3;
    private double x4, y4, z4;
    Tetrahedron(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3, double x4, double y4, double z4) {
        this.x1 = x1; this.y1 = y1; this.z1=z1;
        this.x2 = x2; this.y2 = y2; this.z2=z2;
        this.x3 = x3; this.y3 = y3; this.z3=z3;
        this.x4 = x4; this.y4 = y4; this.z4=z4;
    }
    private double _dist(double x1, double y1, double z1, double x2, double y2, double z2) {
        double a=x1-x2, b=y1-y2, c=z1-z2;
        return Math.sqrt( a*a + b*b + c*c );
    }
    private double _hero(double a, double b, double c) {
        double s = (a+b+c)/2.0;
        return Math.sqrt( s*(s-a)*(s-b)*(s-c) );
    }
    @Override
    public double getVolume() {
        // det:
        // x2-x1, y2-y1, z2-z1
        // x3-x1, y3-y1, z3-z1
        // x4-x1, y4-y1, z4-z1
        double a00=x2-x1, a01=y2-y1, a02=z2-z1;
        double a10=x3-x1, a11=y3-y1, a12=z3-z1;
        double a20=x4-x1, a21=y4-y1, a22=z4-z1;
        double det = (a00*a11*a22+a01*a12*a20+a02*a10*a21) -
                     (a02*a11*a20+a00*a12*a21+a01*a10*a22);
        return Math.abs(det)/6.0;
    }
    @Override
    public double getArea() {
        double l12=_dist(x1,y1,z1,x2,y2,z2),
               l13=_dist(x1,y1,z1,x3,y3,z3),
               l14=_dist(x1,y1,z1,x4,y4,z4),
               l23=_dist(x2,y2,z2,x3,y3,z3),
               l24=_dist(x2,y2,z2,x4,y4,z4),
               l34=_dist(x3,y3,z3,x4,y4,z4);
        double sum = _hero(l12,l13,l23) + _hero(l13,l14,l34) +
                     _hero(l12,l14,l24) + _hero(l23,l24,l34);
        return sum;
    }
    @Override
    public String toString() {
        return String.format("Vertices: {\n (%.2f , %.2f , %.2f),\n (%.2f , %.2f , %.2f),\n (%.2f , %.2f , %.2f),\n (%.2f , %.2f , %.2f)\n}", x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
    }

}
