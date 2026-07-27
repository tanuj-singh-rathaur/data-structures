package arrays.slidingwindow;

import util.Test;

/**
 * Count Number of Nice Subarrays
 * Pattern : Sliding Window (exactly K odd = atMost(K) − atMost(K−1))
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/count-number-of-nice-subarrays/
 * ─────────────────────────────────────────────
 * Return the number of contiguous subarrays with exactly k odd numbers.
 */
public class P18_Count_Number_of_Nice_Subarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P18_Count_Number_of_Nice_Subarrays sol = new P18_Count_Number_of_Nice_Subarrays();
        Test.equal("Test 1", sol.numberOfSubarrays(new int[]{1,1,2,1,1}, 3), 2);
        Test.equal("Test 2", sol.numberOfSubarrays(new int[]{2,4,6}, 1), 0);
        Test.equal("Test 3", sol.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2), 16);
        Test.summary();
    }
}
