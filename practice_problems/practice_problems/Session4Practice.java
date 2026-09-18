package practice_problems;

import java.util.Arrays;

public class Session4Practice {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[0];
    }

    public static int maxProfit(int[] prices) {
        int minimum = Integer.MAX_VALUE;
        int bestProfit = 0;
        for (int price : prices) {
            minimum = Math.min(minimum, price);
            bestProfit = Math.max(bestProfit, price - minimum);
        }
        return bestProfit;
    }

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            result[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }
        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];
        return result;
    }

    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) return nums;
        int[] rotated = new int[nums.length];
        k = ((k % nums.length) + nums.length) % nums.length;
        for (int i = 0; i < nums.length; i++) rotated[(i + k) % nums.length] = nums[i];
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6})));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }
}
