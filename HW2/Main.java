public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c);
        Square s = new Square(3,10);
        System.out.println(s);
        Triangle t=  new Triangle(3,4,5);
        System.out.println(t);
        Sphere sph = new Sphere(10);
        System.out.println(sph);
        Cube cube = new Cube(3,4,5);
        System.out.println(cube);
        Tetrahedron tet = new Tetrahedron(1,2,3,4,5,6,7,8,9,10,11,12);
        System.out.println(tet);
    }
}
