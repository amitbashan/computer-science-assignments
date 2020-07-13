package Q3;

public class Program {
    public static void main(String[] args) {
        XDate d1 = new XDate(19, 2, 2008);
        XDate d2 = d1.addDays(11);
        System.out.print(d2.getDate() + "/" + d2.getMonth() + "/" + d2.getYear());
    }
}
