public class Session2Problem5 {
    public static String validateAndFormat(String code) {
        String normalized = code == null ? "" : code.trim();
        if (normalized.length() < 3) {
            return "Invalid: wrong length";
        }
        normalized = normalized.substring(0, 3).toUpperCase() + normalized.substring(3);
        if (normalized.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < normalized.length(); i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        return "[" + normalized.substring(0, 3) + "] YEAR: " + normalized.substring(3, 7)
                + " | CATALOG: " + normalized.substring(7);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(" pen2026004251 "));
        System.out.println(validateAndFormat("12N2026004251"));
    }
}