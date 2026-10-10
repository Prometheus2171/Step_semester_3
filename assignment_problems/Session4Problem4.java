import java.util.HashMap;
import java.util.Map;

public class Session4Problem4 {
    public static int subarraySum(int[] nums, int target) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int count = 0;
        int prefixSum = 0;
        for (int value : nums) {
            prefixSum += value;
            count += prefixCount.getOrDefault(prefixSum - target, 0);
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}