package binarysearch.lowerupperbound;

import util.Test;

/**
 * Find the Duplicate Number
 * Pattern : Binary Search on Value Range
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/find-the-duplicate-number/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Binary search v in [1..n]; count nums ≤ v; if count > v, dup is in [1..v]]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P07_Find_the_Duplicate_Number {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P07_Find_the_Duplicate_Number sol = new P07_Find_the_Duplicate_Number();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.findDuplicate(new int[]{1,3,4,2,2}), 2);

        Test.summary();
    }
}
