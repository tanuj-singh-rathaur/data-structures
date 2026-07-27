package arrays.slidingwindow;

import util.Test;

/**
 * Binary Subarrays With Sum
 * Pattern : Sliding Window (exactly(goal) = atMost(goal) − atMost(goal−1))
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/binary-subarrays-with-sum/
 * ─────────────────────────────────────────────
 * Return the number of contiguous subarrays of a 0/1 array with sum == goal.
 */
public class P19_Binary_Subarrays_With_Sum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P19_Binary_Subarrays_With_Sum sol = new P19_Binary_Subarrays_With_Sum();
        Test.equal("Test 1", sol.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2), 4);
        Test.equal("Test 2", sol.numSubarraysWithSum(new int[]{0,0,0,0,0}, 0), 15);
        Test.summary();
    }
}
