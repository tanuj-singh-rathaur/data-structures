package backtracking.decision;

import util.Test;

/**
 * Letter Combinations of a Phone Number
 * Topic    : Backtracking
 * Pattern  : Decision Tree (k-way branch per digit)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * PATTERN HINT:
 *   [Each digit forces a decision among 3-4 letters; recurse on next index]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P01_Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        P01_Letter_Combinations_of_a_Phone_Number sol = new P01_Letter_Combinations_of_a_Phone_Number();
        Test.summary();
    }
}
