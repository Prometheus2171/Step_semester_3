import java.util.Scanner;

public class ProblemBusiestBusRow {
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }

        return new int[] {bestRow, bestTotal};
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int[][] grid = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            int[] result = busiestRow(grid);
            System.out.printf("Row %d, Total %d%n", result[0] + 1, result[1]);
        }
    }
}
