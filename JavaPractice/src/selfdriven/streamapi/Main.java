import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

        long startTime = System.currentTimeMillis();

        processNames(names);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Total time taken by processNames: " + duration + " ms");
    }

    //
    public static void processNames(List<String> names) {
        System.out.println("=== Start Processing Names ===");
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);

            printNameLengthInfo(name);
            printVowelOrEndingInfo(name);

            if (!seen.add(name)) {
                System.out.println("Duplicate found: " + name);
            }
        }

        System.out.println("=== End Processing Names ===");
    }

    private static void printNameLengthInfo(String name) {
        if (name.length() > 3) {
            System.out.println(name + " has more than 3 characters");
            for (int j = 0; j < name.length(); j++) {
                String parity = (j % 2 == 0) ? "even" : "odd";
                System.out.println("  Index " + j + " is " + parity + ", char: " + name.charAt(j));
            }
        } else {
            System.out.println(name + " has 3 or fewer characters");
        }
    }

    private static void printVowelOrEndingInfo(String name) {
        if (startsWithVowel(name)) {
            System.out.println(name + " starts with a vowel");
        } else if (name.endsWith("e")) {
            System.out.println(name + " ends with 'e'");
        }
    }

    private static boolean startsWithVowel(String name) {
        if (name.isEmpty()) return false;
        char first = Character.toUpperCase(name.charAt(0));
        return first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U';
    }
}