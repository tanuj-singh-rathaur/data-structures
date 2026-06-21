package backtracking.choice;

import util.Test;

/**
 * Non-decreasing Subsequences
 * Topic    : Backtracking
 * Pattern  : Choice-Based + Per-Level Dedup via HashSet
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/non-decreasing-subsequences/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/non-decreasing-subsequences/
 *
 * PATTERN HINT:
 *   [At each call use a HashSet to skip duplicate values at the same recursion level (can't sort!)]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P19_Increasing_Subsequences {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P19_Increasing_Subsequences sol = new P19_Increasing_Subsequences();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.findSubsequences(new int[]{4,6,7,7}).size(), 8);

        Test.summary();
    }
}
