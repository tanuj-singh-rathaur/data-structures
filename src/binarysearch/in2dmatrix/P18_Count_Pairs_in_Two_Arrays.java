package binarysearch.in2dmatrix;

import util.Test;

/**
 * Count Pairs in Two Arrays
 * Pattern : Transform + Sort + Two Pointer
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/count-pairs-in-two-arrays/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Let d[i] = nums1[i] − nums2[i]; pair (i, j) valid iff d[i] + d[j] &gt; 0; sort d and two-pointer]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P18_Count_Pairs_in_Two_Arrays {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P18_Count_Pairs_in_Two_Arrays sol = new P18_Count_Pairs_in_Two_Arrays();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.countPairs(new int[]{2,1,2,1}, new int[]{1,2,1,2}), 1L);

        Test.summary();
    }
}
