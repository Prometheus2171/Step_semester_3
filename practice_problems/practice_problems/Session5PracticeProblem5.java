package practice_problems;

import java.util.Arrays;

public class Session5PracticeProblem5 {
    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        private double compositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), compositeScore());
        }
    }

    private static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    private static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = Arrays.stream(candidates)
                .filter(candidate -> isEligible(candidate.cgpa) || isEligible(candidate.cgpa, candidate.codingScore))
                .toArray(Candidate[]::new);
        Arrays.sort(shortlisted);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(shortlisted[i].name)
                    .append(" (").append(String.format("%.1f", shortlisted[i].compositeScore())).append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}