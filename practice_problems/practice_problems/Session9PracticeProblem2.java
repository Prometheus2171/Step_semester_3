import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9PracticeProblem2 {
    private abstract static class StaffMember {
        private final String name;

        StaffMember(String name) {
            this.name = name;
        }

        abstract double pay();

        String name() {
            return name;
        }
    }

    private static final class FullTimeStaff extends StaffMember {
        private final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        double pay() { return weeklySalary; }
    }

    private static final class HourlyStaff extends StaffMember {
        private final double hours;
        private final double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double pay() {
            return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5;
        }
    }

    private static final class Intern extends StaffMember {
        private final double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<StaffMember> staff = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                String name = scanner.next();
                switch (type) {
                    case "FULLTIME":
                        staff.add(new FullTimeStaff(name, scanner.nextDouble()));
                        break;
                    case "HOURLY":
                        staff.add(new HourlyStaff(name, scanner.nextDouble(), scanner.nextDouble()));
                        break;
                    case "INTERN":
                        staff.add(new Intern(name, scanner.nextDouble()));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown staff type: " + type);
                }
            }
            double totalPayroll = 0;
            for (StaffMember member : staff) {
                double pay = member.pay();
                System.out.printf("%s: %.2f%n", member.name(), pay);
                totalPayroll += pay;
            }
            System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        }
    }
}