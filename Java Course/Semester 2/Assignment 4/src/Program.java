public class Program {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2,3);
        m1.read();
        Matrix m2 = new Matrix(1,6);
        Matrix clone = m1.clone();
        System.out.println(m1.equals(m2));
        System.out.println(m1.equals(clone));
        System.out.println(m1.valueAt(1, 3));
    }
}
