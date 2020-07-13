public class Set {
    private int[] set;
    public int index;

    public Set() {
        set = new int[10];
        index = 0;
    }

    public Set(int... numbers) {
        if (numbers.length >= 2) {
            int[] array = numbers;
            int fixed_length = numbers.length;

            for (int i = 0; i < fixed_length; ++i) {
                for (int k = i + 1; k < fixed_length; ++k) {
                    if (array[i] == array[k]) {
                        array[k] = array[fixed_length - 1];
                        fixed_length--;
                        k--;
                    }
                }
            }

            set = new int[fixed_length];
            index = fixed_length;
            for (int i = 0; i < fixed_length; ++i) {
                set[i] = array[i];
            }
        }
    }

    Set(Set s) {
        set = new int[s.set.length];
        index = s.set.length;
        for (int i = 0; i < s.set.length; ++i) {
            set[i] = s.set[i];
        }
    }

    public boolean equals(Set s) {
        if (set.length != s.set.length) {
            return false;
        } else {
            int[] sorted_array1 = new int[set.length];
            int[] sorted_array2 = new int[set.length];

            for (int i = 0; i < set.length; ++i) {
                sorted_array1[i] = set[i];
            }

            for (int i = 0; i < set.length; ++i) {
                sorted_array2[i] = s.set[i];
            }

            for (int i = 0; i < sorted_array1.length; i++) {
                for (int k = i + 1; k < sorted_array1.length; k++) {
                    int temp = 0;
                    if (sorted_array1[i] > sorted_array1[k]) {
                        temp = sorted_array1[i];
                        sorted_array1[i] = sorted_array1[k];
                        sorted_array1[k] = temp;
                    }
                }
            }

            for (int i = 0; i < sorted_array2.length; i++) {
                for (int k = i + 1; k < sorted_array2.length; k++) {
                    int temp = 0;
                    if (sorted_array2[i] > sorted_array2[k]) {
                        temp = sorted_array2[i];
                        sorted_array2[i] = sorted_array2[k];
                        sorted_array2[k] = temp;
                    }
                }
            }

            for (int i = 0; i < set.length; i++)
                if (sorted_array1[i] != sorted_array2[i])
                    return false;
        }

        return true;
    }

    public Set union(Set s) {
        int[] combined_array = new int[s.set.length + set.length];

        for (int i = 0; i < set.length; ++i) {
            combined_array[i] = set[i];
        }

        for (int i = 0; i < s.set.length; ++i) {
            combined_array[set.length + i] = s.set[i];
        }

        // filter out duplicate numbers
        // it didn't say to remove duplicates, i just assumed that
        // because i was asked to do so in the constructor and a Set must contain only unique numbers
        int fixed_length = combined_array.length;

        for (int i = 0; i < fixed_length; ++i) {
            for (int k = i + 1; k < fixed_length; ++k) {
                if (combined_array[i] == combined_array[k]) {
                    combined_array[k] = combined_array[fixed_length - 1];
                    fixed_length--;
                    k--;
                }
            }
        }

        int[] processed_array = new int[fixed_length];

        for (int i = 0; i < fixed_length; ++i) {
            processed_array[i] = combined_array[i];
        }

        return new Set(processed_array);
    }

    // the document did not specify to write this function but i was
    // asked to use it in Program.java
    public void add(int num) {
        boolean num_found = false;

        for (int i = 0; i < set.length; ++i) {
            if (set[i] == num) {
                num_found = true;
            }
        }

        if (!num_found) {
            int[] new_set = new int[index + 1];

            for (int i = 0; i < index; ++i) {
                new_set[i] = set[i];
            }

            set = new int[new_set.length];
            new_set[new_set.length - 1] = num;

            for (int i = 0; i < set.length; ++i) {
                set[i] = new_set[i];
            }

            index++;
        }
    }

    public Set intersect(Set s) {
        int fixed_length = 0;
        int[] intersected_array;

        for (int i = 0; i < set.length; ++i) {
            for (int k = 0; k < s.set.length; ++k) {
                if (set[i] == s.set[k]) {
                    fixed_length++;
                }
            }
        }

        intersected_array = new int[fixed_length];

        if (fixed_length > 0) {
            int j = 0;

            for (int i = 0; i < set.length; ++i) {
                for (int k = 0; k < s.set.length; ++k) {
                    if (set[i] == s.set[k]) {
                        j++;
                        intersected_array[j - 1] = s.set[k]; // using intersected_array[i] will throw an out of bounds exception
                    }
                }
            }

            return new Set(intersected_array);
        } else return new Set(); // return empty set?
    }

    public boolean subset(Set s) {
        int count = 0;

        for (int i = 0; i < set.length; ++i) {
            for (int k = 0; k < s.set.length; ++k) {
                if (set[i] == s.set[k]) count++;
            }
        }

        if (count == s.set.length) return true;
        else return false;
    }

    // the document did not specify to write this function but i was
    // asked to use it in Program.java
    public void show() {
        System.out.print("[");
        for (int i = 0; i < set.length; ++i) {
            if (i == set.length - 1) {
                System.out.print(set[i]);
                System.out.println("]");
            } else {
                System.out.print(set[i] + ", ");
            }
        }
    }

    public int[] toArray() {
        return set;
    }
}