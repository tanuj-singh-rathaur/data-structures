package binarysearch.in2dmatrix;

import util.Test;

/**
 * Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 * Pattern : 2D Prefix Sum + Binary Search Side Length
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Build 2D prefix sums; binary search side k; check if any k×k square has sum ≤ threshold]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P10_Max_Side_Length_of_Square_with_Sum_Threshold {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P10_Max_Side_Length_of_Square_with_Sum_Threshold sol = new P10_Max_Side_Length_of_Square_with_Sum_Threshold();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.maxSideLength(new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}}, 4), 2);

        Test.summary();
    }
}
