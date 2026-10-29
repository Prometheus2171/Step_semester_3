import java.util.Scanner;

public class ProblemClassAttendanceTracker {
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longestStreak = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;
                longestStreak = Math.max(longestStreak, streak);
            } else {
                streak = 0;
            }
        }
        return new int[] {present, longestStreak};
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            int[] days = new int[count];
            for (int i = 0; i < count; i++) {
                days[i] = scanner.nextInt();
            }
            int[] summary = attendanceSummary(days);
            System.out.printf("Present: %d, Longest streak: %d%n", summary[0], summary[1]);
        }
    }
}