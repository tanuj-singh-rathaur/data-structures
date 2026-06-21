package backtracking.choice;

import util.Test;

/**
 * Beautiful Arrangement
 * Topic    : Backtracking
 * Pattern  : Choice-Based + Divisibility Pruning
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/beautiful-arrangement/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/beautiful-arrangement/
 *
 * PATTERN HINT:
 *   [At position pos, try unused num n; valid if n % pos == 0 OR pos % n == 0]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P17_Beautiful_Arrangement {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P17_Beautiful_Arrangement sol = new P17_Beautiful_Arrangement();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.countArrangement(2), 2);

        Test.summary();
    }
}
