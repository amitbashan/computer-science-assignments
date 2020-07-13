package Q1;

/**
 * This class represents a door with basic open/close features.
 *
 * @author Netanya Academic College
 * @version 1.0
 * @since Unknown
 */

public class Door {
    private boolean open;

    /**
     * Constructs a Door object and sets it's state to open.
     */
    public Door() {
        this(true);
    }

    /**
     * Constructs a Door object and sets it's state to the given parameter.
     * @param state Opened/closed.
     */
    public Door(boolean state) {
        open = state;
    }

    /**
     * Sets the door's state to open.
     */
    public void open() {
        open = true;
    }

    /**
     * Sets the door's state to closed.
     */
    public void close() {
        open = false;
    }

    /**
     * Returns if the door is either open or closed.
     * @return Door's state.
     */
    public boolean isOpen() {
        return open;
    }
}
