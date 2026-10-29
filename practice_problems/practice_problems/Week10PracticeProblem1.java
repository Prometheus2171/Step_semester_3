import java.util.Locale;
import java.util.Scanner;

public class Week10PracticeProblem1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase(Locale.ROOT);
                int vowels = 0;
                int consonants = 0;
                for (int i = 0; i < word.length(); i++) {
                    char letter = word.charAt(i);
                    if ("aeiou".indexOf(letter) >= 0) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
                System.out.printf("Vowels: %d Consonants: %d%n", vowels, consonants);
            }
        }
    }
}