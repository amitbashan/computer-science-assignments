import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws ListIndexOutOfBoundsException {
        List list = new List();

        list.insertAtBack("Hi");
        list.insertAtBack("Test");
        list.insertAtBack("Hello world");
        list.insertAtBack("123");
        list.insertAtBack("!@#$%");

        System.out.println(list);
        System.out.println(list.length());
        System.out.println(list.removeAt(3).getObject());
        System.out.println(list);
        System.out.println();
        list.showRev();
        System.out.println();
        list.show();
        list.addAt("???????", 3);
        System.out.println(list);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println();
        System.out.println();
        System.out.println();
        Stack<Integer> stack = new Stack<>(5);
        stack.push(12345);
        stack.push(5123);
        stack.push(52354);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        Stack<Stack<Integer>> stack1 = new Stack<>(5);
        stack1.push(stack);
        Object poppedObject = stack1.pop();
        Stack castedObject = (Stack) poppedObject;
        System.out.println(castedObject.pop());
    }
}