public class Square extends Rectangle {
    private final double length;

    public Square(double length) {
        super(length, length);
        this.length = length;
    }

    public boolean equals(Shape shape) {
        if (shape == null || shape.getClass() != Square.class) return false;

        return ((Square) shape).length == length;
    }

    @Override
    public String toString() {
        return String.format("Length = %f", length);
    }
}
