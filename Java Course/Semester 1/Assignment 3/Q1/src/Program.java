public class Program {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle (6,4);
        r1.drawEmpty('$');
        r1.readRectFromConsole();
        r1.drawFilled('^');
    }
}