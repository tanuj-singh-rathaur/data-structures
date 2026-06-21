package binarysearch.onanswers;

import util.Test;

/**
 * Maximum Candies Allocated to K Children
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers (MAXIMIZE per-child)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
 *
 * PATTERN HINT:
 *   [BS amount a in [1, max(candies)]; predicate: sum(candies[i]/a) >= k]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P12_Maximum_Candies_Allocated_to_K_Children {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P12_Maximum_Candies_Allocated_to_K_Children sol = new P12_Maximum_Candies_Allocated_to_K_Children();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.maximumCandies(new int[]{5,8,6}, 3L), 5);

        Test.summary();
    }
}
