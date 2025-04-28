import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // -4, -3, -2, -1 => bucket -1 => (-4 + 1) / 4 - 1
        // 0, 1, 2, 3 => bucket 0 => so / 4 = 0
        // 4, 5, 6, 7 => bucket 1 => so / 4 = 1
        // 8, 9, 10, 11 => bucket 2 => so / 4 = 2
        // neu valueDiff = 3 => se khong co 4 so lien tiep nao ma hieu so > 3

        // [1, 2, 3, 4, 5, 6, 7, 8] indexDiff = 3
        if (nums.length <= 1 || indexDiff <= 0 || valueDiff < 0) return false;

        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long bucketNumber = getBucketNumber(num, valueDiff);
            if (buckets.containsKey(bucketNumber)) return true;
            if (buckets.containsKey(bucketNumber + 1) && Math.abs(buckets.get(bucketNumber + 1) - num) <= valueDiff) return true;
            if (buckets.containsKey(bucketNumber - 1) && Math.abs(buckets.get(bucketNumber - 1) - num) <= valueDiff) return true;

            if (i >= indexDiff) {
                long oldBucketNumber = getBucketNumber(nums[i - indexDiff], valueDiff);
                buckets.remove(oldBucketNumber);
            }

            buckets.put(bucketNumber, num);
        }

        return false;
    }


    public long getBucketNumber(long num, long valueDiff) {
        return num >= 0 ? (num / (valueDiff + 1)) : ((num - 1) / (valueDiff + 1) - 1);
    }

}
