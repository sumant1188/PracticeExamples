import java.util.PriorityQueue;

public class DSAExample {

    public static void main(String[] args) {
        // Create a PriorityQueue of integers (min-heap by default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the priority queue
        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println("Elements in PriorityQueue: " + pq);

        // Remove elements from the priority queue (smallest first)
        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.poll());
        }

        // can yu give ne a trr map example
        // Create a TreeMap to store key-value pairs in sorted order
        java.util.TreeMap<Integer, String> treeMap = new java.util.TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");


        System.out.println("Elements in TreeMap: " + treeMap);

        // create a code for fibonacci series
        int n = 10; // Number of terms in the Fibonacci series
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            //System.out.print(fibonacci(i) + " ");

        }

    }
}
