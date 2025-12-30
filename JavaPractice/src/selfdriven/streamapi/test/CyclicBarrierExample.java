package test;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    private static final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int THREADS = 3;
    private static int[] partialSums = new int[THREADS];

    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(THREADS, () -> {
            // This runs when all threads reach the barrier
            int total = 0;
            for (int sum : partialSums) total += sum;
            System.out.println("Total sum: " + total);
        });

        int chunkSize = numbers.length / THREADS;
        for (int i = 0; i < THREADS; i++) {
            final int threadIndex = i;
            new Thread(() -> {
                int start = threadIndex * chunkSize;
                int end = (threadIndex == THREADS - 1) ? numbers.length : start + chunkSize;
                int sum = 0;
                for (int j = start; j < end; j++) sum += numbers[j];
                partialSums[threadIndex] = sum;
                System.out.println("Thread " + threadIndex + " partial sum: " + sum);
                try {
                    barrier.await(); // Wait for others
                } catch (Exception e) { e.printStackTrace(); }
            }).start();
        }
    }
}
