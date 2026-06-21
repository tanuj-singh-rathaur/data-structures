package binarysearch.lowerupperbound;

import util.Test;

/**
 * Kth Missing Positive Number
 * Pattern : Binary Search on Missing Count
 * Difficulty: Easy/Medium
 * LeetCode  : https://leetcode.com/problems/kth-missing-positive-number/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Missing at index i = arr[i] − (i + 1); binary search smallest i where missing ≥ k]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P08_Kth_Missing_Positive_Number {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P08_Kth_Missing_Positive_Number sol = new P08_Kth_Missing_Positive_Number();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.findKthPositive(new int[]{2,3,4,7,11}, 5), 9);

        Test.summary();
    }
}
