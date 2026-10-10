public class Session6Problem2 {
    static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        PayrollAccount(double basicSalary) {
            this.basicSalary = Math.max(0, basicSalary);
        }

        void creditBonus(double amount) {
            if (amount > 0) {
                bonus += amount;
            }
        }

        void deductTax(double percent) {
            if (percent >= 0 && percent <= 100) {
                basicSalary -= basicSalary * percent / 100.0;
            }
        }

        double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}