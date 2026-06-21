package backtracking.choice;

import util.Test;

/**
 * Subsets II
 * Topic    : Backtracking
 * Pattern  : Choice-Based + Dedup at Same Recursion Level
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/subsets-ii/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/subsets-ii/
 *
 * PATTERN HINT:
 *   [Sort first; at index i: if (i > start && nums[i] == nums[i-1]) continue]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P02_Subsets_II {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P02_Subsets_II sol = new P02_Subsets_II();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.subsetsWithDup(new int[]{1,2,2}).size(), 6);

        Test.summary();
    }
}
