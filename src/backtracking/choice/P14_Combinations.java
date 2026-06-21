package backtracking.choice;

import util.Test;

/**
 * Combinations
 * Topic    : Backtracking
 * Pattern  : Choice-Based (Choose k from n)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/combinations/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/combinations/
 *
 * PATTERN HINT:
 *   [Backtrack from start..n; pick i, recurse i+1; prune when remaining < k - path.size]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P14_Combinations {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P14_Combinations sol = new P14_Combinations();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.combine(4, 2).size(), 6);

        Test.summary();
    }
}
