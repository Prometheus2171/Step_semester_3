package practice_problems;

public class Session2PracticeProblem5 {
    public static String validateAndFormat(String reference) {
        String raw = reference == null ? "" : reference.trim();
        if (raw.length() < 3) return "Invalid: wrong length";
        String code = raw.substring(0, 3).toUpperCase() + raw.substring(3);
        if (code.length() != 14) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) return "Invalid: non-digit body";
        }
        return "[" + code.substring(0, 3) + "] DATE: " + code.substring(3, 5) + "/"
                + code.substring(5, 7) + "/" + code.substring(7, 9) + " | SEQ: " + code.substring(9);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat("  hdf03022600042  "));
    }
}