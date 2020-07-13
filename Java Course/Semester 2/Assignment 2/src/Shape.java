public abstract class Shape {
    public abstract double area();

    public int compare(Shape shape) {
        if (shape == null) return 1;

        double difference = this.area() - shape.area();

        if (difference < 0) return -1;
        else if (difference > 0) return 1;

        return 0;
    }
}
