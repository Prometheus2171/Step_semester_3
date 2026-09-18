import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Session2Assignment {
    public static void checkPinLength(String pin) {
        if (pin == null) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
            return;
        }

        if (pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        }
    }

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(new StringBuilder(words[i]).reverse());
        }

        return result.toString();
    }

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
    }

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }

        String prefix = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return prefix + rest;
    }

    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);

        if (normalized.length() != 13) {
            return "Invalid: wrong length";
        }

        if (!Character.isLetter(normalized.charAt(0)) ||
                !Character.isLetter(normalized.charAt(1)) ||
                !Character.isLetter(normalized.charAt(2))) {
            return "Invalid: publisher code must be 3 letters";
        }

        boolean validDigits = true;
        for (int i = 3; i < normalized.length(); i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                validDigits = false;
                break;
            }
        }

        if (!validDigits) {
            return "Invalid: non-digit body";
        }

        String publisher = normalized.substring(0, 3);
        String year = normalized.substring(3, 7);
        String catalog = normalized.substring(7);
        return "[" + publisher + "] YEAR: " + year + " | CATALOG: " + catalog;
    }

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No words to analyze.");
            return;
        }

        String cleaned = feedback.toLowerCase();
        String[] punctuation = {".", ",", "!", "?", ";", ":", "\"", "'"};
        for (String mark : punctuation) {
            cleaned = cleaned.replace(mark, "");
        }

        String[] words = cleaned.split("\\s+");
        Map<String, Integer> counts = new HashMap<>();
        List<String> stopWords = List.of("the", "was", "and", "a", "is", "of", "in");

        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(counts.entrySet());
        sorted.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : sorted) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 1");
        checkPinLength("482");
        checkPinLength("4820");

        System.out.println("\nProblem 2");
        System.out.println(reverseEachWord("hello club"));

        System.out.println("\nProblem 3");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");

        System.out.println("\nProblem 4");
        System.out.println(validateAndFormat(" pen2026004251 "));
        System.out.println(validateAndFormat("12N2026004251"));

        System.out.println("\nProblem 5");
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
