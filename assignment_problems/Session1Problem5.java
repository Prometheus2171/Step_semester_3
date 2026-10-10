public class Session1Problem5 {
    public static void classifyWordLengths(String review) {
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;
        if (review != null && !review.isEmpty()) {
            for (String word : review.split("\\s+")) {
                String cleanWord = word.replaceAll("[^A-Za-z]", "");
                int length = cleanWord.length();
                if (length >= 1 && length <= 4) shortCount++;
                else if (length <= 8 && length >= 5) mediumCount++;
                else if (length > 8) longCount++;
            }
        }
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}