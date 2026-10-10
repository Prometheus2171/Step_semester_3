import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session8Problem3 {
    private interface Room {
        double bill();

        String type();
    }

    private static final class SingleRoom implements Room {
        private final int units;

        SingleRoom(int units) {
            this.units = units;
        }

        public double bill() {
            return units * 8.0;
        }

        public String type() {
            return "SINGLE";
        }
    }

    private static final class SharedRoom implements Room {
        private final int units;
        private final int occupants;

        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }

        public double bill() {
            return units * 6.0 / occupants;
        }

        public String type() {
            return "SHARED";
        }
    }

    private static final class AcRoom implements Room {
        private final int units;

        AcRoom(int units) {
            this.units = units;
        }

        public double bill() {
            return units * 10.0 + 200;
        }

        public String type() {
            return "AC";
        }
    }

    private static Room createRoom(Scanner scanner) {
        String type = scanner.next();
        int units = scanner.nextInt();
        switch (type) {
            case "SINGLE": return new SingleRoom(units);
            case "SHARED": return new SharedRoom(units, scanner.nextInt());
            case "AC": return new AcRoom(units);
            default: throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Room> rooms = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                rooms.add(createRoom(scanner));
            }

            double total = 0;
            for (Room room : rooms) {
                double bill = room.bill();
                System.out.printf("%s: %.2f%n", room.type(), bill);
                total += bill;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}