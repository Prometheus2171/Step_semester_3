package practice_problems;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Session8PracticeProblem2 {
    private interface LibraryItem {
        String title();
        LocalDate dueDate();
    }

    private static final class Book implements LibraryItem {
        private final String title;

        private Book(String title) {
            this.title = title;
        }

        public String title() {
            return title;
        }

        public LocalDate dueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(14);
        }
    }

    private static final class Dvd implements LibraryItem {
        private final String title;

        private Dvd(String title) {
            this.title = title;
        }

        public String title() {
            return title;
        }

        public LocalDate dueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(7);
        }
    }

    private static final class Magazine implements LibraryItem {
        private final String title;

        private Magazine(String title) {
            this.title = title;
        }

        public String title() {
            return title;
        }

        public LocalDate dueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(3);
        }
    }

    private static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new Dvd(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split("\\s+", 2);
                String type = parts[0];
                String title = parts.length > 1 ? parts[1].replace("\"", "") : "";
                LibraryItem item = createItem(type, title);
                System.out.printf("%s: %s%n", item.title(), item.dueDate());
            }
        }
    }
}
