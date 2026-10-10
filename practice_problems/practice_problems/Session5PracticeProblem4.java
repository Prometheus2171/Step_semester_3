package practice_problems;

public class Session5PracticeProblem4 {
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

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ")
                    .append(rowAverage(seatingScores[i]) >= threshold ? "Buzzing Zone" : "Quiet Zone");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] scores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(scores, 60));
    }
}