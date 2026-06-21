package binarysearch.onanswers;

import util.Test;

/**
 * Minimum Time to Complete Trips
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/minimum-time-to-complete-trips/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/minimum-time-to-complete-trips/
 *
 * PATTERN HINT:
 *   [BS time t in [1, min(time)*totalTrips]; predicate: sum(t / time[i]) >= totalTrips]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P17_Minimum_Time_to_Complete_Trips {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P17_Minimum_Time_to_Complete_Trips sol = new P17_Minimum_Time_to_Complete_Trips();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.minimumTime(new int[]{1,2,3}, 5), 3L);

        Test.summary();
    }
}
