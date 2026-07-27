package arrays.kadane;

import util.Test;

/**
 * Maximum Subarray (Kadane classic)
 * Pattern : Kadane's Algorithm
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-subarray/
 * ─────────────────────────────────────────────
 * Return the maximum sum of any contiguous subarray.
 * cur = max(nums[i], cur + nums[i]); best = max(best, cur).
 */
public class P01_Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P01_Maximum_Subarray sol = new P01_Maximum_Subarray();
        Test.equal("Test 1", sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);
        Test.equal("Test 2", sol.maxSubArray(new int[]{1}), 1);
        Test.equal("Test 3", sol.maxSubArray(new int[]{5,4,-1,7,8}), 23);
        Test.equal("Test 4", sol.maxSubArray(new int[]{-3,-1,-2}), -1);
        Test.summary();
    }
}
