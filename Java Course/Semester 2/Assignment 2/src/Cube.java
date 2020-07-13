public class Cube extends ThreeDimensionalShape {
    private final double length;

    public Cube(double length) {
        this.length = length;
    }

    public boolean equals(Shape shape) {
        if (shape == null || shape.getClass() != Cube.class) return false;

        return ((Cube) shape).length == length;
    }

    @Override
    public double area() {
        return 6 * Math.pow(length, 2);
    }

    public double volume() {
        return Math.pow(length, 3);
    }

    @Override
    public String toString() {
        return String.format("Length = %f", length);
    }
}
