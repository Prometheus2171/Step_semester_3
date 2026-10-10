package practice_problems;

import java.util.Arrays;

public class Session4PracticeProblem5 {
    public static int[] rotateArray(int[] nums, int distance) {
        if (nums.length == 0) {
            return nums;
        }
        int[] rotated = new int[nums.length];
        int normalizedDistance = ((distance % nums.length) + nums.length) % nums.length;
        for (int i = 0; i < nums.length; i++) {
            rotated[(i + normalizedDistance) % nums.length] = nums[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }
}