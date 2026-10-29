import java.util.Scanner;

public class Week10PracticeProblem2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                String reversed = new StringBuilder(word).reverse().toString();
                String result = word.equals(reversed) ? "palindrome" : "not a palindrome";
                System.out.printf("%s - %s%n", reversed, result);
            }
        }
    }
}