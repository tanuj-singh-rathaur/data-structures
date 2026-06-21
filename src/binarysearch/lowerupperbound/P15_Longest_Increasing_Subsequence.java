package binarysearch.lowerupperbound;

import util.Test;

/**
 * Longest Increasing Subsequence
 * Pattern : Patience Sort (Lower Bound on Tails)
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/longest-increasing-subsequence/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Maintain "tails" array; for each num, lower-bound it; replace if found else append; length = LIS]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P15_Longest_Increasing_Subsequence {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P15_Longest_Increasing_Subsequence sol = new P15_Longest_Increasing_Subsequence();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}), 4);

        Test.summary();
    }
}
