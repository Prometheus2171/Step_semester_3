import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9Problem4 {
    private interface NightService {
        default double addNightSurcharge(double fare) {
            return fare * 1.20;
        }
    }

    private abstract static class Cab {
        abstract double ratePerKm();

        abstract String type();

        double dayFare(double distanceKm) {
            return Math.max(100, distanceKm * ratePerKm());
        }
    }

    private static final class MiniCab extends Cab {
        double ratePerKm() { return 10; }
        String type() { return "MINI"; }
    }

    private static final class SedanCab extends Cab implements NightService {
        double ratePerKm() { return 14; }
        String type() { return "SEDAN"; }
    }

    private static final class SuvCab extends Cab implements NightService {
        double ratePerKm() { return 18; }
        String type() { return "SUV"; }
    }

    private static Cab createCab(String type) {
        switch (type) {
            case "MINI": return new MiniCab();
            case "SEDAN": return new SedanCab();
            case "SUV": return new SuvCab();
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    private static final class Trip {
        private final Cab cab;
        private final double distanceKm;
        private final String time;

        Trip(Cab cab, double distanceKm, String time) {
            this.cab = cab;
            this.distanceKm = distanceKm;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Trip> trips = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                trips.add(new Trip(createCab(scanner.next()), scanner.nextDouble(), scanner.next()));
            }
            double total = 0;
            for (Trip trip : trips) {
                if (trip.time.equals("NIGHT") && !(trip.cab instanceof NightService)) {
                    System.out.printf("%s: night service not available%n", trip.cab.type());
                    continue;
                }
                double fare = trip.cab.dayFare(trip.distanceKm);
                if (trip.time.equals("NIGHT")) {
                    fare = ((NightService) trip.cab).addNightSurcharge(fare);
                }
                System.out.printf("%s: %.2f%n", trip.cab.type(), fare);
                total += fare;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}