public class Session5Problem4 {
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) {
                output.append(" | ");
            }
            output.append("Match ").append(i).append(": ")
                    .append(rowAverage(runsPerOver[i]) >= threshold ? "Power Surge" : "Normal");
        }
        return output.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(runsPerOver, 8));
    }
}