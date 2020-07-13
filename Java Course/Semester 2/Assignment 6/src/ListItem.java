public class ListItem<T> {
    private ListItem<T> next;
    private T info;

    public ListItem(T info, ListItem next) {
        this.info = info;
        this.next = next;
    }

    public T getElm() {
        return info;
    }

    public ListItem<T> getNext() {
        return next;
    }
}
