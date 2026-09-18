package practice_problems;

public class Main {
    public static String playRound(String playerMove, String computerMove) {
        String player = playerMove.trim().toLowerCase();
        String computer = computerMove.trim().toLowerCase();
        if (player.equals(computer)) return "Draw";
        boolean playerWins = (player.equals("rock") && computer.equals("scissors"))
                || (player.equals("paper") && computer.equals("rock"))
                || (player.equals("scissors") && computer.equals("paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void printGameSummary(String[] playerMoves, String[] computerMoves) {
        int wins = 0, losses = 0, draws = 0;
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < playerMoves.length; i++) {
            String result = playRound(playerMoves[i], computerMoves[i]);
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            System.out.println((i + 1) + " | " + playerMoves[i] + " | " + computerMoves[i] + " | " + result);
        }
        double winPercentage = playerMoves.length == 0 ? 0 : wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }

    public static boolean isPalindromeIterative(String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--) {
            if (text.charAt(left) != text.charAt(right)) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) return true;
        return text.charAt(left) == text.charAt(right) && isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] reversed = text.toCharArray();
        for (int left = 0, right = reversed.length - 1; left < right; left++, right--) {
            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;
        }
        return text.equals(new String(reversed));
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%d | %.2f | %.2f | %.2f | %s%n", i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[Character.MAX_VALUE + 1];
        for (int i = 0; i < text.length(); i++) frequency[text.charAt(i)]++;
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) return text.charAt(i);
        }
        return '\0';
    }

    public static String reverseCustomerName(String customerName) {
        return new StringBuilder(customerName).reverse().toString();
    }

    public static void main(String[] args) {
        printGameSummary(new String[]{"Rock", "Paper", "Scissors"}, new String[]{"Scissors", "Paper", "Rock"});
        String text = "madam";
        System.out.println("Iterative: " + (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));
        printWellnessReport(new double[]{1.75, 1.60}, new double[]{70, 90});
        System.out.println("First Non-Repeating Character: '" + findFirstNonRepeatingChar("swiss") + "'");
        System.out.println("Original Name: Sunil");
        System.out.println("Reversed Name: " + reverseCustomerName("Sunil"));
    }
}
