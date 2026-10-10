package practice_problems;

public class Session6PracticeProblem5 {
    static class Student {
        private static final String COLLEGE_NAME = "SRM Institute of Science and Technology";
        private static int studentCount;

        Student(String name, int attendance) {
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(COLLEGE_NAME);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new Student("A", 90);
        new Student("B", 85);
        Student.printCollegeInfo();
    }
}