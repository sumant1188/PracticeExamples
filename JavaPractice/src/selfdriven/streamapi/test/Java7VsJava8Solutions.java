package selfdriven.streamapi.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java7VsJava8Solutions {
    public static void main(String[] args) {

        // find duplicate in array
        int[] arr = {1, 2, 3, 2, 4, 1, 5, 3};
        findDuplicates(arr);
        // find frequency of each word
        String text = "java is fun java programming is fun and awesome java";
        frequencyCalculator(text);
        // write a program to count the occurrences of each character.
        String word = "programming";
        frequencyOfCharacter(word);
        // find the first unique character.
        findFirstUnique(text);
        // longest String in array
        findLongestStringInArray(text);


    }

    private static void findLongestStringInArray(String text) {
        Optional<String> longest = Arrays.stream(text.split(" "))
                .filter(Objects::nonNull)
                .max(Comparator.comparing(String::length));
        System.out.println("longest word -> " + longest.get());
    }

    private static void findFirstUnique(String text) {
        // No collection
        String[] words = text.split(" ");
        boolean isDuplicate = false;
        for (int i = 0; i < words.length; i++) {
            isDuplicate = false;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                System.out.println("First unique word -> " + words[i]);
                break;
            }
        }
        // java 8 stream
        String key = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst().get()
                .getKey();
        System.out.println("First unique word key -> " + key);
    }

    private static void frequencyOfCharacter(String word) {
        // Java 7
        int[] freq = new int[256];
        for (char c : word.toLowerCase().toCharArray()) {
            freq[c]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + " : " + freq[i]);
            }
        }

        // java 8
        Map<Character, Long> collect = word.chars().map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    private static void frequencyCalculator(String text) {
        // Java 7 without collection
        int count = 1;
        String textToParse = text.toLowerCase();
        String[] split = textToParse.split(" ");
        for (int i = 0; i < split.length; i++) {
            for (int j = i + 1; j < split.length; j++) {
                if (split[i].equals(split[j])) {
                    count++;
                }
            }
            System.out.println("Frequency of " + split[i] + " -> " + count);
            count = 1;
        }
        // Java 7 with collection
        Map<String, Integer> wordCounter = new HashMap<>();
        int counter = 1;
        String[] split1 = textToParse.split(" ");
        for (String s : split1) {
            if (wordCounter.containsKey(s)) {
                counter = wordCounter.get(s) + 1;
            }
            wordCounter.put(s, counter);
        }
        System.out.println(wordCounter);
    }

    private static void findDuplicates(int[] arr) {
        // Java 7 without collection
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("duplicate -> " + arr[i]);
                    break;
                }
            }
        }

        // java 7 with collection
        Set<Integer> unique = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        for (int j : arr) {
            if (!unique.add(j)) {
                duplicate.add(j);
            }
        }
        System.out.println("duplicate -> " + duplicate);
        unique.clear();
        duplicate.clear();

        // java 8 stream
        duplicate = Arrays.stream(arr).boxed()
                .filter(i -> !unique.add(arr[i]))
                .collect(Collectors.toSet());
        System.out.println("duplicate -> " + duplicate);
    }
}
