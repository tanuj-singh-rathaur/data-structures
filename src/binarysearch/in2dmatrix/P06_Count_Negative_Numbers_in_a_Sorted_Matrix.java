package binarysearch.in2dmatrix;

import util.Test;

/**
 * Count Negative Numbers in a Sorted Matrix
 * Pattern : Staircase Walk OR Per-Row Lower Bound
 * Difficulty: Easy
 * LeetCode  : https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Walk top-right; if &lt; 0 add (m − row), else j--; OR LB(row, 0) per row]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P06_Count_Negative_Numbers_in_a_Sorted_Matrix {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P06_Count_Negative_Numbers_in_a_Sorted_Matrix sol = new P06_Count_Negative_Numbers_in_a_Sorted_Matrix();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}), 8);

        Test.summary();
    }
}
