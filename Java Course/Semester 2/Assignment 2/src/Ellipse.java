public class Ellipse extends TwoDimensionalShape {
    private final double a, b;

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public boolean equals(Shape shape) {
        if (shape == null || shape.getClass() != Ellipse.class) return false;

        return ((Ellipse) shape).a == a && ((Ellipse) shape).b == b;
    }


    @Override
    public double area() {
        return Math.PI * a * b;
    }

    public double perimeter() {
        return 2 * Math.PI * Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)) / 2.0);
    }

    @Override
    public String toString() {
        return String.format("A = %f, B = %f", a, b);
    }
}
