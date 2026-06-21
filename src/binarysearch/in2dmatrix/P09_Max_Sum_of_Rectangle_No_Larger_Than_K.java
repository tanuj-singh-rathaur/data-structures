package binarysearch.in2dmatrix;

import util.Test;

/**
 * Max Sum of Rectangle No Larger Than K
 * Pattern : Row-Compression + Prefix Sum + TreeSet ceiling
 * Difficulty: Hard
 * LeetCode  : https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Fix row pair (r1, r2); compress columns; running prefix; TreeSet.ceiling(prefix − k) finds candidate]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P09_Max_Sum_of_Rectangle_No_Larger_Than_K {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P09_Max_Sum_of_Rectangle_No_Larger_Than_K sol = new P09_Max_Sum_of_Rectangle_No_Larger_Than_K();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.maxSumSubmatrix(new int[][]{{1,0,1},{0,-2,3}}, 2), 2);

        Test.summary();
    }
}
