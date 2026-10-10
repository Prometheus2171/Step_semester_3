import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9Problem3 {
    private interface BusRider {
        double TRANSPORT_FEE = 12000;
    }

    private abstract static class Student {
        private final String name;

        Student(String name) {
            this.name = name;
        }

        abstract double tuition();

        double hostelFee() {
            return 0;
        }

        double transportFee() {
            return 0;
        }

        String name() {
            return name;
        }

        double totalFee() {
            return tuition() + hostelFee() + transportFee();
        }
    }

    private static final class DayScholar extends Student implements BusRider {
        DayScholar(String name) { super(name); }
        double tuition() { return 40000; }
        double transportFee() { return TRANSPORT_FEE; }
    }

    private static final class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double tuition() { return 40000; }
        double hostelFee() { return 60000; }
    }

    private static final class ScholarshipStudent extends Student implements BusRider {
        ScholarshipStudent(String name) { super(name); }
        double tuition() { return 20000; }
        double transportFee() { return TRANSPORT_FEE; }
    }

    private static Student createStudent(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            case "SCHOLAR": return new ScholarshipStudent(name);
            default: throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                students.add(createStudent(scanner.next(), scanner.next()));
            }
            double total = 0;
            for (Student student : students) {
                double fee = student.totalFee();
                System.out.printf("%s: %.2f%n", student.name(), fee);
                total += fee;
            }
            System.out.printf("Total Collected: %.2f%n", total);
        }
    }
}