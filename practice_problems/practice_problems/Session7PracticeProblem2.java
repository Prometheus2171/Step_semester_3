package practice_problems;

public class Session7PracticeProblem2 {
    static class Scorecard {
        private final boolean[] results;
        private int recordedCount;

        Scorecard(int questionCount) {
            if (questionCount < 0) {
                throw new IllegalArgumentException("Question count cannot be negative");
            }
            results = new boolean[questionCount];
        }

        boolean recordAnswer(boolean correct) {
            if (recordedCount == results.length) {
                return false;
            }
            results[recordedCount++] = correct;
            return true;
        }

        int getScore() {
            int score = 0;
            for (int i = 0; i < recordedCount; i++) {
                if (results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(4);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);
        System.out.println(scorecard.getScore());
    }
}