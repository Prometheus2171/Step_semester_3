package practice_problems;

public class Session2PracticeProblem2 {
    public static String parseStudentRecord(String csvLine) {
        if (csvLine == null) return "Invalid Record";
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) return "Invalid Record";
        return "Name: " + fields[0] + " | Roll No: " + fields[1] + " | Dept: " + fields[2];
    }

    public static void main(String[] args) {
        System.out.println(parseStudentRecord("Ananya Verma,RA2211003010123,CSE"));
    }
}