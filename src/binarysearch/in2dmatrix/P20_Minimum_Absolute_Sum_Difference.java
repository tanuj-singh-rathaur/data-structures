package binarysearch.in2dmatrix;

import util.Test;

/**
 * Minimum Absolute Sum Difference
 * Pattern : Sort + Per-Index Lower Bound to Find Best Replacement
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/minimum-absolute-sum-difference/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Sort nums1; for each i, LB nums2[i] in sorted nums1 to find closest replacement; track max reduction]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P20_Minimum_Absolute_Sum_Difference {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P20_Minimum_Absolute_Sum_Difference sol = new P20_Minimum_Absolute_Sum_Difference();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.minAbsoluteSumDiff(new int[]{1,7,5}, new int[]{2,3,5}), 3);

        Test.summary();
    }
}
