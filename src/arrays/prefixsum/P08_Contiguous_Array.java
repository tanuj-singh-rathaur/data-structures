package arrays.prefixsum;

import util.Test;

/**
 * Contiguous Array (equal 0s and 1s)
 * Pattern : Treat 0 as −1; longest subarray with prefix sum == 0
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/contiguous-array/
 * ─────────────────────────────────────────────
 * Return length of the longest contiguous subarray with equal count of 0 and 1.
 */
public class P08_Contiguous_Array {

    public int findMaxLength(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P08_Contiguous_Array sol = new P08_Contiguous_Array();
        Test.equal("Test 1", sol.findMaxLength(new int[]{0,1}), 2);
        Test.equal("Test 2", sol.findMaxLength(new int[]{0,1,0}), 2);
        Test.equal("Test 3", sol.findMaxLength(new int[]{0,0,1,0,0,0,1,1}), 6);
        Test.summary();
    }
}
