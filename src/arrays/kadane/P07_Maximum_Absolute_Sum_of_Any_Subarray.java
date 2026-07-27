package arrays.kadane;

import util.Test;

/**
 * Maximum Absolute Sum of Any Subarray
 * Pattern : Kadane twice (find max sum AND min sum; answer = max(maxSum, |minSum|))
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
 */
public class P07_Maximum_Absolute_Sum_of_Any_Subarray {

    public int maxAbsoluteSum(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P07_Maximum_Absolute_Sum_of_Any_Subarray sol = new P07_Maximum_Absolute_Sum_of_Any_Subarray();
        Test.equal("Test 1", sol.maxAbsoluteSum(new int[]{1,-3,2,3,-4}), 5);
        Test.equal("Test 2", sol.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}), 8);
        Test.summary();
    }
}
