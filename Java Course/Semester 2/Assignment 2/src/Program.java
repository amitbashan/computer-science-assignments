import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        DrawingBoard test = new DrawingBoard(3);

        test.add(new Cube(3), new Sphere(5),new Sphere(5), new Circle(2), new Cube(2), new RightAngledTriangle(3,7), new Rectangle(2, 54));
        System.out.println(test.getMax3DV1().getClass().getName());
        System.out.println(test.getMax3DV2().getClass().getName());
        System.out.println(test.getMax().getClass().getName());
        System.out.println(Arrays.toString(test.getTypes()));
        test.showAll();
    }
}
