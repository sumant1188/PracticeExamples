package selfdriven.maths;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VulgarDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number - ");
        int numerator = sc.nextInt();

        System.out.println("Enter number - ");
        int denominator = sc.nextInt();

        if (numerator % denominator == 0) {
            System.out.println("No vulgar decimal");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(numerator/denominator);
            sb.append(".");
            numerator %= denominator;
            Map<Integer, Integer> decimalPosition = new HashMap<>();
            decimalPosition.put(numerator, sb.length());
            while (numerator != 0) {
                numerator *= 10;
                sb.append(numerator / denominator);
                numerator %= denominator;
                if (decimalPosition.containsKey(numerator)) {
                    int index = decimalPosition.get(numerator);
                    sb.insert(index, "(");
                    sb.append(")");
                    break;
                }
                else {
                    decimalPosition.put(numerator, sb.length());
                }
            }
            System.out.println(sb);
        }
    }
}
