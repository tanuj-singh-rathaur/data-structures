package binarysearch.onanswers;

import util.Test;

/**
 * Minimum Time to Repair Cars
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers (sqrt predicate)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/minimum-time-to-repair-cars/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/minimum-time-to-repair-cars/
 *
 * PATTERN HINT:
 *   [BS time t in [1, min(rank)*cars^2]; predicate: sum(floor(sqrt(t/rank[i]))) >= cars]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P18_Minimum_Time_to_Repair_Cars {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P18_Minimum_Time_to_Repair_Cars sol = new P18_Minimum_Time_to_Repair_Cars();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.repairCars(new int[]{4,2,3,1}, 10), 16L);

        Test.summary();
    }
}
