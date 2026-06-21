package recursion.divideconquer;

import util.Test;

/**
 * Different Ways to Add Parentheses
 * Topic    : Recursion
 * Pattern  : Divide & Conquer at each Operator (Memoise)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/different-ways-to-add-parentheses/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/different-ways-to-add-parentheses/
 *
 * PATTERN HINT:
 *   [For each operator i, recurse left & right; combine cross-product. Memoise by substring.]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P04_Different_Ways_to_Add_Parentheses {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P04_Different_Ways_to_Add_Parentheses sol = new P04_Different_Ways_to_Add_Parentheses();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.diffWaysToCompute("2-1-1").size(), 2);

        Test.summary();
    }
}
