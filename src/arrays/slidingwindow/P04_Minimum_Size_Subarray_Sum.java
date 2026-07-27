package arrays.slidingwindow;

import util.Test;

/**
 * Minimum Size Subarray Sum
 * Pattern : Sliding Window (shrink to minimum)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/minimum-size-subarray-sum/
 * ─────────────────────────────────────────────
 * Return the min length of a contiguous subarray with sum >= target. 0 if none.
 */
public class P04_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int target, int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P04_Minimum_Size_Subarray_Sum sol = new P04_Minimum_Size_Subarray_Sum();
        Test.equal("Test 1", sol.minSubArrayLen(7, new int[]{2,3,1,2,4,3}), 2);
        Test.equal("Test 2", sol.minSubArrayLen(4, new int[]{1,4,4}), 1);
        Test.equal("Test 3", sol.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}), 0);
        Test.summary();
    }
}
