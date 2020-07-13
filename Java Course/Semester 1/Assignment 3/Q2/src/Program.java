import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter some number");
        int number = scanner.nextInt();
        System.out.println("The number you entered is " + number);
        if (calc.isSymmetric(number)) {
            System.out.println("The number " + number + " is symmetric");
        } else {
            System.out.println("The number " + number + " is not symmetric");
        }
        int i = number;
        int res = 0;
        while (true) {
            if(calc.isSymmetric(i)) {
                res = i;
                break;
            } else i++;
        }
        System.out.println("The first symmetric number after " + number + " is " + res);
    }
}
