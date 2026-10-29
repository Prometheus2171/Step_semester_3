import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9PracticeProblem5 {
    private abstract static class TravelBooking {
        private static final double BOOKING_FEE = 50;
        private final double distanceKm;

        TravelBooking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract String mode();

        abstract double baseFare();

        double totalFare() {
            return baseFare() + BOOKING_FEE;
        }

        double distanceKm() {
            return distanceKm;
        }
    }

    private static final class Bus extends TravelBooking {
        Bus(double distanceKm) { super(distanceKm); }
        String mode() { return "BUS"; }
        double baseFare() { return 2 * distanceKm(); }
    }

    private static final class Train extends TravelBooking {
        Train(double distanceKm) { super(distanceKm); }
        String mode() { return "TRAIN"; }
        double baseFare() { return 1.5 * distanceKm(); }
    }

    private static final class Flight extends TravelBooking {
        Flight(double distanceKm) { super(distanceKm); }
        String mode() { return "FLIGHT"; }
        double baseFare() { return 2500 + 4 * distanceKm(); }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<TravelBooking> bookings = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String mode = scanner.next();
                double distanceKm = scanner.nextDouble();
                switch (mode) {
                    case "BUS": bookings.add(new Bus(distanceKm)); break;
                    case "TRAIN": bookings.add(new Train(distanceKm)); break;
                    case "FLIGHT": bookings.add(new Flight(distanceKm)); break;
                    default: throw new IllegalArgumentException("Unknown travel mode: " + mode);
                }
            }
            for (TravelBooking booking : bookings) {
                System.out.printf("%s: %.2f%n", booking.mode(), booking.totalFare());
            }
        }
    }
}