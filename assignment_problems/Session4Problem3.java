import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Session4Problem3 {
    public static int[][] threeSum(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        List<int[]> triplets = new ArrayList<>();
        for (int i = 0; i < sorted.length - 2; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = sorted.length - 1;
            while (left < right) {
                int sum = sorted[i] + sorted[left] + sorted[right];
                if (sum == 0) {
                    triplets.add(new int[]{sorted[i], sorted[left], sorted[right]});
                    while (left < right && sorted[left] == sorted[left + 1]) left++;
                    while (left < right && sorted[right] == sorted[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
    }
}