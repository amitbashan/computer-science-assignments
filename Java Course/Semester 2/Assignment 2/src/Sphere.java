public class Sphere extends ThreeDimensionalShape {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public boolean equals(Shape shape) {
        if (shape == null || shape.getClass() != Sphere.class) return false;

        return ((Sphere) shape).radius == radius;
    }

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return String.format("Radius = %f", radius);
    }
}
