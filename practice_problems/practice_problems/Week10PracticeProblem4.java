import java.util.Arrays;
import java.util.Scanner;

public class Week10PracticeProblem4 {
    public static void reverseInPlace(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int value = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = value;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            int[] numbers = new int[count];
            for (int i = 0; i < count; i++) {
                numbers[i] = scanner.nextInt();
            }
            reverseInPlace(numbers);
            System.out.println(Arrays.toString(numbers));
        }
    }
}