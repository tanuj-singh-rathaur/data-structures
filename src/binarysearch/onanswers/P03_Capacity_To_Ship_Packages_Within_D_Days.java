package binarysearch.onanswers;

import util.Test;

/**
 * Capacity To Ship Packages Within D Days
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * PATTERN HINT:
 *   [BS capacity in [max(weights), sum(weights)]; predicate: greedy pack into ≤ d days at capacity c]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P03_Capacity_To_Ship_Packages_Within_D_Days {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P03_Capacity_To_Ship_Packages_Within_D_Days sol = new P03_Capacity_To_Ship_Packages_Within_D_Days();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5), 15);

        Test.summary();
    }
}
