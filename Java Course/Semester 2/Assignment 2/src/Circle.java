public class Circle extends TwoDimensionalShape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public boolean equals(Shape shape) {
        if (shape == null || shape.getClass() != Circle.class) return false;

        return ((Circle) shape).radius == radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Radius = %f", radius);
    }
}
