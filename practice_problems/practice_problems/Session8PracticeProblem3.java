package practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session8PracticeProblem3 {
    private interface Delivery {
        double fee();
        String type();
    }

    private static final class StandardDelivery implements Delivery {
        private final double weight;
        private final double distance;

        private StandardDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double fee() {
            return 5 + (0.5 * weight) + (0.1 * distance);
        }

        public String type() {
            return "STANDARD";
        }
    }

    private static final class ExpressDelivery implements Delivery {
        private final double weight;
        private final double distance;

        private ExpressDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double fee() {
            return 15 + (1.0 * weight) + (0.2 * distance);
        }

        public String type() {
            return "EXPRESS";
        }
    }

    private static final class InternationalDelivery implements Delivery {
        private final double weight;
        private final double distance;
        private final double customsFee;

        private InternationalDelivery(double weight, double distance, double customsFee) {
            this.weight = weight;
            this.distance = distance;
            this.customsFee = customsFee;
        }

        public double fee() {
            return 25 + (2.0 * weight) + (0.5 * distance) + customsFee;
        }

        public String type() {
            return "INTERNATIONAL";
        }
    }

    private static Delivery createDelivery(String type, double weight, double distance, double customsFee) {
        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL":
                return new InternationalDelivery(weight, distance, customsFee);
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Delivery> deliveries = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                double weight = scanner.nextDouble();
                double distance = scanner.nextDouble();
                double customsFee = 0.0;
                if ("INTERNATIONAL".equals(type)) {
                    customsFee = scanner.nextDouble();
                }
                deliveries.add(createDelivery(type, weight, distance, customsFee));
            }

            double total = 0.0;
            for (Delivery delivery : deliveries) {
                double fee = delivery.fee();
                System.out.printf("%s: %.2f%n", delivery.type(), fee);
                total += fee;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
