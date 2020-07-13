public class Utility {
    public static void showAll(Showable[] a) {
        for (Showable showable : a) {
            showable.show();
        }
    }

    public static void showAll(Object[] a) {
        for (Object object : a) {
            if (object instanceof Showable) ((Showable) object).show();
            else System.out.println(object.toString());
        }
    }

    public static boolean search(Object[] array, Object object) {
        for (Object item : array) {
            if (item instanceof Comparable && item.getClass() == object.getClass()) {
                Comparable comparable = (Comparable) item;
                if (comparable.compareTo(object) == 0) return true;
            } else {
                if (object.equals(item)) return true;
            }
        }

        return false;
    }

    public static Object max(Object[] array) {
        for (Object object : array) {
            for (Object object2 : array) {
                if (object.getClass() != object2.getClass() || !(object2 instanceof Comparable)) return null;
            }
        }

        int maxObjectIndex = 0;

        for (int i = 1; i < array.length; ++i) {
            Comparable currentObject = (Comparable) array[i];
            Comparable maxObject = (Comparable) array[maxObjectIndex];

            if (maxObject.compareTo(currentObject) < 0) maxObjectIndex = i;
        }

        return array[maxObjectIndex];
    }
}
