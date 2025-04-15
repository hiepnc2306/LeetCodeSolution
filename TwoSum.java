import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // create map of num with position
        Map<Integer, Integer> numsMapPos = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numsMapPos.containsKey(diff)) {
                return new int[]{numsMapPos.get(diff), i};
            } else {
                numsMapPos.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
