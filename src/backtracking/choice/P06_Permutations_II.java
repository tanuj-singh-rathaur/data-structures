package backtracking.choice;

import util.Test;

/**
 * Permutations II
 * Topic    : Backtracking
 * Pattern  : Choice-Based + Dedup at Same Level
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/permutations-ii/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/permutations-ii/
 *
 * PATTERN HINT:
 *   [Sort; skip nums[i] if i > 0 && nums[i] == nums[i-1] && !used[i-1] — prefer the earliest unused]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P06_Permutations_II {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P06_Permutations_II sol = new P06_Permutations_II();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.permuteUnique(new int[]{1,1,2}).size(), 3);

        Test.summary();
    }
}
