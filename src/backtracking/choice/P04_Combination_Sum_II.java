package backtracking.choice;

import util.Test;

/**
 * Combination Sum II
 * Topic    : Backtracking
 * Pattern  : Choice-Based + Dedup at Level (Each Number Used Once)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/combination-sum-ii/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/combination-sum-ii/
 *
 * PATTERN HINT:
 *   [Sort; recurse i+1; skip i if (i > start && candidates[i] == candidates[i-1])]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P04_Combination_Sum_II {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P04_Combination_Sum_II sol = new P04_Combination_Sum_II();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8).size(), 4);

        Test.summary();
    }
}
