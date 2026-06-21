package binarysearch.in2dmatrix;

import util.Test;

/**
 * Find the Kth Smallest Sum of a Matrix With Sorted Rows
 * Pattern : Binary Search on Sum + Heap Merge
 * Difficulty: Hard
 * LeetCode  : https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Merge two rows at a time keeping only the smallest k sums via heap; or BS the sum value]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P13_Find_Kth_Smallest_Sum_of_Matrix_With_Sorted_Rows {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P13_Find_Kth_Smallest_Sum_of_Matrix_With_Sorted_Rows sol = new P13_Find_Kth_Smallest_Sum_of_Matrix_With_Sorted_Rows();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.kthSmallest(new int[][]{{1,3,11},{2,4,6}}, 5), 7);

        Test.summary();
    }
}
