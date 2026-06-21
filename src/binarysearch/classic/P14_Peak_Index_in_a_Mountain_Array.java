package binarysearch.classic;

import util.Test;

/**
 * Peak Index in a Mountain Array
 * Pattern : Classic Binary Search (Find Peak)
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [arr[mid] < arr[mid+1] → peak is to the right; else peak is at mid or left]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P14_Peak_Index_in_a_Mountain_Array {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P14_Peak_Index_in_a_Mountain_Array sol = new P14_Peak_Index_in_a_Mountain_Array();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.peakIndexInMountainArray(new int[]{0,1,0}), 1);

        Test.summary();
    }
}
