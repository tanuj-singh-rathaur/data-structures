package arrays.prefixsum;

import util.Test;

/**
 * Sum of Absolute Differences in a Sorted Array
 * Pattern : Split each i's contribution into "left side" and "right side" via prefix sums
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 * ─────────────────────────────────────────────
 * result[i] = i*nums[i] − prefixLeft[i] + (suffixRight[i] − (n−1−i)*nums[i]).
 */
public class P18_Sum_of_Absolute_Differences_in_Sorted_Array {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        // TODO: implement
        return new int[0];
    }

    public static void main(String[] args) {
        P18_Sum_of_Absolute_Differences_in_Sorted_Array sol = new P18_Sum_of_Absolute_Differences_in_Sorted_Array();
        Test.equal("Test 1", sol.getSumAbsoluteDifferences(new int[]{2,3,5}), new int[]{4,3,5});
        Test.equal("Test 2", sol.getSumAbsoluteDifferences(new int[]{1,4,6,8,10}), new int[]{24,15,13,15,21});
        Test.summary();
    }
}
