import java.util.Scanner;

public class ProblemSecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > highest) {
                secondHighest = highest;
                highest = score;
            } else if (score < highest && score > secondHighest) {
                secondHighest = score;
            }
        }
        return secondHighest == Integer.MIN_VALUE ? -1 : secondHighest;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            int[] scores = new int[count];
            for (int i = 0; i < count; i++) {
                scores[i] = scanner.nextInt();
            }
            System.out.println(secondHighest(scores));
        }
    }
}