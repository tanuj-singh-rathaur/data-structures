package arrays.slidingwindow;

import util.Test;

/**
 * Subarray Product Less Than K
 * Pattern : Sliding Window (shrink L while product ≥ K)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/subarray-product-less-than-k/
 * ─────────────────────────────────────────────
 * Count contiguous subarrays whose product is strictly less than k.
 * At each R, add (R − L + 1) — that's how many new valid subarrays end at R.
 */
public class P20_Subarray_Product_Less_Than_K {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P20_Subarray_Product_Less_Than_K sol = new P20_Subarray_Product_Less_Than_K();
        Test.equal("Test 1", sol.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100), 8);
        Test.equal("Test 2", sol.numSubarrayProductLessThanK(new int[]{1,2,3}, 0), 0);
        Test.summary();
    }
}
