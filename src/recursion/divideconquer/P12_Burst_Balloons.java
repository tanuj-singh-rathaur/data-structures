package recursion.divideconquer;

import util.Test;

/**
 * Burst Balloons
 * Topic    : Recursion
 * Pattern  : Divide & Conquer over Intervals (Memo)
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/burst-balloons/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/burst-balloons/
 *
 * PATTERN HINT:
 *   [Pad nums with 1s; for each interval (i, j) try LAST-burst k inside; combine. Memoise.]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P12_Burst_Balloons {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P12_Burst_Balloons sol = new P12_Burst_Balloons();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.maxCoins(new int[]{3,1,5,8}), 167);

        Test.summary();
    }
}
