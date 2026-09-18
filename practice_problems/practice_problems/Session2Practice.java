package practice_problems;

public class Session2Practice {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));
            if ("aeiou".indexOf(ch) >= 0) vowels++;
            else if (ch >= 'a' && ch <= 'z') consonants++;
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + fields[0] + " | Roll No: " + fields[1] + " | Dept: " + fields[2]);
    }

    public static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot <= 0 || dot == filename.length() - 1) return "Rejected - invalid file type";
        String extension = filename.substring(dot + 1);
        return extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("zip")
                ? "Accepted" : "Rejected - invalid file type";
    }

    public static String maskPhone(String phone) {
        if (phone == null || phone.length() != 10) return "Invalid phone number";
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) return "Invalid phone number";
        }
        StringBuilder result = new StringBuilder("XXXXXX");
        result.insert(result.length(), "-").append(phone.substring(6));
        return result.toString();
    }

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        String code = normalizeReference(reference);
        if (code.length() != 14) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) return "Invalid: non-digit body";
        }
        StringBuilder result = new StringBuilder();
        result.append('[').append(code, 0, 3).append("] DATE: ")
                .append(code, 3, 5).append('/').append(code, 5, 7).append('/')
                .append(code, 7, 9).append(" | SEQ: ").append(code, 9, 14);
        return result.toString();
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(maskPhone("9876543210"));
        System.out.println(validateAndFormat("  hdf03022600042  "));
    }
}
