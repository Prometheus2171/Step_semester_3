import java.util.Scanner;

public class Week10PracticeProblem3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            int even = 0;
            int odd = 0;
            for (int i = 0; i < count; i++) {
                if (scanner.nextInt() % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            System.out.printf("Even: %d%nOdd: %d%n", even, odd);
        }
    }
}