import java.util.Scanner;

public class Segment {
    private Point first, second;

    public Segment() {
        this(0, 0, 1, 1);
    }

    public Segment(float second_x, float second_y) {
        this(0, 0, second_x, second_y);
    }

    public Segment(Point p1, Point p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public Segment(float x, float y, Point p) {
        this(x, y, p.getX(), p.getY());
    }

    public Segment(Point p, float x, float y) {
        this(p.getX(), p.getY(), x, y);
    }

    public Segment(Segment segment) {
        this(segment.first.getX(), segment.first.getY(), segment.second.getX(), segment.second.getY());
    }

    public Segment(float first_x, float first_y, float second_x, float second_y) {
        first = new Point(first_x, first_y);
        second = new Point(second_x, second_y);
    }

    public void readSegment() {
        Scanner scanner = new Scanner(System.in);

        float first_x, first_y, second_x, second_y;

        System.out.println("Enter new values for point 1:");
        System.out.print("X: ");
        first_x = scanner.nextFloat();
        System.out.print("Y: ");
        first_y = scanner.nextFloat();

        System.out.println("Enter new values for point 2:");
        System.out.print("X: ");
        second_x = scanner.nextFloat();
        System.out.print("Y: ");
        second_y = scanner.nextFloat();

        first = new Point(first_x, first_y);
        second = new Point(second_x, second_y);
    }

    public Point middle() {
        return new Point(((second.getX() - first.getX()) / 2) + first.getX(), ((second.getY() - first.getY()) / 2) + first.getY());
    }

    public float length() {
        return (float) Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }

    public boolean greaterThan(Segment segment) {
        return length() > segment.length();
    }

    public boolean lessThan(Segment segment) {
        return length() < segment.length();
    }

    public boolean equals(Segment segment) {
        return first.getX() == segment.first.getX() && first.getY() == segment.first.getY() && second.getX() == segment.second.getX() && second.getY() == segment.second.getY();
    }

    public void show() {
        System.out.println("Segment data:");
        System.out.println("Point 1: (" + first.getX() + ", " + first.getY() + ")");
        System.out.println("Point 2: (" + second.getX() + ", " + second.getY() + ")");
        System.out.println("Length: " + length());
    }
}