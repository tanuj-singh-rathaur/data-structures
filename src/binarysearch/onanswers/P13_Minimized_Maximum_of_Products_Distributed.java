package binarysearch.onanswers;

import util.Test;

/**
 * Minimized Maximum of Products Distributed to Any Store
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 *
 * PATTERN HINT:
 *   [BS x in [1, max(quantities)]; predicate: sum(ceil(q[i]/x)) <= n]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P13_Minimized_Maximum_of_Products_Distributed {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P13_Minimized_Maximum_of_Products_Distributed sol = new P13_Minimized_Maximum_of_Products_Distributed();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.minimizedMaximum(6, new int[]{11,6}), 3);

        Test.summary();
    }
}
