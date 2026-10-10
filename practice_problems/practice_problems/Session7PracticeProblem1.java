package practice_problems;

public class Session7PracticeProblem1 {
    static class PiggyBank {
        private final String id;
        private long savings;

        PiggyBank(String id) {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null");
            }
            this.id = id;
        }

        String getId() {
            return id;
        }

        boolean deposit(long amount) {
            if (amount <= 0) {
                return false;
            }
            savings = Math.addExact(savings, amount);
            return true;
        }

        boolean withdraw(long amount) {
            if (amount <= 0 || amount > savings) {
                return false;
            }
            savings -= amount;
            return true;
        }

        long getSavings() {
            return savings;
        }
    }

    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank("PB-1");
        bank.deposit(100);
        bank.withdraw(30);
        bank.withdraw(500);
        System.out.println(bank.getSavings());
    }
}