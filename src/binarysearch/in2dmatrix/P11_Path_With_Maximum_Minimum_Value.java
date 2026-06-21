package binarysearch.in2dmatrix;

import util.Test;

/**
 * Path With Maximum Minimum Value
 * Pattern : Binary Search Answer + BFS/Union-Find Reachability
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/path-with-maximum-minimum-value/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Binary search threshold t; check if (0,0)→(m-1,n-1) reachable using only cells ≥ t]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P11_Path_With_Maximum_Minimum_Value {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P11_Path_With_Maximum_Minimum_Value sol = new P11_Path_With_Maximum_Minimum_Value();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.maximumMinimumPath(new int[][]{{5,4,5},{1,2,6},{7,4,6}}), 4);

        Test.summary();
    }
}
