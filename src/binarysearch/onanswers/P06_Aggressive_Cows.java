package binarysearch.onanswers;

import util.Test;

/**
 * Aggressive Cows
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers (MAXIMIZE the MIN)
 * Difficulty: Medium
 * Source   : SPOJ / classic
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Place k cows in stalls (positions) so the minimum pairwise distance is maximised.
 *
 * PATTERN HINT:
 *   [Sort positions; BS distance d in [1, max-min]; predicate: greedy placement fits k cows]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P06_Aggressive_Cows {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P06_Aggressive_Cows sol = new P06_Aggressive_Cows();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.aggressiveCows(new int[]{1,2,4,8,9}, 3), 3);

        Test.summary();
    }
}
