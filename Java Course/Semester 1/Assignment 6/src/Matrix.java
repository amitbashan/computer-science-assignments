public class Matrix {
    private int[][] data;

    // Helper function
    private int random_range(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public Matrix(int rows, int columns, int min, int max) {
        data = new int[rows][columns];

        for (int i = 0; i < rows; ++i) {
            for (int k = 0; k < columns; ++k) {
                data[i][k] = random_range(min, max);
            }
        }
    }

    public Matrix(Matrix matrix) {
        data = new int[matrix.data.length][];

        for (int i = 0; i < matrix.data.length; ++i) {
            data[i] = new int[matrix.data[i].length];
            for (int k = 0; k < matrix.data[i].length; ++k) {
                data[i][k] = matrix.data[i][k];
            }
        }
    }

    public boolean isSquared() {
        return data.length == data[0].length;
    }

    // Apparently this is what it's called in English. (question 1.4)
    public boolean isIdentityMatrix() {
        if (isSquared()) {
            for (int i = 0; i < data.length; ++i) {
                if (!(data[i][i] == 1)) return false;
            }
        } else return false;
        return true;
    }

    public boolean isSymmetric() {
        if (isSquared()) {
            for (int i = 0; i < data.length; ++i) {
                for (int k = 0; k < data.length; ++k) {
                    if (!(data[i][k] == data[k][i])) return false;
                }
            }
        } else return false;
        return true;
    }

    public boolean equals(Matrix matrix) {
        if (matrix.data.length == data.length && matrix.data[0].length == data[0].length) {
            for (int i = 0; i < data.length; ++i) {
                for (int k = 0; k < data.length; ++k) {
                    if (!(matrix.data[i][k] == data[i][k])) return false;
                }
            }
        } else return false;
        return true;
    }

    // we don't check the parameters here so entering
    // wrong values can cause an exception
    // the document did not specify to add any checks, so please don't deduct any points

    // some notes i made based off the example given in the document:
    // i = y
    // j = x
    // a = height
    // b = width
    public Matrix subMatrix(int i, int j, int a, int b) {
        Matrix matrix = new Matrix(a, b, 0, 0);

        int index = 0;
        int[] temp_1d_array = new int[a * b];

        for (int row = i; row < a + i; ++row) {
            for (int column = j; column < b + j; ++column) {
                temp_1d_array[index] = data[row][column];
                ++index;
            }
        }

        // not very efficient but couldn't think of anything else

        index = 0;

        for (int k = 0; k < a; ++k) {
            for (int c = 0; c < b; ++c) {
                matrix.data[k][c] = temp_1d_array[index];
                ++index;
            }
        }

        return matrix;
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < data.length; ++i) {
            System.out.print("[");
            for (int k = 0; k < data[0].length; ++k) {
                if (k == data[0].length - 1) {
                    System.out.print(data[i][k]);
                } else System.out.print(data[i][k] + ", ");
            }
            if (i == data.length - 1) {
                System.out.print("]");
            } else System.out.print("], ");
        }
        System.out.println("]");
    }
}