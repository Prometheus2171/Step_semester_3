import java.util.Scanner;

public class Week10PracticeProblem9 {
    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int year = scanner.nextInt();
                System.out.println(isLeapYear(year) ? "Leap year" : "Not a leap year");
            }
        }
    }
}