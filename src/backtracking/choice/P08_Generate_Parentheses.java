package backtracking.choice;

import util.Test;

/**
 * Generate Parentheses
 * Topic    : Backtracking
 * Pattern  : Choice-Based + Validity Pruning
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/generate-parentheses/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/generate-parentheses/
 *
 * PATTERN HINT:
 *   [Track open and close counts; '(' allowed if open < n, ')' allowed if close < open]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P08_Generate_Parentheses {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P08_Generate_Parentheses sol = new P08_Generate_Parentheses();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.generateParenthesis(3).size(), 5);

        Test.summary();
    }
}
