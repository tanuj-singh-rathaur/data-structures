package backtracking.choice;

import util.Test;

/**
 * Letter Combinations of a Phone Number
 * Topic    : Backtracking
 * Pattern  : Choice-Based (Branch per Digit's Letters)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * PATTERN HINT:
 *   [Map digit → letters; at depth d pick any letter of digits[d]; recurse to d+1]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P07_Letter_Combinations_of_a_Phone_Number {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P07_Letter_Combinations_of_a_Phone_Number sol = new P07_Letter_Combinations_of_a_Phone_Number();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.letterCombinations("23").size(), 9);

        Test.summary();
    }
}
