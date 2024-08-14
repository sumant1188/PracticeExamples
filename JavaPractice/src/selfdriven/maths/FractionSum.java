package selfdriven.maths;

public class FractionSum {

    public static void main(String[] args) {
        int[] arr1 = new int[]{20, 13};
        int[] arr2 = new int[]{3, 5};

        if (arr1[1] == 0 || arr2[1] == 0) {
            System.out.println("Invalid Array");
        } else {
            int den = arr1[1] * arr2[1];
            int num = (arr1[1] * arr2[0]) + (arr1[0] * arr2[1]);

            int i = Math.min(num, den);
            int num1 = 0, den1 = 0;
            for (int j = 1; j <= i; j++) {
                if (num % j == 0 && den % j == 0) {
                    num1 = num / j;
                    den1 = den / j;
                }
            }
            System.out.println(num1 + "/" + den1);
        }
    }
}
