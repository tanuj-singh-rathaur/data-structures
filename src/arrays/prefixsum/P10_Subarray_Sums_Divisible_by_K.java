package arrays.prefixsum;

import util.Test;

/**
 * Subarray Sums Divisible by K
 * Pattern : Prefix sum mod K + count of each remainder
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * ─────────────────────────────────────────────
 * Return the number of contiguous subarrays whose sum is divisible by k.
 * Two prefix sums with the SAME remainder ⇒ their difference is divisible.
 */
public class P10_Subarray_Sums_Divisible_by_K {

    public int subarraysDivByK(int[] nums, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P10_Subarray_Sums_Divisible_by_K sol = new P10_Subarray_Sums_Divisible_by_K();
        Test.equal("Test 1", sol.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5), 7);
        Test.equal("Test 2", sol.subarraysDivByK(new int[]{5}, 9), 0);
        Test.summary();
    }
}
