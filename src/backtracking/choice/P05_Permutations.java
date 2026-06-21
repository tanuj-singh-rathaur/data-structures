package backtracking.choice;

import util.Test;

/**
 * Permutations
 * Topic    : Backtracking
 * Pattern  : Choice-Based (Used-Set Mask, All Orderings)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/permutations/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/permutations/
 *
 * PATTERN HINT:
 *   [Track a 'used[]' array; for each position pick any unused number; recurse; unpick]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P05_Permutations {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P05_Permutations sol = new P05_Permutations();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.permute(new int[]{1,2,3}).size(), 6);

        Test.summary();
    }
}
