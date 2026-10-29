import java.math.BigInteger;
import java.util.Scanner;

public class Week10PracticeProblem7 {
    private static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                System.out.println(factorial(scanner.nextInt()));
            }
        }
    }
}