package practice_problems;

public class Session6Practice {
    public static class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;

        public PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        public void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public static class MessWallet {
        private double balance;

        public MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Warning: negative opening balance. Starting at 0.");
                balance = 0;
            } else {
                balance = openingBalance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be positive");
                return;
            }
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }

        public void deduct(double amount) {
            if (amount < 0 || amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static class Course {
        String code;
        String title;
        int credits;
        int labCredits;

        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        public int totalCredits() {
            return credits + labCredits;
        }
    }

    public static class IdCard {
        String name;
        int booksIssued;

        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static class Student {
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount;
        String name;
        int attendance;

        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        PlacementRecord[] records = {new PlacementRecord("Ravi", "TCS", 4.5), new PlacementRecord("Anitha", "Zoho", 6.2), new PlacementRecord("Karthik", "Infosys", 4.0)};
        for (PlacementRecord record : records) record.printRecord();
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
        Course theory = new Course("21CSC201J", "Data Structures", 4);
        Course lab = new Course("21CSC205L", "DSA Lab", 3, 1);
        System.out.println(theory.code + " total credits: " + theory.totalCredits());
        System.out.println(lab.code + " total credits: " + lab.totalCredits());
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
        Student.studentCount = 0;
        new Student("A", 90);
        new Student("B", 85);
        Student.printCollegeInfo();
    }
}
