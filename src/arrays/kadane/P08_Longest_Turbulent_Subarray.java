package arrays.kadane;

import util.Test;

/**
 * Longest Turbulent Subarray
 * Pattern : Kadane (two states: last-was-up, last-was-down)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/longest-turbulent-subarray/
 * ─────────────────────────────────────────────
 * Longest subarray whose comparisons alternate strictly (< > < > ... or > < > < ...).
 */
public class P08_Longest_Turbulent_Subarray {

    public int maxTurbulenceSize(int[] arr) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P08_Longest_Turbulent_Subarray sol = new P08_Longest_Turbulent_Subarray();
        Test.equal("Test 1", sol.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}), 5);
        Test.equal("Test 2", sol.maxTurbulenceSize(new int[]{4,8,12,16}), 2);
        Test.equal("Test 3", sol.maxTurbulenceSize(new int[]{100}), 1);
        Test.summary();
    }
}
