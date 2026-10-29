package practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session8PracticeProblem1 {
    private interface PaymentMethod {
        double adjustedAmount();
        String type();
    }

    private static final class CardPayment implements PaymentMethod {
        private final double amount;

        private CardPayment(double amount) {
            this.amount = amount;
        }

        public double adjustedAmount() {
            return amount * 1.02;
        }

        public String type() {
            return "CARD";
        }
    }

    private static final class WalletPayment implements PaymentMethod {
        private final double amount;

        private WalletPayment(double amount) {
            this.amount = amount;
        }

        public double adjustedAmount() {
            return amount * 1.01;
        }

        public String type() {
            return "WALLET";
        }
    }

    private static final class BankTransferPayment implements PaymentMethod {
        private final double amount;

        private BankTransferPayment(double amount) {
            this.amount = amount;
        }

        public double adjustedAmount() {
            return amount;
        }

        public String type() {
            return "BANKTRANSFER";
        }
    }

    private static PaymentMethod createPayment(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<PaymentMethod> payments = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                double amount = scanner.nextDouble();
                payments.add(createPayment(type, amount));
            }

            double total = 0.0;
            for (PaymentMethod payment : payments) {
                double adjusted = payment.adjustedAmount();
                System.out.printf("%s: %.2f%n", payment.type(), adjusted);
                total += adjusted;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
