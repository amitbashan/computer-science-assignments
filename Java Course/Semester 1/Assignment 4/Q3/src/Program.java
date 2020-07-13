import java.util.Scanner;

public class Program {
    public static String removeDuplicates(String input) {
        String result = "";
        for (int k = 0; k < input.length(); k++) {
            if (!result.contains(String.valueOf(input.charAt(k)))) {
                result += String.valueOf(input.charAt(k));
            }
        }
        return result;
    }

    public static String unspare(String myStr) {
        String removed_extra_whitespace = myStr.trim().replaceAll("\\s{2,}", " ");
        String[] words = removed_extra_whitespace.split(" ");
        String[] unspared_words = new String[words.length];
        String result = "";

        for (int i = 0; i < words.length; ++i) {
            unspared_words[i] = removeDuplicates(words[i]);
        }

        for (int i = 0; i < unspared_words.length; ++i) {
            result += unspared_words[i] + " ";
        }

        return result.trim();
    }

    public static String reverse(String myStr) {
        String removed_extra_whitespace = myStr.trim().replaceAll("\\s{2,}", " ");
        String[] words = removed_extra_whitespace.split(" ");
        String[] reversed_words = new String[words.length];
        String result = "";

        for (int i = 0; i < words.length; ++i) {
            reversed_words[i] = words[words.length - (i + 1)];
        }

        for (int i = 0; i < reversed_words.length; ++i) {
            result += reversed_words[i] + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println("The Start");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            } else {
                System.out.println(unspare(line));
                System.out.println(reverse(line));
            }
        }
        System.out.println("The End");
    }
}
