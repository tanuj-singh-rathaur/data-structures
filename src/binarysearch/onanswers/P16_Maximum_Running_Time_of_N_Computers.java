package binarysearch.onanswers;

import util.Test;

/**
 * Maximum Running Time of N Computers
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers (MAXIMIZE feasible runtime)
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/maximum-running-time-of-n-computers/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/maximum-running-time-of-n-computers/
 *
 * PATTERN HINT:
 *   [BS time t in [1, sum/N]; predicate: sum(min(batteries[i], t)) >= n*t]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P16_Maximum_Running_Time_of_N_Computers {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P16_Maximum_Running_Time_of_N_Computers sol = new P16_Maximum_Running_Time_of_N_Computers();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.maxRunTime(2, new int[]{3,3,3}), 4L);

        Test.summary();
    }
}
