public class Session1Problem3 {
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
            if (ch == currentChar) currentCount++;
            else {
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

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}