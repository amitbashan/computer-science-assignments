import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of sides:");
        int s = scanner.nextInt();
        System.out.println("Please enter number of rolls in the experiment:");
        int r = scanner.nextInt();

        int i = 1;
        while (true) {
            System.out.println("Starting iteration # " + i);
            Die die = new Die(s);
            for (int k = 0; k < r; k++) {
                die.rollDie();
            }
            die.showStatistics();
            if (die.getAllMostFrequents().length >= 1) {
                break;
            } else i++;
        }

        System.out.println("Found multiple max frequency. Experiment ended after # " + i + " iterations");
    }
}