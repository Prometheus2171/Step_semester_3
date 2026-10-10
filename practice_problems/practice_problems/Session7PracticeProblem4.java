package practice_problems;

public class Session7PracticeProblem4 {
    static class Locker {
        private final int lockerNumber;
        private String combination;

        Locker(int lockerNumber, String initialCode) {
            if (initialCode == null) {
                throw new IllegalArgumentException("Initial code cannot be null");
            }
            this.lockerNumber = lockerNumber;
            combination = initialCode;
        }

        int getLockerNumber() {
            return lockerNumber;
        }

        boolean changeCode(String currentCode, String newCode) {
            if (currentCode == null || newCode == null || !combination.equals(currentCode)) {
                return false;
            }
            combination = newCode;
            return true;
        }
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println(locker.changeCode("1234", "5678"));
        System.out.println(locker.changeCode("0000", "9999"));
    }
}