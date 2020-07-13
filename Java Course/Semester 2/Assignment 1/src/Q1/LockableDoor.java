package Q1;

/**
 * LockableDoor represents a Door object with lock/unlock features.
 *
 * @author Amit Bashan
 * @version 1.0
 * @since 4-15-2020
 */

public class LockableDoor extends Door {
    private boolean locked;

    /**
     * Constructs a LockableDoor object and sets it's state to open and unlocked.
     */
    public LockableDoor() {
        super();
        locked = false;
    }

    /**
     * Sets the door's state to open only if it's unlocked.
     */
    public void open() {
        if (!locked) super.open();
        else System.out.println("You can't open a locked door.");
    }

    /**
     * Sets the door's state to closed.
     */
    public void close() {
        if (super.isOpen()) super.close();
    }

    /**
     * Sets the door's state to locked.
     */
    public void lock() {
        if (!super.isOpen()) locked = true;
        else System.out.println("You can't lock an opened door.");
    }

    /**
     * Sets the door's state to unlocked.
     */
    public void unlock() {
        if (!super.isOpen()) locked = false;
    }

    /**
     * Prints the current door state.
     */
    public void show() {
        if (locked) System.out.println("Door is locked and closed.");
        else if (!super.isOpen()) System.out.println("Door is unlocked and closed.");
        else if (!locked && super.isOpen()) System.out.println("Door is unlocked and open.");
    }
}
