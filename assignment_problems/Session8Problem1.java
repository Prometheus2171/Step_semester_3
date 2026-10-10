import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session8Problem1 {
    private interface Bill {
        double finalAmount();

        String type();
    }

    private static final class StudentBill implements Bill {
        private final double amount;

        StudentBill(double amount) {
            this.amount = amount;
        }

        public double finalAmount() {
            return amount * 0.90;
        }

        public String type() {
            return "STUDENT";
        }
    }

    private static final class StaffBill implements Bill {
        private final double amount;

        StaffBill(double amount) {
            this.amount = amount;
        }

        public double finalAmount() {
            return amount * 0.95;
        }

        public String type() {
            return "STAFF";
        }
    }

    private static final class GuestBill implements Bill {
        private final double amount;

        GuestBill(double amount) {
            this.amount = amount;
        }

        public double finalAmount() {
            return amount + 10;
        }

        public String type() {
            return "GUEST";
        }
    }

    private static Bill createBill(String type, double amount) {
        switch (type) {
            case "STUDENT": return new StudentBill(amount);
            case "STAFF": return new StaffBill(amount);
            case "GUEST": return new GuestBill(amount);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Bill> bills = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                bills.add(createBill(scanner.next(), scanner.nextDouble()));
            }

            double total = 0;
            for (Bill bill : bills) {
                double finalAmount = bill.finalAmount();
                System.out.printf("%s: %.2f%n", bill.type(), finalAmount);
                total += finalAmount;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}