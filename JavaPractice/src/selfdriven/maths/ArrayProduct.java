package selfdriven.maths;

public class ArrayProduct {
    public static void main(String[] args) {
        int [] array1 = new int[] {10, 25};
        int [] array2 = new int[] {2, 3, 4};
        long sumProduct = 0;
        int minLength = Math.min(array1.length, array2.length);

        for(int i = 0; i<minLength;i++) {
            sumProduct+= array1[i]*array2[i];
        }
        System.out.println(sumProduct);
    }
}
