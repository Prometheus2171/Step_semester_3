import java.util.Scanner;

public class Week10PracticeProblem6 {
    private static boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        for (long divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                System.out.printf("%d is %sprime%n", number, isPrime(number) ? "" : "not ");
            }
        }
    }
}