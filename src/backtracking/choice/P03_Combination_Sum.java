package backtracking.choice;

import util.Test;

/**
 * Combination Sum
 * Topic    : Backtracking
 * Pattern  : Choice-Based (Reuse Allowed, Same Index)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/combination-sum/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/combination-sum/
 *
 * PATTERN HINT:
 *   [Sort; backtrack from start: pick candidates[i] (recurse with same i), or skip to i+1]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P03_Combination_Sum {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P03_Combination_Sum sol = new P03_Combination_Sum();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.combinationSum(new int[]{2,3,6,7}, 7).size(), 2);

        Test.summary();
    }
}
