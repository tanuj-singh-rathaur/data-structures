package binarysearch.onanswers;

import util.Test;

/**
 * Find the Smallest Divisor Given a Threshold
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 *
 * PATTERN HINT:
 *   [BS divisor d in [1, max(nums)]; predicate: sum(ceil(nums[i]/d)) <= threshold]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P09_Find_Smallest_Divisor {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P09_Find_Smallest_Divisor sol = new P09_Find_Smallest_Divisor();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.smallestDivisor(new int[]{1,2,5,9}, 6), 5);

        Test.summary();
    }
}
