package practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session8PracticeProblem5 {
    private interface Journey {
        double fare();
        String type();
    }

    private static final class BusJourney implements Journey {
        private final double distance;

        private BusJourney(double distance) {
            this.distance = distance;
        }

        public double fare() {
            double fare = 2 + (0.10 * distance);
            return Math.min(fare, 10.0);
        }

        public String type() {
            return "BUS";
        }
    }

    private static final class TrainJourney implements Journey {
        private final double distance;

        private TrainJourney(double distance) {
            this.distance = distance;
        }

        public double fare() {
            return 3 + (0.15 * distance);
        }

        public String type() {
            return "TRAIN";
        }
    }

    private static final class MetroJourney implements Journey {
        private final double distance;
        private final double peakHourFactor;

        private MetroJourney(double distance, double peakHourFactor) {
            this.distance = distance;
            this.peakHourFactor = peakHourFactor;
        }

        public double fare() {
            return (1.5 + (0.2 * distance)) * peakHourFactor;
        }

        public String type() {
            return "METRO";
        }
    }

    private static Journey createJourney(String type, double distance, double peakHourFactor) {
        switch (type) {
            case "BUS":
                return new BusJourney(distance);
            case "TRAIN":
                return new TrainJourney(distance);
            case "METRO":
                return new MetroJourney(distance, peakHourFactor);
            default:
                throw new IllegalArgumentException("Unknown journey type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Journey> journeys = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                double distance = scanner.nextDouble();
                double peakHourFactor = 1.0;
                if ("METRO".equals(type)) {
                    peakHourFactor = scanner.nextDouble();
                }
                journeys.add(createJourney(type, distance, peakHourFactor));
            }

            double total = 0.0;
            for (Journey journey : journeys) {
                double fare = journey.fare();
                System.out.printf("%s: %.2f%n", journey.type(), fare);
                total += fare;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
