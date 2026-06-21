package binarysearch.onanswers;

import util.Test;

/**
 * Nth Root of a Number
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers
 * Difficulty: Medium
 * LeetCode : Variant of https://leetcode.com/problems/sqrtx/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Given m, n find integer x such that x^n = m (or floor of nth root).
 *
 * PATTERN HINT:
 *   [BS x in [1, m]; predicate: x^n <= m. Use pow that breaks early to avoid overflow.]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P04_Nth_Root_of_a_Number {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P04_Nth_Root_of_a_Number sol = new P04_Nth_Root_of_a_Number();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.nthRoot(3, 27), 3);

        Test.summary();
    }
}
