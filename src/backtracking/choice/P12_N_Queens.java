package backtracking.choice;

import util.Test;

/**
 * N-Queens
 * Topic    : Backtracking
 * Pattern  : Choice per Row + Conflict Sets
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/n-queens/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/n-queens/
 *
 * PATTERN HINT:
 *   [Place one queen per row; track columns, diagonals (r-c) and anti-diagonals (r+c) sets to prune]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P12_N_Queens {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P12_N_Queens sol = new P12_N_Queens();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.solveNQueens(4).size(), 2);

        Test.summary();
    }
}
