import java.util.Scanner;

class Rectangle {
    private int height, width;

    public Rectangle(int h, int w) {
        this.height = h;
        this.width = w;
    }

    public void drawFilled() {
        for (int i = 0; i < height; ++i) {
            System.out.print('*');
            for (int b = 0; b < width - 2; ++b) {
                System.out.print('*');
            }
            System.out.println('*');
        }
        System.out.println();
    }

    public void drawEmpty() {
        for (int i = 0; i < width; ++i) {
            System.out.print('*');
        }
        System.out.println();
        for (int i = 0; i < height - 2; ++i) {
            System.out.print('*');
            for (int b = 0; b < width - 2; ++b) {
                System.out.print(' ');
            }
            System.out.println('*');
        }
        for (int i = 0; i < width; ++i) {
            System.out.print('*');
        }
        System.out.println();
    }

    public void drawFilled(char prefix) {
        for (int i = 0; i < height; ++i) {
            if (width != 1) System.out.print(prefix);
            for (int b = 0; b < width - 2; ++b) {
                System.out.print(prefix);
            }
            System.out.println(prefix);
        }
    }

    public void drawEmpty(char prefix) {
        for (int i = 0; i < width; ++i) {
            System.out.print(prefix);
        }
        System.out.println();
        for (int i = 0; i < height - 2; ++i) {
            System.out.print(prefix);
            for (int b = 0; b < width - 2; ++b) {
                System.out.print(' ');
            }
            System.out.println(prefix);
        }
        for (int i = 0; i < width; ++i) {
            System.out.print(prefix);
        }
        System.out.println();
    }

    public void readRectFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter new width");
        width = scanner.nextInt();
        System.out.println("Please enter new height");
        height = scanner.nextInt();
    }
}