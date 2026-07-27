package arrays.slidingwindow;

import util.Test;

/**
 * Longest Subarray with Sum K (positives only)
 * Pattern : Sliding Window (variable size)
 * Difficulty: Medium
 * ─────────────────────────────────────────────
 * Given all-positive nums and target k, return the length of the longest
 * contiguous subarray whose sum equals k.
 * Grow while sum < k, shrink while sum > k.
 */
public class P03_Longest_Subarray_with_Sum_K {

    public int longestSubarrayWithSumK(int[] nums, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P03_Longest_Subarray_with_Sum_K sol = new P03_Longest_Subarray_with_Sum_K();
        Test.equal("Test 1", sol.longestSubarrayWithSumK(new int[]{10,5,2,7,1,9}, 15), 4);
        Test.equal("Test 2", sol.longestSubarrayWithSumK(new int[]{1,2,3}, 6), 3);
        Test.equal("Test 3", sol.longestSubarrayWithSumK(new int[]{1,2,3}, 7), 0);
        Test.summary();
    }
}
