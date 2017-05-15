public class Main {
    public static void main(String[] args) {
        if (args.length<1) return;
        Double number = Double.parseDouble(args[0]);
        try {
            Circle c = new Circle(number);
            Square s = new Square(number);
            Triangle t=  new Triangle(number,number,number);
            Sphere sph = new Sphere(number);
            Cube cube = new Cube(number);
            Tetrahedron tet = new Tetrahedron(
                    0,0,0,
                    number,number,0,
                    0,number,number,
                    number,0,number
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
        } catch ( IllegalArgumentException excpt ) {
            System.out.println("!!!Something wrong!!!\n");
            System.out.println(excpt.getMessage());
            System.exit(1);
        }
    }
}
