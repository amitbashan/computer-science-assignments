import java.util.Arrays;

public class DrawingBoard {
    private Shape[] shapes;
    private int index;

    public DrawingBoard(int length) {
        shapes = new Shape[length];
    }

    // Helper function
    private Shape[] reconstructArray() {
        Shape[] result = new Shape[(int) (shapes.length * 1.5) + 1];

        for (int i = 0; i < shapes.length; ++i) {
            result[i] = shapes[i];
        }

        return result;
    }

    public void add(Shape... s) {
        if (s.length == 0) return;

        for (Shape shape : s) {
            if (index >= shapes.length) {
                shapes = reconstructArray();
            }

            shapes[index] = shape;
            ++index;
        }
    }

    public void showAll() {
        for (Shape shape : shapes) {
            if (shape instanceof TwoDimensionalShape) {
                System.out.println(String.format("2D Shape : %s : %s", shape.getClass().getName(), shape));
            } else if (shape instanceof ThreeDimensionalShape) {
                System.out.println(String.format("3D Shape : %s : %s", shape.getClass().getName(), shape));
            }
        }
    }

    public Shape getMax() {
        int maxAreaIndex = 0;

        for (int i = 1; i < shapes.length; ++i) {
            if (shapes[i] != null) {
                if (shapes[i].area() > shapes[maxAreaIndex].area()) maxAreaIndex = i;
            }
        }

        return shapes[maxAreaIndex];
    }

    public ThreeDimensionalShape getMax3DV1() {
        int count = 0;
        int maxVolumeIndex = 0;

        for (int i = 0; i < shapes.length; ++i) {
            if (count == 0 && shapes[i] instanceof ThreeDimensionalShape) maxVolumeIndex = i;
            if (shapes[i] instanceof ThreeDimensionalShape) ++count;
        }

        if (count == 0) return null;

        for (int i = 0; i < shapes.length; ++i) {
            if (shapes[i] instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape maxVolumeShape = (ThreeDimensionalShape) shapes[maxVolumeIndex];
                ThreeDimensionalShape currentShape = (ThreeDimensionalShape) shapes[i];

                if (currentShape.volume() > maxVolumeShape.volume()) maxVolumeIndex = i;
            }
        }

        return (ThreeDimensionalShape) shapes[maxVolumeIndex];
    }

    public ThreeDimensionalShape getMax3DV2() {
        int count = 0;
        int maxVolumeIndex = 0;

        for (int i = 0; i < shapes.length; ++i) {
            if (shapes[i] != null) {
                if (count == 0 && shapes[i].getClass() == Cube.class || shapes[i].getClass() == Sphere.class)
                    maxVolumeIndex = i;
                if (shapes[i].getClass() == Cube.class || shapes[i].getClass() == Sphere.class) ++count;
            }
        }

        if (count == 0) return null;

        for (int i = 0; i < shapes.length; ++i) {
            if (shapes[i] != null) {
                if (shapes[i].getClass() == Cube.class || shapes[i].getClass() == Sphere.class) {
                    ThreeDimensionalShape maxVolumeShape = (ThreeDimensionalShape) shapes[maxVolumeIndex];
                    ThreeDimensionalShape currentShape = (ThreeDimensionalShape) shapes[i];

                    if (currentShape.volume() > maxVolumeShape.volume()) maxVolumeIndex = i;
                }
            }
        }

        return (ThreeDimensionalShape) shapes[maxVolumeIndex];
    }

    public Class[] getTypes() {
        Class[] filtered = new Class[shapes.length];
        Class[] result;
        int seperateIndex = 0;
        int typeCount = 0;

        for (int i = 0; i < shapes.length; ++i) {
            if (shapes[i] != null) {
                boolean found = false;

                for (Class aClass : filtered) {
                    if (aClass == shapes[i].getClass()) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    ++typeCount;
                    filtered[seperateIndex++] = shapes[i].getClass();
                }
            }
        }

        result = new Class[typeCount];

        for (int i = 0; i < result.length; ++i) {
            result[i] = filtered[i];
        }

        return result;
    }
}
