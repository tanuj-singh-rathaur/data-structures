package arrays.slidingwindow;

import util.Test;

/**
 * Max Consecutive Ones
 * Pattern : Sliding Window (max streak)
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/max-consecutive-ones/
 * ─────────────────────────────────────────────
 * Return the length of the longest run of consecutive 1s in a binary array.
 */
public class P02_Max_Consecutive_ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P02_Max_Consecutive_ones sol = new P02_Max_Consecutive_ones();
        Test.equal("Test 1", sol.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}), 3);
        Test.equal("Test 2", sol.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}), 2);
        Test.equal("Test 3", sol.findMaxConsecutiveOnes(new int[]{0}), 0);
        Test.equal("Test 4", sol.findMaxConsecutiveOnes(new int[]{1,1,1}), 3);
        Test.summary();
    }
}
