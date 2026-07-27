package arrays.kadane;

import util.Test;

/**
 * Maximum Subarray Min-Product
 * Pattern : Monotonic stack (find widest range each element is minimum of) + prefix sums
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-subarray-min-product/
 * ─────────────────────────────────────────────
 * min-product(subarray) = min(subarray) * sum(subarray). Return the max
 * such value across all subarrays, mod 1e9+7.
 */
public class P16_Maximum_Subarray_Min_Product {

    public int maxSumMinProduct(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P16_Maximum_Subarray_Min_Product sol = new P16_Maximum_Subarray_Min_Product();
        Test.equal("Test 1", sol.maxSumMinProduct(new int[]{1,2,3,2}), 14);
        Test.equal("Test 2", sol.maxSumMinProduct(new int[]{2,3,3,1,2}), 18);
        Test.equal("Test 3", sol.maxSumMinProduct(new int[]{3,1,5,6,4,2}), 60);
        Test.summary();
    }
}
