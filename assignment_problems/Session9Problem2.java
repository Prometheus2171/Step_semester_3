import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9Problem2 {
    private interface Parcel {
        String type();
        double shippingCharge();
    }

    private interface Insurable {
        double insurance(double declaredValue);
    }

    private abstract static class WeightedParcel implements Parcel {
        private final double weightKg;

        WeightedParcel(double weightKg) {
            this.weightKg = weightKg;
        }

        double weightKg() {
            return weightKg;
        }
    }

    private static final class StandardParcel extends WeightedParcel {
        StandardParcel(double weightKg) { super(weightKg); }
        public String type() { return "STANDARD"; }
        public double shippingCharge() { return 40 + 10 * weightKg(); }
    }

    private static final class ExpressParcel extends WeightedParcel implements Insurable {
        ExpressParcel(double weightKg) { super(weightKg); }
        public String type() { return "EXPRESS"; }
        public double shippingCharge() { return 80 + 15 * weightKg(); }
        public double insurance(double declaredValue) { return declaredValue * 0.02; }
    }

    private static final class FragileParcel extends WeightedParcel implements Insurable {
        FragileParcel(double weightKg) { super(weightKg); }
        public String type() { return "FRAGILE"; }
        public double shippingCharge() { return 40 + 10 * weightKg() + 50; }
        public double insurance(double declaredValue) { return declaredValue * 0.02; }
    }

    private static Parcel createParcel(String type, double weightKg) {
        switch (type) {
            case "STANDARD": return new StandardParcel(weightKg);
            case "EXPRESS": return new ExpressParcel(weightKg);
            case "FRAGILE": return new FragileParcel(weightKg);
            default: throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Parcel> parcels = new ArrayList<>();
            List<Double> declaredValues = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                parcels.add(createParcel(scanner.next(), scanner.nextDouble()));
                declaredValues.add(scanner.nextDouble());
            }
            double grandTotal = 0;
            for (int i = 0; i < parcels.size(); i++) {
                Parcel parcel = parcels.get(i);
                double charge = parcel.shippingCharge();
                double insurance = parcel instanceof Insurable
                        ? ((Insurable) parcel).insurance(declaredValues.get(i)) : 0;
                double total = charge + insurance;
                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                        parcel.type(), charge, insurance, total);
                grandTotal += total;
            }
            System.out.printf("Grand Total: %.2f%n", grandTotal);
        }
    }
}