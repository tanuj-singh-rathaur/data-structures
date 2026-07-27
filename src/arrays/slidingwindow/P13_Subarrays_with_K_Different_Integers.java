package arrays.slidingwindow;

import util.Test;

/**
 * Subarrays with K Different Integers
 * Pattern : Sliding Window — exactly(K) = atMost(K) − atMost(K−1)
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/subarrays-with-k-different-integers/
 * ─────────────────────────────────────────────
 * Return the number of contiguous subarrays with exactly K distinct integers.
 */
public class P13_Subarrays_with_K_Different_Integers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P13_Subarrays_with_K_Different_Integers sol = new P13_Subarrays_with_K_Different_Integers();
        Test.equal("Test 1", sol.subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2), 7);
        Test.equal("Test 2", sol.subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3), 3);
        Test.summary();
    }
}
