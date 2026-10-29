package practice_problems;

import java.util.Locale;
import java.util.Scanner;

public class Session8PracticeProblem4 {
    private interface Question {
        double score();
        String type();
    }

    private static final class McqQuestion implements Question {
        private final String correctAnswer;
        private final String studentAnswer;
        private final double points;

        private McqQuestion(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public double score() {
            return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
        }

        public String type() {
            return "MCQ";
        }
    }

    private static final class TrueFalseQuestion implements Question {
        private final String correctAnswer;
        private final String studentAnswer;
        private final double points;

        private TrueFalseQuestion(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public double score() {
            return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
        }

        public String type() {
            return "TF";
        }
    }

    private static final class EssayQuestion implements Question {
        private final String correctAnswer;
        private final String studentAnswer;
        private final double points;

        private EssayQuestion(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public double score() {
            String[] keywords = correctAnswer.split(",");
            int matchCount = 0;
            String lowerStudent = studentAnswer.toLowerCase(Locale.US);
            for (String keyword : keywords) {
                String normalized = keyword.trim();
                if (!normalized.isEmpty() && lowerStudent.contains(normalized.toLowerCase(Locale.US))) {
                    matchCount++;
                }
            }
            if (matchCount >= 2) {
                return points * 0.75;
            }
            if (matchCount == 1) {
                return points * 0.50;
            }
            return 0.0;
        }

        public String type() {
            return "ESSAY";
        }
    }

    private static String readQuoted(Scanner scanner) {
        String token = scanner.next();
        return token.replace("\"", "");
    }

    private static Question createQuestion(String type, String correctAnswer, String studentAnswer, double points) {
        switch (type) {
            case "MCQ":
                return new McqQuestion(correctAnswer, studentAnswer, points);
            case "TF":
                return new TrueFalseQuestion(correctAnswer, studentAnswer, points);
            case "ESSAY":
                return new EssayQuestion(correctAnswer, studentAnswer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            scanner.nextLine();
            double total = 0.0;
            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split("\\s+", 2);
                String type = parts[0];
                String remaining = parts.length > 1 ? parts[1].trim() : "";

                String correctAnswer = readQuoted(new Scanner(remaining));
                String studentAnswer = readQuoted(new Scanner(remaining.substring(remaining.indexOf('"') + 1)));

                // Rebuild using a simpler direct parser for the known format.
                int firstQuote = remaining.indexOf('"');
                int secondQuote = remaining.indexOf('"', firstQuote + 1);
                int thirdQuote = remaining.indexOf('"', secondQuote + 1);
                int fourthQuote = remaining.indexOf('"', thirdQuote + 1);
                int lastSpace = remaining.lastIndexOf(' ');

                correctAnswer = remaining.substring(firstQuote + 1, secondQuote);
                studentAnswer = remaining.substring(thirdQuote + 1, fourthQuote);
                double points = Double.parseDouble(remaining.substring(lastSpace + 1).trim());

                Question question = createQuestion(type, correctAnswer, studentAnswer, points);
                double score = question.score();
                System.out.printf("%s: %.2f%n", question.type(), score);
                total += score;
            }
            System.out.printf("Total Score: %.2f%n", total);
        }
    }
}
