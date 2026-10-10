public class Session1Problem2 {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Invalid input: both strings must be non-null and equal in length.");
            return;
        }
        int matched = 0;
        int firstMismatch = -1;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) matched++;
            else if (firstMismatch == -1) firstMismatch = i;
        }
        double accuracy = original.isEmpty() ? 100.0 : matched * 100.0 / original.length();
        if (firstMismatch == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", matched, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, original.length(), accuracy, firstMismatch + 1,
                    original.charAt(firstMismatch), typed.charAt(firstMismatch));
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
    }
}