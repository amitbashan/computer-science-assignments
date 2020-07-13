import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix implements Arithmetic, InputOutput {
    int[][] data;

    public Matrix(int x, int y) {
        if (x < 0 || y < 0 || x == 0 && y == 0)
            throw new IllegalArgumentException("Matrix dimension cannot be negative/zero.");

        data = new int[x][y];
    }

    @Override
    public Object add(Object object) {
        if (!(object instanceof Matrix)) throw new IllegalArgumentException("Given parameter is not of type Matrix.");

        Matrix matrix = (Matrix) object;

        if (matrix.data.length != data.length && matrix.data[0].length != data[0].length)
            try {
                throw new UnequalMatricesDimensionException();
            } catch (UnequalMatricesDimensionException ignored) {
                System.out.println("Cannot execute operation on matrices with different dimensions.");
            }

        Matrix result = new Matrix(data.length, data[0].length);

        for (int x = 0; x < result.data.length; ++x) {
            for (int y = 0; y < result.data[0].length; ++y) {
                result.data[x][y] = matrix.data[x][y] + data[x][y];
            }
        }

        return result;
    }

    @Override
    public Object sub(Object object) {
        if (!(object instanceof Matrix)) throw new IllegalArgumentException("Given parameter is not of type Matrix.");

        Matrix matrix = (Matrix) object;

        if (matrix.data.length != data.length && matrix.data[0].length != data[0].length)
            try {
                throw new UnequalMatricesDimensionException();
            } catch (UnequalMatricesDimensionException ignored) {
                System.out.println("Cannot execute operation on matrices with different dimensions.");
            }

        Matrix result = new Matrix(data.length, data[0].length);

        for (int x = 0; x < result.data.length; ++x) {
            for (int y = 0; y < result.data[0].length; ++y) {
                result.data[x][y] = matrix.data[x][y] - data[x][y];
            }
        }

        return result;
    }

    @Override
    public Object mul(Object object) {
        return new UnsupportedOperationException("Multiplication of matrices is not supported.");
    }

    @Override
    public Object div(Object object) {
        return new UnsupportedOperationException("Division of matrices is not supported.");
    }

    // didnt understand the document that much, did what i understood.
    @Override
    public void read() {
        Scanner scanner = new Scanner(System.in);
        boolean xError, yError, iError;
        int x = 0, y = 0, input = 0;

        do {
            try {
                System.out.print("Enter X value: ");
                x = scanner.nextInt();
                xError = x >= data.length;
                if (xError) System.out.println("Invalid input, try again!");
            } catch (InputMismatchException e) {
                xError = true;
                System.out.println("Invalid input, try again!");
                scanner.next();
            }
        } while (xError);

        do {
            try {
                System.out.print("Enter Y value: ");
                y = scanner.nextInt();
                yError = y >= data[0].length;
                if (yError) System.out.println("Invalid input, try again!");
            } catch (InputMismatchException e) {
                yError = true;
                System.out.println("Invalid input, try again!");
                scanner.next();
            }
        } while (yError);

        do {
            try {
                System.out.print(String.format("Enter a value to put at index [%d][%d]: ", x, y));
                input = scanner.nextInt();
                iError = false;
            } catch (InputMismatchException e) {
                iError = true;
                System.out.println("Invalid input, try again!");
                scanner.next();
            }
        } while (iError);

        data[x][y] = input;
    }

    // didnt understand the document that much, did what i understood.
    @Override
    public void write() {
        Scanner scanner = new Scanner(System.in);
        boolean xError, yError;
        int x = 0, y = 0;

        do {
            try {
                System.out.print("Enter X value: ");
                x = scanner.nextInt();
                xError = false;
            } catch (InputMismatchException e) {
                xError = true;
                System.out.println("Invalid input, try again!");
                scanner.next();
            }
        } while (xError);

        do {
            try {
                System.out.print("Enter Y value: ");
                y = scanner.nextInt();
                yError = false;
            } catch (InputMismatchException e) {
                yError = true;
                System.out.println("Invalid input, try again!");
                scanner.next();
            }
        } while (yError);

        System.out.println(String.format("Value at index [%d][%d] = %d", x, y, data[x][y]));
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Matrix)) throw new IllegalArgumentException("Given parameter is not of type Matrix");

        Matrix matrix = (Matrix) object;

        if (matrix.data.length != data.length && matrix.data[0].length != data[0].length) try {
            throw new UnequalMatricesDimensionException();
        } catch (UnequalMatricesDimensionException e) {
            System.out.println("Cannot execute operation on matrices with different dimensions.");
            return false;
        }

        for (int x = 0; x < matrix.data.length; ++x) {
            for (int y = 0; y < matrix.data[0].length; ++y) {
                if (matrix.data[x][y] != data[x][y]) return false;
            }
        }

        return true;
    }

    public int valueAt(int i, int j) {
        if (i < 0 || i > data.length && j < 0 || j > data[0].length) throw new IllegalArgumentException();

        return data[i][j];
    }

    @Override
    public Matrix clone() {
        Matrix result = new Matrix(data.length, data[0].length);

        result.data = data;

        return result;
    }
}
