public class Session2Problem4 {
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static void main(String[] args) {
        System.out.println(normalizeCode(" pen2026004251 "));
    }
}