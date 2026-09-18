public class Session1Assignment {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyReported = false;
            for (int j = 0; j < i; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    alreadyReported = true;
                    break;
                }
            }

            if (alreadyReported) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input");
            return;
        }

        if (original.length() != typed.length()) {
            System.out.println("Length mismatch: both strings must be equal in length.");
            return;
        }

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        if (firstMismatch == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, original.length(), accuracy, firstMismatch + 1,
                    original.charAt(firstMismatch), typed.charAt(firstMismatch));
        }
    }

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Empty signal log");
            return;
        }

        char currentChar = signalLog.charAt(0);
        int currentCount = 1;
        char bestChar = currentChar;
        int bestCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);
            if (ch == currentChar) {
                currentCount++;
            } else {
                currentChar = ch;
                currentCount = 1;
            }

            if (currentCount > bestCount) {
                bestChar = ch;
                bestCount = currentCount;
            }
        }

        System.out.println("Longest Streak: '" + bestChar + "' repeated " + bestCount + " times");
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        int maxVal = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        for (int value : sectionA) {
            totalA += value;
        }
        for (int value : sectionB) {
            totalB += value;
        }

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxVal) {
                maxVal = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxVal) {
                maxVal = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: " + status +
                " | Highest Quantity: " + maxVal + " (" + maxSection + ", Item " + maxIndex + ")");
    }

    public static void classifyWordLengths(String review) {
        if (review == null || review.isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            String cleanWord = word.replaceAll("[^A-Za-z]", "");
            if (cleanWord.isEmpty()) {
                continue;
            }

            int length = cleanWord.length();
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        System.out.println("Problem 1");
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});

        System.out.println("\nProblem 2");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nProblem 3");
        findLongestStreak("RRGGGYRR");

        System.out.println("\nProblem 4");
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});

        System.out.println("\nProblem 5");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
