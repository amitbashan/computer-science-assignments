package Q4;

/**
 * Rectangle class
 *
 * @author Amit Bashan
 * @version 1.0
 * @since 4-15-2020
 */

public class Rect {
    private int width, height;

    /**
     * Constructs a Rect object with given width and height.
     * @param width Self explanatory.
     * @param height Self explanatory.
     */
    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Calculates the area.
     * @return Returns the area of the rectangle.
     */
    public int getArea() {
        return width * height;
    }

    /**
     * Calculates the perimeter.
     * @return Returns the perimeter of the rectangle.
     */
    public int getCirc() {
        return 2 * (width + height);
    }
}
