package selfdriven.maths;

import java.util.Scanner;

public class powerOfTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number - ");
        int n=sc.nextInt();
        if(n == 1) {
            System.out.println("Yes");
        }
        if(n%10 != 0){
            System.out.println("No,number is not power of 10");
        }
        else {
            System.out.println(isPowerOfTen(n));
        }
    }

    private static boolean isPowerOfTen(int n) {
        while(n>=10 && n%10 == 0){
            n = n/10;
        }
        return n == 1;
    }
}
