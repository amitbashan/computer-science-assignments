import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
	// dumb and lazy code
        Scanner scanner = new Scanner(System.in);
        Progression progression1 = new Progression(scanner.nextInt(), scanner.nextInt());
        Progression progression2 = new Progression(scanner.nextInt(), scanner.nextInt());
        Progression progression3 = new Progression(scanner.nextInt(), scanner.nextInt());
        Progression progression4 = new Progression(scanner.nextInt(), scanner.nextInt());
        Progression progression5 = new Progression(scanner.nextInt(), scanner.nextInt());
        Progression progression6 = new Progression(scanner.nextInt(), scanner.nextInt());
        Progression progression7 = new Progression(scanner.nextInt(), scanner.nextInt());

        int prog1 = 0;
        for (int i = 0; i < 5; ++i) {
            prog1 += progression1.getElement(i);
        }

        int prog2 = 0;
        for (int i = 0; i < 5; ++i) {
            prog2 += progression2.getElement(i);
        }

        int prog3 = 0;
        for (int i = 0; i < 5; ++i) {
            prog3 += progression3.getElement(i);
        }

        int prog4 = 0;
        for (int i = 0; i < 5; ++i) {
            prog4 += progression4.getElement(i);
        }

        int prog5 = 0;
        for (int i = 0; i < 5; ++i) {
            prog5 += progression5.getElement(i);
        }

        int prog6 = 0;
        for (int i = 0; i < 5; ++i) {
            prog6 += progression6.getElement(i);
        }

        int prog7 = 0;
        for (int i = 0; i < 5; ++i) {
            prog7 += progression7.getElement(i);
        }

        int highest_sum = Math.max(prog1, Math.max(prog2, Math.max(prog3, Math.max(prog4, Math.max(prog5, Math.max(prog6, prog7))))));

        if(prog1 == highest_sum) {
            progression1.showProg(12);
        } else if (prog2 == highest_sum) {
            progression2.showProg(12);
        } else if (prog3 == highest_sum) {
            progression3.showProg(12);
        } else if (prog4 == highest_sum) {
            progression4.showProg(12);
        } else if (prog5 == highest_sum) {
            progression5.showProg(12);
        } else if (prog6 == highest_sum) {
            progression6.showProg(12);
        } else if (prog7 == highest_sum) {
            progression7.showProg(12);
        }
    }
}