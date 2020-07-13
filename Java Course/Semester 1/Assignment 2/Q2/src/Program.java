public class Program {
    public static void main(String[] args) {
        Line line = new Line();
        Line parallel = new Line(2.0, 3.0, 4.0, 4.0);
        System.out.println(parallel.getSlope());
        Line perpendicular = new Line(3.0, 3.0, 2.0, 5.0);
        double x = line.getSlope() * perpendicular.getSlope();
        System.out.println(x);
    }
}