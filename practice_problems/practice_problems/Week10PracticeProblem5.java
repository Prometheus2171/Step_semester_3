import java.util.Scanner;

public class Week10PracticeProblem5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                long remaining = number;
                long digitSum = 0;
                long reversed = 0;
                do {
                    long digit = remaining % 10;
                    digitSum += digit;
                    reversed = reversed * 10 + digit;
                    remaining /= 10;
                } while (remaining > 0);
                System.out.printf("Sum of digits: %d%nReverse: %d%n", digitSum, reversed);
            }
        }
    }
}