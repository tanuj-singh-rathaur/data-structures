package binarysearch.onanswers;

import util.Test;

/**
 * Earliest Day to Make Bouquets (LC Variant)
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers
 * Difficulty: Medium
 * LeetCode : Generalisation of #1482
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Given bloomDay, m bouquets each needing k *distinct-group* contiguous adjacent flowers, min day.
 *
 * PATTERN HINT:
 *   [BS day; predicate: count maximal adjacent runs of bloomed flowers / k summed >= m]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P14_Earliest_Day_to_Make_Bouquets {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P14_Earliest_Day_to_Make_Bouquets sol = new P14_Earliest_Day_to_Make_Bouquets();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.minDays(new int[]{7,7,7,7,12,7,7}, 2, 3), 12);

        Test.summary();
    }
}
