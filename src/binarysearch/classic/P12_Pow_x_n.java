package binarysearch.classic;

import util.Test;

/**
 * Pow(x, n)
 * Pattern : Classic Binary Search (Fast Power / Recursive Halving)
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/powx-n/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Halve the exponent each step: x^n = (x^(n/2))^2 * (x if n odd); handle negative n via 1/x]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P12_Pow_x_n {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P12_Pow_x_n sol = new P12_Pow_x_n();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", (long) sol.myPow(2.0, 10), 1024L);

        Test.summary();
    }
}
