public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println("Radius of circle: "+c+"\nArea: "+c.getArea());
        Square s = new Square(3,10);
        System.out.println("Shape of square: "+s+"\nArea: "+s.getArea());
        Triangle t=  new Triangle(3,4,5);
        System.out.println("Shape of triangle: "+t+"\nArea: "+t.getArea());
        Sphere sph = new Sphere(10);
        System.out.println("Shape of sphere: "+sph+"\nArea: "+sph.getArea()+"\nVolume: "+sph.getVolume());
        Cube cube = new Cube(3,4,5);
        System.out.println("Shape of cube: "+cube+"\nArea: "+cube.getArea()+"\nVolume: "+cube.getVolume());
        Tetrahedron tet = new Tetrahedron(
                                            0,0,0,
                                            1,1,0,
                                            0,1,1,
                                            1,0,1
                                         );
        System.out.println("Vertics of tetrahedron: "+tet);
        System.out.println("Area: "+tet.getArea());
        System.out.println("Volume: "+tet.getVolume());
    }
}
