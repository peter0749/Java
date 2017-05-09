public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        Square s = new Square(3,10);
        Triangle t=  new Triangle(3,4,5);
        Sphere sph = new Sphere(10);
        Cube cube = new Cube(3,4,5);
        Tetrahedron tet = new Tetrahedron(
                                            0,0,0,
                                            1,1,0,
                                            0,1,1,
                                            1,0,1
                                         );
        Shape[] shapeArray= { c, s, t, sph, cube, tet };
        for(Shape inst:shapeArray) {
            System.out.println("This is a "+inst.getClass().getName()+".");
            System.out.println(inst);
            System.out.println("Area: "+inst.getArea());
            if ( inst instanceof ThreeDimensionalShape ) {
                System.out.println("Volume: "+((ThreeDimensionalShape)inst).getVolume());
            }
            System.out.println("This object is a "+(inst instanceof ThreeDimensionalShape?"3D":"2D")+" object.\n");
        }
    }
}
