package arrays.slidingwindow;

import util.Test;

/**
 * Max Consecutive Ones III
 * Pattern : Sliding Window (at most k zeros in window)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/max-consecutive-ones-iii/
 * ─────────────────────────────────────────────
 * Longest subarray of 1s allowing at most k zeros to be flipped.
 */
public class P05_Max_Consecutive_Ones_III {

    public int longestOnes(int[] nums, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P05_Max_Consecutive_Ones_III sol = new P05_Max_Consecutive_Ones_III();
        Test.equal("Test 1", sol.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2), 6);
        Test.equal("Test 2", sol.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3), 10);
        Test.summary();
    }
}
