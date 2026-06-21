package binarysearch.in2dmatrix;

import util.Test;

/**
 * Find K Pairs with Smallest Sums
 * Pattern : Implicit Sorted Matrix + Heap (or BS on sum)
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Treat (i, j) sums as a sorted matrix; use a min-heap or BS the kth sum and reconstruct]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P15_Find_K_Pairs_with_Smallest_Sums {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P15_Find_K_Pairs_with_Smallest_Sums sol = new P15_Find_K_Pairs_with_Smallest_Sums();

        // TODO: add test cases once you've implemented the method. Example:
        // List&lt;List&lt;Integer&gt;&gt; expected = Arrays.asList(
        //     Arrays.asList(1, 2), Arrays.asList(1, 4), Arrays.asList(1, 6));
        // Test.equal("Test 1", sol.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3), expected);

        Test.summary();
    }
}
