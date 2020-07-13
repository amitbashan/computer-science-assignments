public class Set implements Arithmetic, ScanOp {
    public Object[] set;
    private int index, scanOpIndex;

    /* Helper functions */

    // Helper function and question 3.6
    public Class[] getDistinctClasses() {
        Class[] filtered = new Class[set.length];
        int filteredIndex = 0;

        for (Object object : set) {
            if (object == null) break;

            boolean found = false;

            for (int k = 0; k < filteredIndex; ++k) {
                if (filtered[k] == object.getClass()) {
                    found = true;
                    break;
                }
            }

            if (!found) filtered[filteredIndex++] = object.getClass();
        }

        Class[] result = new Class[filteredIndex];

        for (int i = 0; i < filteredIndex; ++i) {
            result[i] = filtered[i];
        }

        return result;
    }

    private int objectCount(Class c) {
        int count = 0;

        for (Object item : set) {
            if (item != null && item.getClass().equals(c)) {
                ++count;
            }
        }

        return count;
    }

    /* Helper functions */

    public Set(int length, Object... objects) {
        set = new Object[length];

        for (int i = 0; i < length; ++i) {
            if (i < objects.length) add(objects[i]);
        }
    }

    public void add(Object object) {
        if (object == null) return;

        for (Object item : set) {
            if (object.equals(item)) return;
        }

        set[index++] = object;
    }

    @Override
    public String toString() {
        Class[] types = getDistinctClasses();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < types.length; ++i) {
            sb.append(String.format("%s(%d)", types[i].getName(), objectCount(types[i])));
            if (i < types.length - 1) sb.append(":");
        }

        return sb.toString();
    }

    public Object[] getObjectsOfClassType(Class type) {
        Set result = new Set(set.length);

        for (Object item : set) {
            if (item == null) break;

            if (item.getClass().equals(type)) result.add(item);
        }

        return new Set(result.index, result.set).set;
    }

    @Override
    public Set add(Arithmetic object) {
        if (!(object instanceof Set)) return null;

        Set secondSet = (Set) object;
        Object[] items = new Object[set.length + secondSet.set.length];

        for (int i = 0; i < set.length; ++i) {
            items[i] = set[i];
        }

        int secondSetIndex = 0;

        for (int i = set.length; i < items.length; ++i) {
            items[i] = secondSet.set[secondSetIndex++];
        }

        return new Set(items.length, items);
    }

    @Override
    public Set sub(Arithmetic object) {
        Set result = new Set(set.length);

        if (object instanceof Set) {
            Set secondSet = (Set) object;

            for (Object item : set) {
                if (item == null) continue;
                boolean foundDuplicate = false;

                for (Object secondItem : secondSet.set) {
                    if (item.equals(secondItem)) {
                        foundDuplicate = true;
                        break;
                    }
                }

                if (!foundDuplicate) result.add(item);
            }
        } else return null;

        return result;
    }

    @Override
    public Set mul(Arithmetic object) {
        if (!(object instanceof Set)) return null;

        Set secondSet = (Set) object;
        Set result = new Set(Math.max(set.length, secondSet.set.length));

        for (int i = 0; i < secondSet.set.length; ++i) {
            if (secondSet.set[i] == null || set[i] == null) break;

            if (Utility.search(set, secondSet.set[i])) {
                result.add(secondSet.set[i]);
            }
        }

        return new Set(index + 1, result.set);
    }

    @Override
    public Set div(Arithmetic object) {
        return null;
    }

    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public boolean forward() {
        if (scanOpIndex + 1 >= index) return false;
        else ++scanOpIndex;

        return true;
    }

    @Override
    public boolean backward() {
        if (scanOpIndex - 1 <= 0) return false;
        else --scanOpIndex;

        return true;
    }

    @Override
    public Object getCurrent() {
        return set[scanOpIndex];
    }
}
