import java.util.Scanner;

public class ProblemExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        return lowerBound(scores, high + 1) - lowerBound(scores, low);
    }

    private static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (scores[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            int[] scores = new int[count];
            for (int i = 0; i < count; i++) {
                scores[i] = scanner.nextInt();
            }
            int low = scanner.nextInt();
            int high = scanner.nextInt();
            System.out.println(countInBand(scores, low, high));
        }
    }
}