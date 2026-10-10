package practice_problems;

public class Session2PracticeProblem4 {
    public static String maskPhone(String phone) {
        if (phone == null || phone.length() != 10) return "Invalid phone number";
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) return "Invalid phone number";
        }
        return "XXXXXX-" + phone.substring(6);
    }

    public static void main(String[] args) {
        System.out.println(maskPhone("9876543210"));
    }
}