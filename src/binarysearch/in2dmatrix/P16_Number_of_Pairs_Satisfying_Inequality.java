package binarysearch.in2dmatrix;

import util.Test;

/**
 * Number of Pairs Satisfying Inequality
 * Pattern : Transform + Sorted Lower Bound
 * Difficulty: Hard
 * LeetCode  : https://leetcode.com/problems/number-of-pairs-satisfying-inequality/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Let d[i] = nums1[i] − nums2[i]; condition becomes d[i] − d[j] ≤ diff for i &lt; j; merge sort or sorted-list lower bound]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P16_Number_of_Pairs_Satisfying_Inequality {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P16_Number_of_Pairs_Satisfying_Inequality sol = new P16_Number_of_Pairs_Satisfying_Inequality();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.numberOfPairs(new int[]{3,2,5}, new int[]{2,2,1}, 1), 3L);

        Test.summary();
    }
}
