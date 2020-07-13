import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Rational r1 = new Rational();
        Rational r2 = new Rational(5, 10);
        Rational r3 = new Rational(-2, 4);
        Rational r4 = new Rational(8, -16);
        System.out.println(String.format("(%s) + (%s) = (%s)", r1, r2, r1.add(r2)));
        System.out.println(String.format("(%s) - (%s) = (%s)", r1, r2, r1.sub(r2)));
        System.out.println(String.format("(%s) * (%s) = (%s)", r1, r2, r1.mul(r2)));
        System.out.println(String.format("(%s) / (%s) = (%s)", r1, r2, r1.div(r2)));
        System.out.println(String.format("Does (%s) equal to (%s) = %s", r3, r4, r3.equals(r4)));
        System.out.println(String.format("Does (%s) equal to (%s) = %s", r2, r3, r2.equals(r3)));
        System.out.println(String.format("Does (%s) equal to (%s) = %s", r2, r4, r2.equals(r4)));
        Object[] numbers2 = new Object[]{9, 4, 6, 7, new Rational(4, 7), 4, 7, 12};
        Object[] numbers = new Object[]{9, 4, 6, 7, 4, 7, 12};
        System.out.println(Utility.max(numbers));
        System.out.println(Utility.max(numbers2));
        System.out.println(Utility.search(numbers, 12));
        System.out.println(Utility.search(numbers, 612));
        System.out.println(Utility.search(numbers2, new Rational(4, 7)));
        System.out.println();
        Utility.showAll(numbers2);
        System.out.println();
        Showable[] showables = new Showable[]{new Rational(2, 6), new Rational(5, 2)};
        Utility.showAll(showables);
        System.out.println();
        System.out.println();
        System.out.println();
        Set set = new Set(5, new Rational(2, 2), 423, "Hello world!", 2341);
        Set set2 = new Set(3, "Hello world!", 512, new Rational(2, 2), 43);
        System.out.println(set);
        System.out.println(set2);
        System.out.println();
        Set combinedSet = set.add(set2);
        System.out.println(combinedSet);
        System.out.println(set.sub(set2));
        System.out.println();
        System.out.println(set.mul(set2));
        System.out.println();
        System.out.println(Arrays.toString(set.getObjectsOfClassType(Integer.class)));
        System.out.println(Arrays.toString(set.getDistinctClasses()));
        System.out.println();
        System.out.println(set.getCurrent());
        System.out.println(set.forward());
        System.out.println(set.getCurrent());
        System.out.println(set.backward());
        System.out.println(set.backward());
        System.out.println(set.getCurrent());
        set.reset();
    }
}
