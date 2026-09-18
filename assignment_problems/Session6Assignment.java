public class Session6Assignment {
    public static class BookInventory {
        String title;
        String author;
        int copiesAvailable;

        public BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        public void printEntry() {
            System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
        }
    }

    public static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println("Warning: negative basic salary. Starting at 0.");
                this.basicSalary = 0;
            } else {
                this.basicSalary = basicSalary;
            }
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid bonus amount. Bonus must be greater than 0.");
            } else {
                bonus += amount;
                System.out.println("Bonus credited: Rs " + amount);
            }
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Invalid tax percent. Must be between 0 and 100.");
            } else {
                basicSalary -= basicSalary * (percent / 100.0);
                System.out.println("Tax deducted: " + percent + "%");
            }
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static class Employee {
        private static final String companyName = "Bright Horizon Technologies";
        private static int employeeCount = 0;

        String empId;
        String empName;
        double salary;
        boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
            employeeCount++;
        }

        public Employee(String empId, String empName) {
            this(empId, empName, 0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static class HallTicket {
        String studentName;
        int seatNumber;

        public HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 1");
        BookInventory[] books = {
                new BookInventory("Clean Code", "Robert C. Martin", 3),
                new BookInventory("Effective Java", "Joshua Bloch", 5),
                new BookInventory("Refactoring", "Martin Fowler", 0),
                new BookInventory("Design Patterns", "GoF", 2)
        };
        for (BookInventory book : books) {
            book.printEntry();
        }

        System.out.println("\nProblem 2");
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());

        System.out.println("\nProblem 3");
        Employee employeePerm = new Employee("E-101", "Divya", 65000);
        Employee employeeIntern = new Employee("E-102", "Arjun");
        employeePerm.printProfile();
        employeeIntern.printProfile();

        System.out.println("\nProblem 4");
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;
        copy.seatNumber = 45;
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));

        System.out.println("\nProblem 5");
        Employee.employeeCount = 0;
        new Employee("E-201", "Ava");
        new Employee("E-202", "Ben");
        new Employee("E-203", "Cara");
        Employee.printCompanyInfo();
    }
}
