package binarysearch.onanswers;

import util.Test;

/**
 * Median of Two Sorted Arrays
 * Topic    : Binary Search
 * Pattern  : Binary Search on Partition (search the split index, not the answer value directly)
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/median-of-two-sorted-arrays/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * PATTERN HINT:
 *   [BS partition i of smaller array in [0, m]; j = (m+n+1)/2 - i; check L1<=R2 && L2<=R1]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P20_Median_of_Two_Sorted_Arrays {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P20_Median_of_Two_Sorted_Arrays sol = new P20_Median_of_Two_Sorted_Arrays();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 2.0);

        Test.summary();
    }
}
