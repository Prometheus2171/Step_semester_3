package practice_problems;

public class Session2PracticeProblem1 {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));
            if ("aeiou".indexOf(ch) >= 0) vowels++;
            else if (ch >= 'a' && ch <= 'z') consonants++;
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }
}