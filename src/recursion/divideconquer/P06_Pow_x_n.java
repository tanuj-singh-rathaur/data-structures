package recursion.divideconquer;

import util.Test;

/**
 * Pow(x, n)
 * Topic    : Recursion
 * Pattern  : Divide & Conquer (Halve Exponent)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/powx-n/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/powx-n/
 *
 * PATTERN HINT:
 *   [x^n = (x^(n/2))^2 (× x if n odd). Handle negative n by 1/x^|n|. Watch INT_MIN.]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P06_Pow_x_n {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P06_Pow_x_n sol = new P06_Pow_x_n();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.myPow(2.0, 10), 1024.0);

        Test.summary();
    }
}
