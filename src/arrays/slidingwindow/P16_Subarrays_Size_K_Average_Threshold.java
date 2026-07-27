package arrays.slidingwindow;

import util.Test;

/**
 * Number of Sub-arrays of Size K with Average ≥ Threshold
 * Pattern : Sliding Window (fixed size, count qualifying windows)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 * ─────────────────────────────────────────────
 * Count how many subarrays of size K have average ≥ threshold
 * (equivalent to: sum ≥ K * threshold).
 */
public class P16_Subarrays_Size_K_Average_Threshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P16_Subarrays_Size_K_Average_Threshold sol = new P16_Subarrays_Size_K_Average_Threshold();
        Test.equal("Test 1", sol.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4), 3);
        Test.equal("Test 2", sol.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5), 6);
        Test.summary();
    }
}
