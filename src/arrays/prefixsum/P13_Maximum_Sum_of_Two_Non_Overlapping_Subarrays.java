package arrays.prefixsum;

import util.Test;

/**
 * Maximum Sum of Two Non-Overlapping Subarrays
 * Pattern : Prefix sums + rolling best-L-window seen so far
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * ─────────────────────────────────────────────
 * Two non-overlapping windows of given lengths L1 and L2. Return the max total sum.
 */
public class P13_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P13_Maximum_Sum_of_Two_Non_Overlapping_Subarrays sol = new P13_Maximum_Sum_of_Two_Non_Overlapping_Subarrays();
        Test.equal("Test 1", sol.maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2), 20);
        Test.equal("Test 2", sol.maxSumTwoNoOverlap(new int[]{3,8,1,3,2,1,8,9,0}, 3, 2), 29);
        Test.equal("Test 3", sol.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3), 31);
        Test.summary();
    }
}
