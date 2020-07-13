import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        System.out.println("Enter new set maximal size");
        int maximal_size = scanner.nextInt();
        Set set = new Set(maximal_size);

        while (true) {
            System.out.print("Current set is:");
            set.show();

            System.out.println("Press 0 to exit program.");

            if (!set.isFull()) {
                System.out.println("Press 1 to add new number to set.");
            }

            if (!set.isEmpty()) {
                System.out.println("Press 2 to remove existing number from set.");
            }

            int option = scanner.nextInt();

            if (counter >= 5) {
                if (option == 0) {
                    break;
                }
                if (option == 1) {
                    counter++;
                    System.out.println("Enter number to add to set");
                    int new_num = scanner.nextInt();
                    boolean succeeded = set.add(new_num);
                    if (succeeded) {
                        System.out.println("Adding " + new_num + " succeeded");
                    } else {
                        System.out.println("Adding " + new_num + " failed");
                    }
                }
                if (option == 2) {
                    counter++;
                    System.out.println("Enter number to remove from set");
                    int new_num = scanner.nextInt();
                    boolean succeeded = set.remove(new_num);
                    if (succeeded) {
                        System.out.println("Removing " + new_num + " succeeded");
                    } else {
                        System.out.println("Removing " + new_num + " failed");
                    }
                }
            } else {
                if (option == 0) {
                    break;
                }
                if (option == 1) {
                    counter++;
                    System.out.println("Enter new number to add to set");
                    int new_num = scanner.nextInt();
                    boolean succeeded = set.add(new_num);
                    if (succeeded) {
                        System.out.println("Adding " + new_num + " succeeded");
                    } else {
                        System.out.println("Adding " + new_num + " failed");
                    }
                }
                if (option == 2) {
                    counter++;
                    System.out.println("Enter new number to remove from set");
                    int new_num = scanner.nextInt();
                    boolean succeeded = set.remove(new_num);
                    if (succeeded) {
                        System.out.println("Removing " + new_num + " succeeded");
                    } else {
                        System.out.println("Removing " + new_num + " failed");
                    }
                }
            }
        }
    }
}