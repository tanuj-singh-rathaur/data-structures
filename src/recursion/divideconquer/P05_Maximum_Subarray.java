package recursion.divideconquer;

import util.Test;

/**
 * Maximum Subarray (Divide & Conquer variant)
 * Topic    : Recursion
 * Pattern  : Divide & Conquer (Left, Right, Cross-Mid)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-subarray/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/maximum-subarray/
 *
 * PATTERN HINT:
 *   [max = max(left, right, crossingMidSum). Cross handles spans crossing the midpoint.]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P05_Maximum_Subarray {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P05_Maximum_Subarray sol = new P05_Maximum_Subarray();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);

        Test.summary();
    }
}
