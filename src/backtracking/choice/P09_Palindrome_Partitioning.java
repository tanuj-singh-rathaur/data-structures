package backtracking.choice;

import util.Test;

/**
 * Palindrome Partitioning
 * Topic    : Backtracking
 * Pattern  : Choice-Based (Cut After Each Palindromic Prefix)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/palindrome-partitioning/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/palindrome-partitioning/
 *
 * PATTERN HINT:
 *   [From start, try every end e: if s[start..e] is a palindrome, add and recurse from e+1]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P09_Palindrome_Partitioning {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P09_Palindrome_Partitioning sol = new P09_Palindrome_Partitioning();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.partition("aab").size(), 2);

        Test.summary();
    }
}
