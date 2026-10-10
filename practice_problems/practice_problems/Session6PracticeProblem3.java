package practice_problems;

public class Session6PracticeProblem3 {
    static class Course {
        private final String code;
        private final String title;
        private final int credits;
        private final int labCredits;

        Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        int totalCredits() {
            return credits + labCredits;
        }

        String getCode() {
            return code;
        }
    }

    public static void main(String[] args) {
        Course theory = new Course("21CSC201J", "Data Structures", 4);
        Course lab = new Course("21CSC205L", "DSA Lab", 3, 1);
        System.out.println(theory.getCode() + " total credits: " + theory.totalCredits());
        System.out.println(lab.getCode() + " total credits: " + lab.totalCredits());
    }
}