import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9Problem5 {
    private interface SaverMode {
        default double reduceUnits(double units) {
            return units * 0.75;
        }
    }

    private abstract static class Appliance {
        abstract double powerWatts();

        abstract String type();

        double unitsUsed(double hours) {
            return powerWatts() * hours / 1000;
        }
    }

    private static final class Fridge extends Appliance {
        double powerWatts() { return 150; }
        String type() { return "FRIDGE"; }
    }

    private static final class AirConditioner extends Appliance implements SaverMode {
        double powerWatts() { return 1500; }
        String type() { return "AC"; }
    }

    private static final class Television extends Appliance {
        double powerWatts() { return 100; }
        String type() { return "TV"; }
    }

    private static final class Washer extends Appliance implements SaverMode {
        double powerWatts() { return 500; }
        String type() { return "WASHER"; }
    }

    private static Appliance createAppliance(String type) {
        switch (type) {
            case "FRIDGE": return new Fridge();
            case "AC": return new AirConditioner();
            case "TV": return new Television();
            case "WASHER": return new Washer();
            default: throw new IllegalArgumentException("Unknown appliance: " + type);
        }
    }

    private static final class Usage {
        private final Appliance appliance;
        private final double hours;
        private final boolean saverRequested;

        Usage(Appliance appliance, double hours, boolean saverRequested) {
            this.appliance = appliance;
            this.hours = hours;
            this.saverRequested = saverRequested;
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Usage> usages = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Appliance appliance = createAppliance(scanner.next());
                double hours = scanner.nextDouble();
                boolean saver = scanner.hasNext("SAVER");
                if (saver) scanner.next();
                usages.add(new Usage(appliance, hours, saver));
            }
            double totalCost = 0;
            for (Usage usage : usages) {
                Appliance appliance = usage.appliance;
                if (usage.saverRequested && !(appliance instanceof SaverMode)) {
                    System.out.printf("%s: saver mode not supported%n", appliance.type());
                    continue;
                }
                double units = appliance.unitsUsed(usage.hours);
                if (usage.saverRequested) {
                    units = ((SaverMode) appliance).reduceUnits(units);
                }
                double cost = units * 8;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.type(), units, cost);
                totalCost += cost;
            }
            System.out.printf("Total Cost: %.2f%n", totalCost);
        }
    }
}