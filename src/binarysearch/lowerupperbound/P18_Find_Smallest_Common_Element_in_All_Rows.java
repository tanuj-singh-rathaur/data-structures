package binarysearch.lowerupperbound;

import util.Test;

/**
 * Find Smallest Common Element in All Rows
 * Pattern : Lower Bound Across Rows
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [For each candidate in row 0, lower-bound it in every other row; return on full hit]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P18_Find_Smallest_Common_Element_in_All_Rows {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P18_Find_Smallest_Common_Element_in_All_Rows sol = new P18_Find_Smallest_Common_Element_in_All_Rows();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.smallestCommonElement(new int[][]{{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}}), 5);

        Test.summary();
    }
}
