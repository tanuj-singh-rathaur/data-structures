package arrays.kadane;

import util.Test;

/**
 * K-Concatenation Maximum Sum
 * Pattern : Kadane on 1 or 2 copies + total * (K−2) if positive
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/k-concatenation-maximum-sum/
 * ─────────────────────────────────────────────
 * With array repeated K times, return the max subarray sum modulo 1e9+7.
 */
public class P09_K_Concatenation_Maximum_Sum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P09_K_Concatenation_Maximum_Sum sol = new P09_K_Concatenation_Maximum_Sum();
        Test.equal("Test 1", sol.kConcatenationMaxSum(new int[]{1,2}, 3), 9);
        Test.equal("Test 2", sol.kConcatenationMaxSum(new int[]{1,-2,1}, 5), 2);
        Test.equal("Test 3", sol.kConcatenationMaxSum(new int[]{-1,-2}, 7), 0);
        Test.summary();
    }
}
