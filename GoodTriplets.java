import java.util.Map;
import java.util.TreeMap;

public class GoodTriplets {
    public static long countGoodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Step 1: Build pos map from nums2
        int[] posInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            posInNums2[nums2[i]] = i;
        }

        // Step 2: Map nums1 to nums2 positions
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = posInNums2[nums1[i]];
        }

        // Step 3: Count left smaller using TreeMap
        TreeMap<Integer, Integer> leftMap = new TreeMap<>();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = countSmaller(leftMap, mapped[i]);
            leftMap.put(mapped[i], leftMap.getOrDefault(mapped[i], 0) + 1);
        }

        // Step 4: Count right greater using TreeMap
        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = countGreater(rightMap, mapped[i]);
            rightMap.put(mapped[i], rightMap.getOrDefault(mapped[i], 0) + 1);
        }

        // Step 5: Compute total triplets
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (long) left[i] * right[i];
        }

        return total;
    }

    // Count number of keys in map < value
    private static int countSmaller(TreeMap<Integer, Integer> map, int value) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.headMap(value, false).entrySet()) {
            count += entry.getValue();
        }
        return count;
    }

    // Count number of keys in map > value
    private static int countGreater(TreeMap<Integer, Integer> map, int value) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.tailMap(value + 1).entrySet()) {
            count += entry.getValue();
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0, 3};
        int[] nums2 = {2, 3, 1, 0};
        System.out.println("Total good triplets: " + countGoodTriplets(nums1, nums2));
    }
}
