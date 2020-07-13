public class List {
    private ListNode firstNode;
    private ListNode lastNode;
    private String name;

    public List() {
        this("list");
    }

    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    public void insertAtFront(Object insertItem) {
        if (isEmpty())
            firstNode = lastNode = new ListNode(insertItem);
        else
            firstNode = new ListNode(insertItem, firstNode);
    }

    public void insertAtBack(Object insertItem) {
        if (isEmpty())
            firstNode = lastNode = new ListNode(insertItem);
        else
            lastNode = lastNode.nextNode = new ListNode(insertItem);
    }

    public Object removeFromFront() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException(name);
        Object removedItem = firstNode.data;

        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;
        return removedItem;
    }

    public Object removeFromBack() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException(name);

        Object removedItem = lastNode.data;
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else {
            ListNode current = firstNode;

            while (current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current;
            current.nextNode = null;
        }
        return removedItem;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.print("Empty " + name);
            return;
        }
        System.out.print("The " + name + " is : ");
        ListNode current = firstNode;

        while (current != null) {
            System.out.printf("%s", current.data);
            current = current.nextNode;
        }
        System.out.println("\n");
    }

    // helper function
    public int length() {
        int result = 0;
        ListNode currentNode = firstNode;

        while (currentNode != null) {
            ++result;
            currentNode = currentNode.getNext();
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ListNode currentNode = firstNode;
        stringBuilder.append(String.format("(%s, ", currentNode.data));
        currentNode = currentNode.getNext();

        while (currentNode != null) {
            if (currentNode == lastNode) {
                stringBuilder.append(String.format("%s)", currentNode.data));
            } else {
                stringBuilder.append(String.format("%s, ", currentNode.data));
            }

            currentNode = currentNode.getNext();
        }

        return stringBuilder.toString();
    }

    public ListNode removeAt(int k) throws ListIndexOutOfBoundsException {
        if (k < 0 || k > length()) {
            throw new ListIndexOutOfBoundsException();
        }

        int counter = 1;
        ListNode result = null;
        ListNode currentNode = firstNode;

        while (currentNode != null) {
            if (counter + 1 == k) {
                result = currentNode.getNext();
                currentNode.nextNode = currentNode.getNext().getNext();
                break;
            }

            ++counter;
            currentNode = currentNode.getNext();
        }

        return result;
    }

    public void show() {
        if (firstNode == null)
            return;
        else
            firstNode.show();
    }

    public void showRev() {
        if (firstNode == null)
            return;
        else
            firstNode.showRev();
    }

    public void addAt(Object obj, int k) throws ListIndexOutOfBoundsException {
        if (k < 0 || k > length()) {
            throw new ListIndexOutOfBoundsException();
        }

        int counter = 1;
        ListNode currentNode = firstNode;

        while (currentNode != null) {
            if (counter + 1 == k) {
                currentNode.nextNode = new ListNode(obj, currentNode.nextNode);
                break;
            }

            ++counter;
            currentNode = currentNode.getNext();
        }
    }

    public Object[] toArray() {
        Object[] result = new Object[length()];

        ListNode currentNode = firstNode;

        int index = 0;

        while (currentNode != null) {
            result[index] = currentNode.getObject();
            currentNode = currentNode.getNext();
            ++index;
        }

        return result;
    }
}
