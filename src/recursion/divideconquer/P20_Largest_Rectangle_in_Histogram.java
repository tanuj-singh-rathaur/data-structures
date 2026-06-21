package recursion.divideconquer;

import util.Test;

/**
 * Largest Rectangle in Histogram (Divide & Conquer variant)
 * Topic    : Recursion
 * Pattern  : Divide & Conquer at Min Element (Sparse Table for fast min)
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/largest-rectangle-in-histogram/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * PATTERN HINT:
 *   [Best rectangle either includes the min bar (width × min) or lies entirely left/right of it]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P20_Largest_Rectangle_in_Histogram {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P20_Largest_Rectangle_in_Histogram sol = new P20_Largest_Rectangle_in_Histogram();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.largestRectangleArea(new int[]{2,1,5,6,2,3}), 10);

        Test.summary();
    }
}
