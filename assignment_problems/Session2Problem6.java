import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Session2Problem6 {
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No words to analyze.");
            return;
        }
        String cleaned = feedback.toLowerCase().replaceAll("[.,!?;:\"']", "");
        Map<String, Integer> counts = new HashMap<>();
        List<String> stopWords = List.of("the", "was", "and", "a", "is", "of", "in");
        for (String word : cleaned.split("\\s+")) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(counts.entrySet());
        sorted.sort(Comparator.<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue)
                .reversed().thenComparing(Map.Entry::getKey));
        for (Map.Entry<String, Integer> entry : sorted) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}