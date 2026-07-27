package arrays.prefixsum;

import util.Test;

/**
 * Continuous Subarray Sum
 * Pattern : Prefix sum mod k; HashMap of first-seen remainder
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/continuous-subarray-sum/
 * ─────────────────────────────────────────────
 * Return true iff some contiguous subarray of length ≥ 2 has sum divisible by k.
 */
public class P07_Continuous_Subarray_Sum {

    public boolean checkSubarraySum(int[] nums, int k) {
        // TODO: implement
        return false;
    }

    public static void main(String[] args) {
        P07_Continuous_Subarray_Sum sol = new P07_Continuous_Subarray_Sum();
        Test.equal("Test 1", sol.checkSubarraySum(new int[]{23,2,4,6,7}, 6), true);
        Test.equal("Test 2", sol.checkSubarraySum(new int[]{23,2,6,4,7}, 6), true);
        Test.equal("Test 3", sol.checkSubarraySum(new int[]{23,2,6,4,7}, 13), false);
        Test.summary();
    }
}
