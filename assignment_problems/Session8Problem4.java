import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session8Problem4 {
    private interface Employee {
        double bonus();

        String name();
    }

    private static final class FullTimeEmployee implements Employee {
        private final String name;
        private final double salary;

        FullTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double bonus() {
            return salary * 0.10;
        }

        public String name() {
            return name;
        }
    }

    private static final class PartTimeEmployee implements Employee {
        private final String name;
        private final double salary;

        PartTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double bonus() {
            return salary * 0.05;
        }

        public String name() {
            return name;
        }
    }

    private static final class Intern implements Employee {
        private final String name;

        Intern(String name) {
            this.name = name;
        }

        public double bonus() {
            return 2000;
        }

        public String name() {
            return name;
        }
    }

    private static Employee createEmployee(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN": return new Intern(name);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Employee> employees = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                employees.add(createEmployee(scanner.next(), scanner.next(), scanner.nextDouble()));
            }

            double total = 0;
            for (Employee employee : employees) {
                double bonus = employee.bonus();
                System.out.printf("%s: %.2f%n", employee.name(), bonus);
                total += bonus;
            }
            System.out.printf("Total Bonus: %.2f%n", total);
        }
    }
}