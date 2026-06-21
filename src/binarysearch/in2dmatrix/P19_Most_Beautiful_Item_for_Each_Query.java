package binarysearch.in2dmatrix;

import util.Test;

/**
 * Most Beautiful Item for Each Query
 * Pattern : Sort + Prefix Max + Lower Bound per Query
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/most-beautiful-item-for-each-query/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Sort items by price; build prefix max of beauty; each query upper-bounds price then reads max]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P19_Most_Beautiful_Item_for_Each_Query {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P19_Most_Beautiful_Item_for_Each_Query sol = new P19_Most_Beautiful_Item_for_Each_Query();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.maximumBeauty(new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}}, new int[]{1,2,3,4,5,6}),
        //     new int[]{2,4,5,5,6,6});

        Test.summary();
    }
}
