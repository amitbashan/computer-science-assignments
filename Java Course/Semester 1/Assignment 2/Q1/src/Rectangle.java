public class Rectangle {
    private int x, y, height, width;

    public Rectangle(int a, int b, int c, int d) {
        x = a;
        y = b;
        height = c;
        width = d;
    }

    public Rectangle() {
	this(0, 0, 1, 1);
    }

    public Rectangle(int a, int b) {
        x = a;
        y = b;
        height = width = 1;
    }

    public int getArea() {
        return height * width;
    }

    public int getPerimiter() {
        return 2 * (height + width);
    }

    public void show() {
        System.out.println("x=" + x + ", " + "y=" + y + ", " + "width=" + width + ", " + "height=" + height);
    }

    public void moveTo(int a, int b) {
        x = a;
        y = b;
    }

    public boolean isInside(int a, int b) {
        return a > x && a < x + width && b > y && b < y + height;
    }

    public double getDiagonalLength() {
        return Math.sqrt((height * height) + (width * width));
    }

    public boolean isSquare() {
        return height == width;
    }

    public boolean isGolden() {
        return width == height * 1.618;
    }
}