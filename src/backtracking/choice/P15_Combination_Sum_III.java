package backtracking.choice;

import util.Test;

/**
 * Combination Sum III
 * Topic    : Backtracking
 * Pattern  : Choice-Based (Pick k distinct 1..9 summing to n)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/combination-sum-iii/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/combination-sum-iii/
 *
 * PATTERN HINT:
 *   [Backtrack from start..9; require path.size == k and remaining == 0 at base]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P15_Combination_Sum_III {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P15_Combination_Sum_III sol = new P15_Combination_Sum_III();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.combinationSum3(3, 7).size(), 1);

        Test.summary();
    }
}
