import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session8Problem2 {
    private interface Vehicle {
        double charge();

        String type();
    }

    private static final class Bike implements Vehicle {
        private final int hours;

        Bike(int hours) {
            this.hours = hours;
        }

        public double charge() {
            return hours * 10.0;
        }

        public String type() {
            return "BIKE";
        }
    }

    private static final class Car implements Vehicle {
        private final int hours;

        Car(int hours) {
            this.hours = hours;
        }

        public double charge() {
            return 30 + (hours - 1) * 20.0;
        }

        public String type() {
            return "CAR";
        }
    }

    private static final class Truck implements Vehicle {
        private final int hours;

        Truck(int hours) {
            this.hours = hours;
        }

        public double charge() {
            return Math.max(100, hours * 50.0);
        }

        public String type() {
            return "TRUCK";
        }
    }

    private static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE": return new Bike(hours);
            case "CAR": return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Vehicle> vehicles = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                vehicles.add(createVehicle(scanner.next(), scanner.nextInt()));
            }

            double total = 0;
            for (Vehicle vehicle : vehicles) {
                double charge = vehicle.charge();
                System.out.printf("%s: %.2f%n", vehicle.type(), charge);
                total += charge;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}