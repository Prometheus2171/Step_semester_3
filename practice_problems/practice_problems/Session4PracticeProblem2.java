package practice_problems;

public class Session4PracticeProblem2 {
    public static int maxProfit(int[] prices) {
        int minimum = Integer.MAX_VALUE;
        int bestProfit = 0;
        for (int price : prices) {
            minimum = Math.min(minimum, price);
            bestProfit = Math.max(bestProfit, price - minimum);
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}