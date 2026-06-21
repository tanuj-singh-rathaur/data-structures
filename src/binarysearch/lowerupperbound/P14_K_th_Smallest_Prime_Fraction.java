package binarysearch.lowerupperbound;

import util.Test;

/**
 * K-th Smallest Prime Fraction
 * Pattern : Binary Search on Fraction Value
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/k-th-smallest-prime-fraction/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Binary search f in [0,1]; count fractions arr[i]/arr[j] ≤ f via 2-pointer; track best pair]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P14_K_th_Smallest_Prime_Fraction {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P14_K_th_Smallest_Prime_Fraction sol = new P14_K_th_Smallest_Prime_Fraction();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3), new int[]{2, 5});

        Test.summary();
    }
}
