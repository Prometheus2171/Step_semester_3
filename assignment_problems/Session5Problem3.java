public class Session5Problem3 {
    public static String findMinMaxSpread(int[] scores) {
        if (scores.length == 0) {
            throw new IllegalArgumentException("At least one score is required");
        }
        int min = scores[0];
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            min = Math.min(min, scores[i]);
            max = Math.max(max, scores[i]);
        }
        return "Min: " + min + " | Max: " + max + " | Spread: " + ((long) max - min);
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61}));
    }
}