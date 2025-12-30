package test;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * java code to find second largest number form list
 */
public class MyMain {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 8, 7, 9};
        int max = 0;
        int secondlarge = 0;
        max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                secondlarge = max;
                max = arr[i];
            } else {
                secondlarge = arr[i];
            }
            if (max < secondlarge) {
                secondlarge = max;
            }
        }
        System.out.println(secondlarge);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Optional<Integer> first = list.stream().distinct().sorted().skip(1).findFirst();

        //find a pair from Array having sum equal to given number
        int[] arrSum = {2, 3, 4, -3, 7, 9, 14, 10, 1};
        int inputSum = 11;
        findPairs(arrSum, inputSum);
        //multiple sorting
        sortStudents();
        // repeating characters in a word
        charRepetition("programming");

    }

    private static void charRepetition(String word){
        Set<Character> repeatedKeys = word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println(repeatedKeys);
    }

    private static void sortStudents() {
        List<Student> students = Student.createStudent();
        List<Student> sortedStudents = students.stream().sorted(Comparator.comparing(Student::getFirstName).thenComparing(Comparator.comparing(Student::getId))).collect(Collectors.toList());
        System.out.println(sortedStudents);
    }

    private static void findPairs(int[] arrSum, int inputSum) {
        Set<Integer> processedNumbers = new HashSet<>();
        Arrays.stream(arrSum).boxed().forEach(n -> {
            processedNumbers.add(n);
            int nextNum = inputSum - n;
            if (processedNumbers.contains(nextNum)) {
                System.out.println(n + ", " + nextNum);
            }
        });
    }
}

class Student {
    private int id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    static List<Student> createStudent() {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(3, "Sumant", "Dharkar");
        Student s2 = new Student(1, "Sunil", "Kulkarni");
        Student s3 = new Student(2, "Abhishek", "Gawande");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        return students;
    }
}
