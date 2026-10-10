public class Session6Problem3 {
    static class Employee {
        private final String empId;
        private final String empName;
        private final double salary;
        private final boolean intern;

        Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            intern = false;
        }

        Employee(String empId, String empName) {
            this.empId = empId;
            this.empName = empName;
            salary = 0;
            intern = true;
        }

        void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + intern);
        }
    }

    public static void main(String[] args) {
        new Employee("E-101", "Divya", 65000).printProfile();
        new Employee("E-102", "Arjun").printProfile();
    }
}