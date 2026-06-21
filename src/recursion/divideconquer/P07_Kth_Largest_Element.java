package recursion.divideconquer;

import util.Test;

/**
 * Kth Largest Element in an Array
 * Topic    : Recursion
 * Pattern  : Divide & Conquer (Quickselect)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/kth-largest-element-in-an-array/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * PATTERN HINT:
 *   [Quickselect: partition around pivot; recurse only into side containing the kth slot. Avg O(n)]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P07_Kth_Largest_Element {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P07_Kth_Largest_Element sol = new P07_Kth_Largest_Element();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5);

        Test.summary();
    }
}
