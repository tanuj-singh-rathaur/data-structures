package backtracking.choice;

import util.Test;

/**
 * Sudoku Solver
 * Topic    : Backtracking
 * Pattern  : Choice + Constraint Propagation (Row/Col/Box Masks)
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/sudoku-solver/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/sudoku-solver/
 *
 * PATTERN HINT:
 *   [For each empty cell try 1..9 if no conflict in row/col/3x3 box; backtrack on failure]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P13_Sudoku_Solver {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P13_Sudoku_Solver sol = new P13_Sudoku_Solver();

        // TODO: add test cases once you've implemented the method.

        Test.summary();
    }
}
