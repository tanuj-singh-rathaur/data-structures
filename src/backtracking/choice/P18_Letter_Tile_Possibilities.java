package backtracking.choice;

import util.Test;

/**
 * Letter Tile Possibilities
 * Topic    : Backtracking
 * Pattern  : Choice-Based + Frequency Counter (Distinct Sequences)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/letter-tile-possibilities/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/letter-tile-possibilities/
 *
 * PATTERN HINT:
 *   [Count chars; for each letter with cnt > 0: pick once, recurse, count++; dedup naturally via frequency]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P18_Letter_Tile_Possibilities {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P18_Letter_Tile_Possibilities sol = new P18_Letter_Tile_Possibilities();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.numTilePossibilities("AAB"), 8);

        Test.summary();
    }
}
