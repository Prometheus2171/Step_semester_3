import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9Problem1 {
    private abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20;

        abstract double seatPrice();

        double bookingAmount(int count) {
            return count * (seatPrice() + CONVENIENCE_FEE);
        }

        abstract String seatType();
    }

    private static final class RegularTicket extends Ticket {
        double seatPrice() { return 150; }
        String seatType() { return "REGULAR"; }
    }

    private static final class PremiumTicket extends Ticket {
        double seatPrice() { return 250; }
        String seatType() { return "PREMIUM"; }
    }

    private static final class ReclinerTicket extends Ticket {
        double seatPrice() { return 400; }
        String seatType() { return "RECLINER"; }
    }

    private static Ticket createTicket(String seat) {
        switch (seat) {
            case "REGULAR": return new RegularTicket();
            case "PREMIUM": return new PremiumTicket();
            case "RECLINER": return new ReclinerTicket();
            default: throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Ticket> tickets = new ArrayList<>();
            List<Integer> quantities = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                tickets.add(createTicket(scanner.next()));
                quantities.add(scanner.nextInt());
            }
            double total = 0;
            for (int i = 0; i < tickets.size(); i++) {
                Ticket ticket = tickets.get(i);
                double amount = ticket.bookingAmount(quantities.get(i));
                System.out.printf("%s: %.2f%n", ticket.seatType(), amount);
                total += amount;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}