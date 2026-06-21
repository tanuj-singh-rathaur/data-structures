package hashmap.frequency;

import util.Test;

/**
 * Contiguous Array
 * Topic    : HashMap
 * Pattern  : Prefix Sum + First-Index Map
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/contiguous-array/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/contiguous-array/
 *
 * PATTERN HINT:
 *   [Replace 0 with -1, then find longest subarray with sum=0 via map<sum, firstIndex>]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P09_Contiguous_Array {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P09_Contiguous_Array sol = new P09_Contiguous_Array();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.findMaxLength(new int[]{0,1}), 2);

        Test.summary();
    }
}
