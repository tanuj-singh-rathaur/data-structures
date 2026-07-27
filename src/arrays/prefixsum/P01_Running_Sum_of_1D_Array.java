package arrays.prefixsum;

import util.Test;

/**
 * Running Sum of 1D Array
 * Pattern : Prefix Sum (classic)
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/running-sum-of-1d-array/
 * ─────────────────────────────────────────────
 * Return an array where each element is the sum of all previous elements + itself.
 */
public class P01_Running_Sum_of_1D_Array {

    public int[] runningSum(int[] nums) {
        // TODO: implement
        return new int[0];
    }

    public static void main(String[] args) {
        P01_Running_Sum_of_1D_Array sol = new P01_Running_Sum_of_1D_Array();
        Test.equal("Test 1", sol.runningSum(new int[]{1,2,3,4}), new int[]{1,3,6,10});
        Test.equal("Test 2", sol.runningSum(new int[]{1,1,1,1,1}), new int[]{1,2,3,4,5});
        Test.equal("Test 3", sol.runningSum(new int[]{3,1,2,10,1}), new int[]{3,4,6,16,17});
        Test.summary();
    }
}
