package arrays.prefixsum;

import util.Test;

/**
 * Minimum Operations to Reduce X to Zero
 * Pattern : Reframe as "longest middle subarray summing to total − x"
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * ─────────────────────────────────────────────
 * Each op removes leftmost or rightmost element from x. Return min ops to reach 0, else −1.
 */
public class P16_Minimum_Operations_to_Reduce_X_to_Zero {

    public int minOperations(int[] nums, int x) {
        // TODO: implement
        return -1;
    }

    public static void main(String[] args) {
        P16_Minimum_Operations_to_Reduce_X_to_Zero sol = new P16_Minimum_Operations_to_Reduce_X_to_Zero();
        Test.equal("Test 1", sol.minOperations(new int[]{1,1,4,2,3}, 5), 2);
        Test.equal("Test 2", sol.minOperations(new int[]{5,6,7,8,9}, 4), -1);
        Test.equal("Test 3", sol.minOperations(new int[]{3,2,20,1,1,3}, 10), 5);
        Test.summary();
    }
}
