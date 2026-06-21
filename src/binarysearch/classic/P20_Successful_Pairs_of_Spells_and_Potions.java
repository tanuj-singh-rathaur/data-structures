package binarysearch.classic;

import util.Test;

/**
 * Successful Pairs of Spells and Potions
 * Pattern : Classic Binary Search (Lower Bound per query)
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Sort potions; for each spell, binary search smallest potion p with spell*p ≥ success]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P20_Successful_Pairs_of_Spells_and_Potions {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P20_Successful_Pairs_of_Spells_and_Potions sol = new P20_Successful_Pairs_of_Spells_and_Potions();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7L),
        //     new int[]{4,0,3});

        Test.summary();
    }
}
