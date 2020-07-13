public class RightAngledTriangle extends TwoDimensionalShape {
    private final double a, b;

    public RightAngledTriangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public boolean equals(Shape shape) {
        if (shape == null || shape.getClass() != RightAngledTriangle.class) return false;

        return ((RightAngledTriangle) shape).a == a && ((RightAngledTriangle) shape).b == b;
    }

    @Override
    public double area() {
        return (a * b) / 2.0;
    }

    public double perimeter() {
        return a + b + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    @Override
    public String toString() {
        return String.format("A = %f, B = %f", a, b);
    }
}
