package binarysearch.in2dmatrix;

import util.Test;

/**
 * Find Peak Element II
 * Pattern : Binary Search on Columns (2D Peak)
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/find-a-peak-element-ii/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Binary search the column; find the max element in current column; move to the side with the larger neighbor]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P05_Find_Peak_Element_II {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P05_Find_Peak_Element_II sol = new P05_Find_Peak_Element_II();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.findPeakGrid(new int[][]{{1,4},{3,2}}), new int[]{0, 1});

        Test.summary();
    }
}
