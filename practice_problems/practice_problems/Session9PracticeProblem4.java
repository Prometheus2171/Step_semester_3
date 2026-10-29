import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9PracticeProblem4 {
    private abstract static class Connection {
        private final double units;

        Connection(double units) {
            this.units = units;
        }

        abstract double bill();

        double units() {
            return units;
        }
    }

    private static final class Home extends Connection {
        Home(double units) { super(units); }
        double bill() { return Math.min(units(), 100) * 5 + Math.max(0, units() - 100) * 7; }
    }

    private static final class Shop extends Connection {
        Shop(double units) { super(units); }
        double bill() { return units() * 8 + 100; }
    }

    private static final class Factory extends Connection {
        Factory(double units) { super(units); }
        double bill() { return Math.max(1000, units() * 6); }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Connection> connections = new ArrayList<>();
            List<String> types = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                double units = scanner.nextDouble();
                types.add(type);
                switch (type) {
                    case "HOME": connections.add(new Home(units)); break;
                    case "SHOP": connections.add(new Shop(units)); break;
                    case "FACTORY": connections.add(new Factory(units)); break;
                    default: throw new IllegalArgumentException("Unknown connection type: " + type);
                }
            }
            double total = 0;
            for (int i = 0; i < connections.size(); i++) {
                double bill = connections.get(i).bill();
                System.out.printf("%s: %.2f%n", types.get(i), bill);
                total += bill;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}