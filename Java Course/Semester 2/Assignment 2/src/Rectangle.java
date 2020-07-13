public class Rectangle extends TwoDimensionalShape {
    private final double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public boolean equals(Shape shape) {
        if (shape == null || shape.getClass() != Rectangle.class) return false;

        return ((Rectangle) shape).a == a && ((Rectangle) shape).b == b;
    }

    @Override
    public double area() {
        return a * b;
    }

    public double perimeter() {
        return 2 * (a + b);
    }

    @Override
    public String toString() {
        return String.format("A = %f, B = %f", a, b);
    }
}
