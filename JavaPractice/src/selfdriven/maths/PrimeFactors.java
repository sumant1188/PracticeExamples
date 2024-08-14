package selfdriven.maths;

import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number - ");
        int n = sc.nextInt();

        for (int i = 2; i <= n/2; i++) {
            if (isPrime(i)) {
                int x = n;
                while (x % i == 0) {
                    System.out.print(i + "\t");
                    x /= i;
                }
            }
        }
    }

    private static boolean isPrime(int i) {
        boolean prime = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
