package dp.linear;
import util.Test;
/**
 * Maximum Subarray (Kadane)
 * Topic    : DP Linear
 * Pattern  : cur = max(nums[i], cur + nums[i]); best = max(best, cur)
 * Difficulty: Medium
 * Source   : LC 53
 */
public class P06_Maximum_Subarray {
    public static void main(String[] args) {
        P06_Maximum_Subarray sol = new P06_Maximum_Subarray();
        Test.summary();
    }
}
