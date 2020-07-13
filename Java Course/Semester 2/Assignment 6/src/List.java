public class List<T> implements MinMax<T> {
    private ListItem<T> head;

    public List() {
        head = null;
    }

    public void addItem(T info) {
        head = new ListItem<>(info, head);
    }

    public T firstElm() {
        return head.getElm();
    }

    @Override
    public T min() {
        T min = head.getElm();

        ListItem<T> currentItem = head;

        while (currentItem != null) {
            if (compareTo(currentItem.getElm(), min) < 0) {
                min = currentItem.getElm();
            }

            currentItem = currentItem.getNext();
        }

        return min;
    }

    @Override
    public T max() {
        T max = head.getElm();

        ListItem<T> currentItem = head;

        while (currentItem != null) {
            if (compareTo(currentItem.getElm(), max) == 1) {
                max = currentItem.getElm();
            }

            currentItem = currentItem.getNext();
        }

        return max;
    }

    public int compareTo(T object, T item) {
        if (item == null) return 1;
        if (object == null) return -1;

        if (object instanceof Comparable) { // If object inherits Comparable, item must inherit it too because they are the same type.
            Comparable comparable = (Comparable) object;
            return comparable.compareTo(item);
        } else {
            if (object == item) {
                return 0;
            }
        }

        // How can I check if the object is
        // less than/greater than if it's type is unknown?
        return -2; // Custom return code
    }

    @Override
    public int compareTo(T object) {
        if (object == null) return 1;

        if (object instanceof Comparable) {
            Comparable comparable = (Comparable) object;
            return comparable.compareTo(head.getElm());
        } else {
            if (object == head.getElm()) {
                return 0;
            }
        }

        return -2;
    }
}
