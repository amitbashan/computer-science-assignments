import java.util.*;
import java.util.stream.Collectors;

public class Program {
    // You might see this function on other students submissions too. I shared my code with them on WhatsApp.
    public static Map<Object, Integer> calcFreq(Collection<Object> collection) {
        Map<Object, Integer> frequencyMap = new HashMap<>();

        for (Object item : collection) {
            int occurrences = 0;

            for (Object secondItem : collection) {
                if (secondItem == item) {
                    ++occurrences;
                }
            }

            frequencyMap.put(item, occurrences);
        }

        return frequencyMap;
    }

    public static int results(java.util.List<String> votes, int hasima) {
        votes.replaceAll(String::toLowerCase);

        Set<String> notPassed = new HashSet<>(votes).stream()
                .filter(x -> Collections.frequency(votes, x) < hasima)
                .collect(Collectors.toSet());

        Map<String, Long> passed = votes.stream()
                .filter(x -> Collections.frequency(votes, x) >= hasima)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println(
                String.format("Parties that did not pass hasima are:\n%s\nParties that did pass hasima:\n%s",
                        String.join("\n", notPassed),
                        passed.entrySet()
                                .stream()
                                .map(x -> String.format("%s:%d", x.getKey(), x.getValue()))
                                .collect(Collectors.joining("\n"))));

        if (passed.size() == 0) {
            return 0;
        } else {
            Map.Entry<String, Long> entry = Collections.max(passed.entrySet(), Map.Entry.comparingByValue());

            System.out.println(String.format("Biggest party is : %s", entry.getKey()));

            return entry.getValue().intValue();
        }
    }

    public static void main(String[] args) {
        java.util.List<String> votes = Arrays.asList
                ("BB", "BB", "Bb", "aA", "CCC", "aa", "cCc", "aa", "dddd", "bb", "bb");

        results(votes, 2);

        Collection<Object> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello");
        list.add("123");

        System.out.println(calcFreq(list));

        List<Integer> anotherList = new List<>();

        anotherList.addItem(234);
        anotherList.addItem(256);

        System.out.println(anotherList.min());
        System.out.println(anotherList.max());
    }
}