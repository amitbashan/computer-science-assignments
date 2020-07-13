import java.util.ArrayList;
import java.util.Arrays;

public class Die {
    private int numOfSides;
    private int[] statistics;

    public Die() {
        this(6);
    }

    public Die(int n) {
        numOfSides = n;
        statistics = new int[numOfSides];
    }

    public int rollDie() {
        int result;
        result = 1 + (int) (Math.random() * numOfSides);
        statistics[result - 1]++;
        return result;
    }

    public void showStatistics() {
        int k;
        for (k = 0; k < numOfSides; k++)
            System.out.println(k + 1 + ":" + statistics[k]);

        System.out.println("Most frequent digit is " + getMostFrequent());
    }

    private int getMostFrequent() {
        int sum = 0;
        for (int i = 0; i < statistics.length; ++i) {
            sum += statistics[i];
        }
        if (sum == 0) {
            return 1;
        } else {
            int[] most_frequents = getAllMostFrequents();
            if (most_frequents.length == 1) {
                int max = statistics[0];

                for (int k = 1; k < statistics.length; k++)
                    if (statistics[k] > max)
                        max = statistics[k];

                for (int i = 0; i < statistics.length; ++i) {
                    if (statistics[i] == max) {
                        return i + 1;
                    }
                }
            } else return most_frequents[most_frequents.length - 1];
        }
        return 1337;
    }

    /*} else {
        int count = 1, tempCount;
        int most_frequent = 0;

        // checking for most frequent
        for (int i = 0; i < (statistics.length - 1); i++) {
            int temp = statistics[i];
            tempCount = 0;
            for (int j = 1; j < statistics.length; j++) {
                if (temp == statistics[j])
                    tempCount++;
            }
            if (tempCount > count) {
                most_frequent = temp;
                count = tempCount;
            }
        }
        if (most_frequent == 0) {
            int max = statistics[0];

            for (int k = 1; k < statistics.length; k++)
                if (statistics[k] > max)
                    max = statistics[k];

            most_frequent = max;
        }

        for (int i = 0; i < statistics.length; ++i) {
            if (statistics[i] == most_frequent) {
                most_frequent = i;
            }
        }

        return most_frequent + 1;
    }*/
    public int[] getAllMostFrequents() {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int count = 1, tempCount;
        int popular = statistics[0];
        int temp = 0;
        int final_num = 0;
        for (int i = 0; i < (statistics.length); i++) {
            temp = statistics[i];
            tempCount = 0;
            for (int j = 1; j < statistics.length; j++) {
                if (temp == statistics[j])
                    tempCount++;
            }
            if (tempCount > count) {
                popular = temp;
                count = tempCount;
            }
        }

        for (int i = 0; i < statistics.length; i++) {
            if (statistics[i] == popular) {
                res.add((i + 1));
            }
        }

        int sum = 0;
        for (int i = 0; i < statistics.length; i++) {
            sum += statistics[i];
        }
        if (sum == 1) {
            int[] array = new int[1];
            for (int i = 0; i < statistics.length; i++) {
                if (statistics[i] == 1) {
                    array[0] = i + 1;
                    break;
                }
            }
            return array;
        } else {
            int[] newArray = new int[res.size()];

            for (int i = 0; i < res.size(); i++) {
                newArray[i] = res.get(i);
            }

            return newArray;
        }
    }
}