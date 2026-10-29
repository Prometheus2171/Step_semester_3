import java.util.Arrays;
import java.util.Scanner;

public class ProblemDutyRosterRotation {
    public static String[] rotateRoster(String[] names, int k) {
        int shift = k % names.length;
        String[] rotated = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            rotated[(i + shift) % names.length] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            String[] names = new String[count];
            for (int i = 0; i < count; i++) {
                names[i] = scanner.next();
            }
            int rotations = scanner.nextInt();
            System.out.println(Arrays.toString(rotateRoster(names, rotations)));
        }
    }
}