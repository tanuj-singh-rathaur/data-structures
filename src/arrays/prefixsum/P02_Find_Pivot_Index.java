package arrays.prefixsum;

import util.Test;

/**
 * Find Pivot Index
 * Pattern : Prefix Sum (leftSum == totalSum − leftSum − nums[i])
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/find-pivot-index/
 * ─────────────────────────────────────────────
 * Return the leftmost index where sum-of-left == sum-of-right, or −1.
 */
public class P02_Find_Pivot_Index {

    public int pivotIndex(int[] nums) {
        // TODO: implement
        return -1;
    }

    public static void main(String[] args) {
        P02_Find_Pivot_Index sol = new P02_Find_Pivot_Index();
        Test.equal("Test 1", sol.pivotIndex(new int[]{1,7,3,6,5,6}), 3);
        Test.equal("Test 2", sol.pivotIndex(new int[]{1,2,3}), -1);
        Test.equal("Test 3", sol.pivotIndex(new int[]{2,1,-1}), 0);
        Test.summary();
    }
}
