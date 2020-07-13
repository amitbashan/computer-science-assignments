public class Calculator {
    public int countDigits(int num) {
        if(num == 0) return 1;
        else {
            int c = 0;
            while (num > 0) {
                num /= 10;
                c++;
            }
            return c;
        }
    }

    public int sumEven(int num) {
        int result = 0;
        for (int i = 1; i < num; ++i) {
            int current_num = (int) (num % (Math.pow(10, i))) / (int) Math.pow(10, i - 1);
            if (current_num % 2 == 0) {
                result += current_num;
            }
        }
        return result;
    }

    public boolean evenOdd(int num) {
        int even_sum = sumEven(num);
        int odd_sum = 0;
        for (int i = 1; i < num; ++i) {
            int current_num = (int) (num % (Math.pow(10, i))) / (int) Math.pow(10, i - 1);
            if (!(current_num % 2 == 0)) {
                odd_sum += current_num;
            }
        }
        return even_sum > odd_sum;
    }

    public int getDigit(int num, int k) {
        return num % (int) (Math.pow(10, k + 1)) / (int) Math.pow(10, k);
    }

    public int setDigit(int num, int k, int d) {
        int half = (int) (num % (Math.pow(10, k + 1)));
        int rounded_num = num - half;
        int number_to_change = half / (int) Math.pow(10, k);
        int leftover = number_to_change * (int) Math.pow(10, k);
        return d * (int) Math.pow(10, k) + half - leftover + rounded_num;
    }

    public int minDigit(int num) {
        if(num == 0) return 0;
        else {
            int min = Integer.MAX_VALUE;
            while (num > 0) {
                int digit = num % 10;
                min = Math.min(min, digit);
                num /= 10;
            }
            return min;
        }
    }

    public boolean isSymmetric(int num) {
        int result = 0;
        int num_backup = num;
        while (num != 0) {
            result *= 10;
            result += num % 10;
            num /= 10;
        }

        if (result == num_backup) {
            return true;
        } else return false;
    }

    public int search(int num, int d) {
        int result = 1;
        for (int i = 1; i < num; ++i) {
            int current_num = (int) (num % (Math.pow(10, i))) / (int) Math.pow(10, i - 1);
            if (current_num == d) {
                result++;
            }
        }
        return result;
    }
}
