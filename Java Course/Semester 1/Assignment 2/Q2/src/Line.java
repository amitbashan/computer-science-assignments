public class Line {
    private double x1, y1, x2, y2;

    public Line() {
        y1 = 1.0;
        x2 = 4.0;
        y2 = 3.0;
    }

    public Line(double a, double b, double c, double d) {
        x1 = a;
        y1 = b;
        x2 = c;
        y2 = d;
    }

    public Line(double a, double b) {
        x1 = a;
        y1 = b;
    }

    public void show() {
        System.out.println("(" + Double.toString(x1) + "," + Double.toString(y1) + ")-(" + Double.toString(x2) + "," + Double.toString(y2) + ")");
    }

    public double getSlope() {
        return (y2 - y1) / (x2 - x1);
    }

    public boolean isOnLine(double x, double y) {
        return (x - x1) / (x2 - x1) == (y - y1) / (y2 - y1);
    }
}