package arrays.kadane;

import util.Test;

/**
 * Maximum Sum of 3 Non-Overlapping Subarrays
 * Pattern : Left-best + right-best around a fixed middle window
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * ─────────────────────────────────────────────
 * Find three non-overlapping length-k subarrays with maximum total sum.
 * Return the starting indices [i, j, l] of the three chosen subarrays.
 */
public class P15_Maximum_Sum_of_3_Non_Overlapping_Subarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // TODO: implement
        return new int[0];
    }

    public static void main(String[] args) {
        P15_Maximum_Sum_of_3_Non_Overlapping_Subarrays sol = new P15_Maximum_Sum_of_3_Non_Overlapping_Subarrays();
        Test.equal("Test 1", sol.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2), new int[]{0,3,5});
        Test.equal("Test 2", sol.maxSumOfThreeSubarrays(new int[]{1,2,1,2,1,2,1,2,1}, 2), new int[]{0,2,4});
        Test.summary();
    }
}
