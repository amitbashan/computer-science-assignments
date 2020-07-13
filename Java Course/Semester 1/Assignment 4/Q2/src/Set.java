public class Set {
    private int[] set;
    private int filled_count;

    public Set(int a) {
        set = new int[a];
        for (int i = 0; i < a; ++i) {
            set[i] = Integer.MAX_VALUE;
        }
        filled_count = 0;
    }

    public boolean add(int num) {
        if (num == 0) {
            for (int i = 0; i < set.length; ++i) {
                if (set[i] == 0) {
                    return false;
                }
            }
            if (!isFull()) {
                set[filled_count] = 0;
                filled_count++;
                return true;
            }
        } else {
            for (int i = 0; i < set.length; i++) {
                if (set[i] == num) return false;
            }
            if (filled_count == set.length) return false;
            else {
                set[filled_count] = num;
                filled_count++;
                return true;
            }
        }
        return false;
    }

    public boolean isMember(int num) {
       /* int sum = 0;
        for (int i = 0; i < set.length; ++i) {
            sum += set[i];
        }
        if (sum == 0 && filled_count == 0) return false; */

        if (num == 0 && filled_count == 0) return false;
        else {
            for (int i = 0; i < set.length; i++) {
                if (set[i] == num) return true;
            }
        }
        return false;
    }

    public void show() {
        if (filled_count == 0) {
            System.out.println("()");
        } else {
            String result = "";

            result += "(";

            for (int i = 1; i < set.length + 1; i++) {
                if (i == set.length) {
                    result += set[i - 1];
                } else result += set[i - 1] + ",";
            }

            result = result.replace("2147483647,", "");
            result = result.replace(",2147483647", "");

            result += ")";
            if (result.equals("(2147483647)")) System.out.println("()");
            else System.out.println(result);
        }
    }

    public boolean isEmpty() {
        return filled_count == 0;
    }

    public boolean isFull() {
        return filled_count == set.length;
    }

    public boolean remove(int num) {
        boolean success = false;
        if (num == 0) {
            for (int i = 0; i < set.length; ++i) {
                if (set[i] == 0) {
                    set[i] = Integer.MAX_VALUE;
                    success = true;
                    filled_count--;
                }
            }
        }
        else {
            for (int i = 0; i < set.length; ++i) {
                if (set[i] == num) {
                    set[i] = Integer.MAX_VALUE;
                    success = true;
                    filled_count--;
                }
            }
        }
        return success;
    }
}