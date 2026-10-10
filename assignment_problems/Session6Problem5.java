public class Session6Problem5 {
    static class Employee {
        private static final String COMPANY_NAME = "Bright Horizon Technologies";
        private static int employeeCount;

        Employee(String empId, String empName) {
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(COMPANY_NAME);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("E-201", "Ava");
        new Employee("E-202", "Ben");
        new Employee("E-203", "Cara");
        Employee.printCompanyInfo();
    }
}