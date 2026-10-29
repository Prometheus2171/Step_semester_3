import java.util.Scanner;

public class Week10PracticeProblem8 {
    private static char grade(int marks) {
        if (marks >= 90) return 'A';
        if (marks >= 75) return 'B';
        if (marks >= 60) return 'C';
        if (marks >= 40) return 'D';
        return 'F';
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                System.out.printf("Grade %c%n", grade(scanner.nextInt()));
            }
        }
    }
}