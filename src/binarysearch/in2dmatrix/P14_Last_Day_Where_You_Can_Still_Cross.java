package binarysearch.in2dmatrix;

import util.Test;

/**
 * Last Day Where You Can Still Cross
 * Pattern : Binary Search Day + BFS Cross Check
 * Difficulty: Hard
 * LeetCode  : https://leetcode.com/problems/last-day-where-you-can-still-cross/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Binary search the day d; on day d flood the first d cells; check top row reaches bottom row]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P14_Last_Day_Where_You_Can_Still_Cross {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P14_Last_Day_Where_You_Can_Still_Cross sol = new P14_Last_Day_Where_You_Can_Still_Cross();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.latestDayToCross(2, 2, new int[][]{{1,1},{2,1},{1,2},{2,2}}), 2);

        Test.summary();
    }
}
