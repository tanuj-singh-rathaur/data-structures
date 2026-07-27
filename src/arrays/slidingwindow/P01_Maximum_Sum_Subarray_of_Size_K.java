package arrays.slidingwindow;

import util.Test;

/**
 * Maximum Sum Subarray of Size K
 * Pattern : Sliding Window (fixed size)
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 * ─────────────────────────────────────────────
 * Given an integer array and int k, return the max sum of any contiguous subarray of size k.
 * Slide the window: sum += nums[R] − nums[R−K].
 */
public class P01_Maximum_Sum_Subarray_of_Size_K {

    public int maxSum(int[] nums, int k) {
        // TODO: implement using fixed-size sliding window
        return 0;
    }

    public static void main(String[] args) {
        P01_Maximum_Sum_Subarray_of_Size_K sol = new P01_Maximum_Sum_Subarray_of_Size_K();
        Test.equal("Test 1", sol.maxSum(new int[]{2,1,5,1,3,2}, 3), 9);
        Test.equal("Test 2", sol.maxSum(new int[]{2,3,4,1,5}, 2), 7);
        Test.equal("Test 3", sol.maxSum(new int[]{1,1,1,1,1}, 5), 5);
        Test.summary();
    }
}
