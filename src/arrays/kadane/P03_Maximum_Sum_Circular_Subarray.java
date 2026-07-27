package arrays.kadane;

import util.Test;

/**
 * Maximum Sum Circular Subarray
 * Pattern : Kadane (twice — max + min)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-sum-circular-subarray/
 * ─────────────────────────────────────────────
 * max(kadaneMax, totalSum − kadaneMin), with edge case: if all-negative,
 * answer = kadaneMax (can't take empty subarray).
 */
public class P03_Maximum_Sum_Circular_Subarray {

    public int maxSubarraySumCircular(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P03_Maximum_Sum_Circular_Subarray sol = new P03_Maximum_Sum_Circular_Subarray();
        Test.equal("Test 1", sol.maxSubarraySumCircular(new int[]{1,-2,3,-2}), 3);
        Test.equal("Test 2", sol.maxSubarraySumCircular(new int[]{5,-3,5}), 10);
        Test.equal("Test 3", sol.maxSubarraySumCircular(new int[]{-3,-2,-3}), -2);
        Test.summary();
    }
}
