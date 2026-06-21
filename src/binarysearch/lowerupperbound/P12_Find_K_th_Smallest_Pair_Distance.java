package binarysearch.lowerupperbound;

import util.Test;

/**
 * Find K-th Smallest Pair Distance
 * Pattern : Binary Search Answer + Sliding Window Count
 * Difficulty: Hard
 * LeetCode  : https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Sort; binary search distance d in [0, max−min]; count pairs ≤ d via 2-pointer; find smallest d with count ≥ k]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P12_Find_K_th_Smallest_Pair_Distance {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P12_Find_K_th_Smallest_Pair_Distance sol = new P12_Find_K_th_Smallest_Pair_Distance();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.smallestDistancePair(new int[]{1,3,1}, 1), 0);

        Test.summary();
    }
}
