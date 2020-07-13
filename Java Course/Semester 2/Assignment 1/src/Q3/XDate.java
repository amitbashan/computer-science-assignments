package Q3;

import java.util.Date;

/**
 * The class XDate wraps the deprecated java.util.Date class.
 *
 * @author Amit Bashan
 * @version 1.0
 * @since 4-15-2020
 */

class XDate extends Date {

    /**
     * Constructs a XDate object with given day, month and year.
     * @param date Self explanatory.
     * @param month Self explanatory.
     * @param year Self explanatory.
     */
    public XDate(int date, int month, int year) {
        super(year - 1900, month - 1, date);
    }

    /**
     * Returns the month.
     * @return Current month.
     */
    @Override
    public int getMonth() {
        return super.getMonth() + 1;
    }

    /**
     * Returns the year.
     * @return Current year.
     */
    @Override
    public int getYear() {
        return super.getYear() + 1900;
    }

    /**
     * Adds given amount of days to the current date.
     * @param days Self explanatory.
     * @return New XDate object.
     */
    public XDate addDays(int days) {
        return new XDate(this.getDate() + days, this.getMonth(), this.getYear());
    }

    /**
     * Retrieves the current system date.
     * @return Current system date as XDate object.
     */
    public static XDate now() {
        Date date = new Date();
        return new XDate(date.getDate(), date.getMonth() + 1, date.getYear() + 1900);
    }
}
