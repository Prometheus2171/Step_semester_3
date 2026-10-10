package practice_problems;

public class Session1PracticeProblem4 {
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[Character.MAX_VALUE + 1];
        for (int i = 0; i < text.length(); i++) frequency[text.charAt(i)]++;
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) return text.charAt(i);
        }
        return '\0';
    }

    public static void main(String[] args) {
        char result = findFirstNonRepeatingChar("swiss");
        System.out.println(result == '\0' ? "No Non-Repeating Character Found" : "First Non-Repeating Character: '" + result + "'");
    }
}