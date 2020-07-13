public class Program {
    public static boolean isMalben(int[][] arr, int in) {
        if (in == 1) return true;
        if (arr[in - 1].length != arr[in - 2].length) return false;

        return isMalben(arr, in - 1);
    }

    public static void main(String[] args) {
        Matrix m1 = new Matrix(5, 5, 1, 10);
        Matrix m2 = new Matrix(3, 4, 1, 10);

        System.out.print("m1 matrix: ");
        m1.show();
        System.out.println("Is squared matrix = " + m1.isSquared());
        System.out.println("Is identity matrix = " + m1.isIdentityMatrix()); // מטריצה יחידה
        System.out.println("Is symmetric matrix = " + m1.isSymmetric());
        System.out.print("Sub matrix of m1 (with parameters, i = 0, j = 1, a = 2, b = 1): ");
        m1.subMatrix(0, 1, 2, 1).show();
        System.out.println("does m1 equals to m2 = " + m1.equals(m2));
        System.out.println();
        System.out.print("m2 matrix: ");
        m2.show();
        System.out.println("Is squared matrix = " + m2.isSquared());
        System.out.println("Is identity matrix = " + m2.isIdentityMatrix()); // מטריצה יחידה
        System.out.println("Is symmetric matrix = " + m2.isSymmetric());
        System.out.print("Sub matrix of m2 (with parameters, i = 0, j = 1, a = 2, b = 1): ");
        m2.subMatrix(0, 1, 2, 1).show();
        System.out.println();
        // Taken from the document
        int[][] arr2d = new int[3][4];
        System.out.println(arr2d.length);
        System.out.println(isMalben(arr2d, arr2d.length));
        arr2d[1] = new int[] { 1, 2 };
        System.out.println(isMalben(arr2d, arr2d.length));
        arr2d[0] = new int[] { 5, 6 };
        arr2d[2] = arr2d[0];
        System.out.println(isMalben(arr2d, arr2d.length));
    }
}
