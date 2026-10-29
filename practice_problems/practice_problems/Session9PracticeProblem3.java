import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9PracticeProblem3 {
    private abstract static class LibraryItem {
        private final String title;
        private final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();

        String title() {
            return title;
        }

        int daysLate() {
            return daysLate;
        }
    }

    private static final class Book extends LibraryItem {
        Book(String title, int daysLate) { super(title, daysLate); }
        double fine() { return 2 * daysLate(); }
    }

    private static final class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) { super(title, daysLate); }
        double fine() { return Math.min(5 * daysLate(), 50); }
    }

    private static final class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        double fine() { return daysLate(); }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<LibraryItem> items = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                String title = scanner.next();
                int daysLate = scanner.nextInt();
                switch (type) {
                    case "BOOK": items.add(new Book(title, daysLate)); break;
                    case "DVD": items.add(new Dvd(title, daysLate)); break;
                    case "MAGAZINE": items.add(new Magazine(title, daysLate)); break;
                    default: throw new IllegalArgumentException("Unknown item type: " + type);
                }
            }
            double totalFines = 0;
            for (LibraryItem item : items) {
                double fine = item.fine();
                System.out.printf("%s: %.2f%n", item.title(), fine);
                totalFines += fine;
            }
            System.out.printf("Total Fines: %.2f%n", totalFines);
        }
    }
}