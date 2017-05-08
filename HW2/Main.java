public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c+" "+c.getArea());
        Square s = new Square(3,10);
        System.out.println(s+" "+s.getArea());
        Triangle t=  new Triangle(3,4,5);
        System.out.println(t+" "+t.getArea());
        Sphere sph = new Sphere(10);
        System.out.println(sph+" "+sph.getArea()+" "+sph.getVolume());
        Cube cube = new Cube(3,4,5);
        System.out.println(cube+" "+cube.getArea()+" "+cube.getVolume());
        Tetrahedron tet = new Tetrahedron(0,0,0,
                                          1,1,0,
                                          0,1,1,
                                          1,0,1);
        System.out.println(tet);
        System.out.println(tet.getArea());
        System.out.println(tet.getVolume());
    }
}
