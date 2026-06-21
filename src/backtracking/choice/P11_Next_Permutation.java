package backtracking.choice;

import util.Test;

/**
 * Next Permutation
 * Topic    : Backtracking (Lexicographic order)
 * Pattern  : Permutation Successor (Not Pure Backtracking — Algorithmic)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/next-permutation/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/next-permutation/
 *
 * PATTERN HINT:
 *   [Scan from right: find first i with nums[i] < nums[i+1]; swap with smallest > nums[i] on its right; reverse suffix]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P11_Next_Permutation {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P11_Next_Permutation sol = new P11_Next_Permutation();

        // TODO: add test cases once you've implemented the method. Example:
        // int[] in = {1,2,3};
        // sol.nextPermutation(in);
        // Test.equal("Test 1", in, new int[]{1,3,2});

        Test.summary();
    }
}
