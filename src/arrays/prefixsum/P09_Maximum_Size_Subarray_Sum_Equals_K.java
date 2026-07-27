package arrays.prefixsum;

import util.Test;

/**
 * Maximum Size Subarray Sum Equals K
 * Pattern : Prefix Sum + HashMap of first-seen sum
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * ─────────────────────────────────────────────
 * Return the length of the longest contiguous subarray with sum == k.
 * Works with negative numbers.
 */
public class P09_Maximum_Size_Subarray_Sum_Equals_K {

    public int maxSubArrayLen(int[] nums, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P09_Maximum_Size_Subarray_Sum_Equals_K sol = new P09_Maximum_Size_Subarray_Sum_Equals_K();
        Test.equal("Test 1", sol.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3), 4);
        Test.equal("Test 2", sol.maxSubArrayLen(new int[]{-2,-1,2,1}, 1), 2);
        Test.summary();
    }
}
