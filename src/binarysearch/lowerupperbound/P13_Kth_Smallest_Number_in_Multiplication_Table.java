package binarysearch.lowerupperbound;

import util.Test;

/**
 * Kth Smallest Number in Multiplication Table
 * Pattern : Binary Search on Value + Row Count
 * Difficulty: Hard
 * LeetCode  : https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Binary search v; count how many table entries ≤ v as Σ min(v/i, n); find smallest v with count ≥ k]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P13_Kth_Smallest_Number_in_Multiplication_Table {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P13_Kth_Smallest_Number_in_Multiplication_Table sol = new P13_Kth_Smallest_Number_in_Multiplication_Table();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.findKthNumber(3, 3, 5), 3);

        Test.summary();
    }
}
