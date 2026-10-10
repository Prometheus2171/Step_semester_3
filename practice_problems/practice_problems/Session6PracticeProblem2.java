package practice_problems;

public class Session6PracticeProblem2 {
    static class MessWallet {
        private double balance;

        MessWallet(double openingBalance) {
            balance = Math.max(0, openingBalance);
        }

        void topUp(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        boolean deduct(double amount) {
            if (amount < 0 || amount > balance) {
                return false;
            }
            balance -= amount;
            return true;
        }

        double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}