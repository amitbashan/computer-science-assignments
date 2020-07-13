package Q4;

/**
 * Square class
 *
 * @author Amit Bashan
 * @version 1.0
 * @since 4-15-2020
 */

public class Square extends Rect {
    private int length;

    /**
     * Constructs a Square object with given length of a side.
     * @param length Self explanatory.
     */
    public Square(int length) {
        super(length, length);
    }
}
