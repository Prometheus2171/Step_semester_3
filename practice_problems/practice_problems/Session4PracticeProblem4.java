package practice_problems;

import java.util.Arrays;

public class Session4PracticeProblem4 {
    public static int[] mergeSortedArrays(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            result[k++] = first[i] <= second[j] ? first[i++] : second[j++];
        }
        while (i < first.length) result[k++] = first[i++];
        while (j < second.length) result[k++] = second[j++];
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6})));
    }
}