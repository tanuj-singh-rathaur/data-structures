package binarysearch.lowerupperbound;

import util.Test;

/**
 * Find Right Interval
 * Pattern : Sort Starts + Lower Bound per End
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/find-right-interval/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Pair (start, originalIndex); sort by start; for each interval lower-bound its end on starts]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P11_Find_Right_Interval {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P11_Find_Right_Interval sol = new P11_Find_Right_Interval();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.findRightInterval(new int[][]{{3,4},{2,3},{1,2}}),
        //     new int[]{-1, 0, 1});

        Test.summary();
    }
}
