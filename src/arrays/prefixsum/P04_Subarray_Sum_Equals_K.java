package arrays.prefixsum;

import util.Test;

/**
 * Subarray Sum Equals K
 * Pattern : Prefix Sum + HashMap of {prefix : count}
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/subarray-sum-equals-k/
 * ─────────────────────────────────────────────
 * Return the number of contiguous subarrays with sum == k. Works with negatives.
 */
public class P04_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P04_Subarray_Sum_Equals_K sol = new P04_Subarray_Sum_Equals_K();
        Test.equal("Test 1", sol.subarraySum(new int[]{1,1,1}, 2), 2);
        Test.equal("Test 2", sol.subarraySum(new int[]{1,2,3}, 3), 2);
        Test.equal("Test 3", sol.subarraySum(new int[]{1,-1,0}, 0), 3);
        Test.summary();
    }
}
