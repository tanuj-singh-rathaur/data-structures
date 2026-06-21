package backtracking.choice;

import util.Test;

/**
 * Letter Case Permutation
 * Topic    : Backtracking
 * Pattern  : Choice-Based (Per-Letter Case Toggle)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/letter-case-permutation/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/letter-case-permutation/
 *
 * PATTERN HINT:
 *   [At each char: if letter, branch lower vs upper; else carry as-is. Recurse next index]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P16_Letter_Case_Permutation {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P16_Letter_Case_Permutation sol = new P16_Letter_Case_Permutation();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.letterCasePermutation("a1b2").size(), 4);

        Test.summary();
    }
}
