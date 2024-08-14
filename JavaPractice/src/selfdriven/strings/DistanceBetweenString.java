package selfdriven.strings;

public class DistanceBetweenString {
    public static void main(String[] args) {
        String sentence = "In publishing and graphic design, lorem ipsum is a filler text " +
                "commonly used to demonstrate the graphic elements";

        String word1 = "is";
        String word2 = "a";

        double distance = shortestDistance(sentence, word1, word2);

        System.out.println("Distance - " + distance);
    }

    private static double shortestDistance(String sentence, String word1, String word2) {
        if (word1.equalsIgnoreCase(word2)) {
            return 0.0;
        }
        double minimumDistance = Integer.MAX_VALUE;
        double midPointOfWord1 = 0;
        double midPointOfWord2 = 0;
        double midPointLength = 0;
        double index = 0;
        String[] words = sentence.split(" ");
        for (String word : words) {
            if(word.equalsIgnoreCase(word1)) {
                midPointOfWord1 = index + word1.length()/2.0;
            }
            if(word.equalsIgnoreCase(word2)) {
                midPointOfWord2 = index + word2.length()/2.0;
            }
            index = index + word.length() + 1;
            if(midPointOfWord1 > 0 && midPointOfWord2 > 0) {
                midPointLength = Math.abs(midPointOfWord1 - midPointOfWord2);
                if(midPointLength < minimumDistance) {
                    minimumDistance = midPointLength;
                }
            }
        }
        if (minimumDistance == Integer.MAX_VALUE) {
            minimumDistance = -1;
        }
        return minimumDistance;
    }

}
