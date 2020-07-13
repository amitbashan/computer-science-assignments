public class Progression {
    private int seriesStartNum, seriesDiff;

    public Progression(int a, int b) {
        seriesStartNum = a;
        seriesDiff = b;
    }

    public Progression() {
        seriesStartNum = -3;
        seriesDiff = 2;
    }

    public int getElement(int k) {
        return seriesStartNum + seriesDiff * (k - 1);
    }

    public void showProg(int n) {
        for (int i = 1; i < n + 1; ++i) {
            if (!(i == n)) {
                System.out.print(seriesStartNum + seriesDiff * (i - 1) + ",");
            } else System.out.println(seriesStartNum + seriesDiff * (i - 1));
        }
    }

    public void showProg() {
        for (int i = 1; i < 11; ++i) {
            if (!(i == 10)) {
                System.out.print(seriesStartNum + seriesDiff * (i - 1) + ",");
            } else System.out.println(seriesStartNum + seriesDiff * (i - 1));
        }
    }

    public void showProgUpTo(int n) {
        if (n >= 0 && n != seriesStartNum) {
            int counter = 1;
            String s = ""; // inefficient but havent learned StringBuilder yet
            while (true) {
                if (seriesStartNum + seriesDiff * (counter) < n) {
                    s += seriesStartNum + seriesDiff * (counter - 1) + ",";
                    counter++;
                } else {
                    s += seriesStartNum + seriesDiff * (counter - 1);
                    System.out.println(s);
                    break;
                }
            }
        }
    }
}
