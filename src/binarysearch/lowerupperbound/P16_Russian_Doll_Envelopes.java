package binarysearch.lowerupperbound;

import util.Test;

/**
 * Russian Doll Envelopes
 * Pattern : Sort then LIS via Lower Bound
 * Difficulty: Hard
 * LeetCode  : https://leetcode.com/problems/russian-doll-envelopes/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Sort width ascending, height descending (break ties); LIS on heights gives the answer]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P16_Russian_Doll_Envelopes {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P16_Russian_Doll_Envelopes sol = new P16_Russian_Doll_Envelopes();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}), 3);

        Test.summary();
    }
}
